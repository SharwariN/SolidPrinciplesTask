package com.ms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
       
    	SessionFactory sf = HibernateUtil.getSessionFactory();
    	Session session = sf.openSession();
    	
        session.beginTransaction();
        
        Locker locker = new Locker();
        locker.setRent(10000);
        locker.setLockerType("Big");
        
        Customer customer = new Customer();
        customer.setCustomerName("Shashank");
        customer.setDateofBirth("22-10-1999");
        customer.setAddress("Pune");
        customer.setPhone("9404002951");
        customer.setLocker(locker);
        
        session.save(customer);
        
        session.getTransaction().commit();
        
        session.close();
        
    }
}
