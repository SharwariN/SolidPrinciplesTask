package com.ms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ms.Model.Asset;
import com.ms.util.HibernateUtil;

public class AssetDaoImpl implements AssetDao {

	public void addAsset(Asset asset) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.persist(asset);
		
		session.getTransaction().commit();
		
		session.close();
		
	}

	public Asset getAssetDetailsWithMaxPrice() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT MAX(A.assetPrice) FROM Asset A", Integer.class);
		
		Integer result = (Integer) query.getSingleResult();
		
		Query query2 = session.createQuery("SELECT * FROM Asset A where A.assetPrice = :assetPrice");
		query2.setParameter("assetPrice", result);
		
		Asset asset = (Asset) query2.getSingleResult();
		
		return asset;
	}

}
