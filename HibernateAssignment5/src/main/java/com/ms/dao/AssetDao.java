package com.ms.dao;

import com.ms.Model.Asset;

public interface AssetDao {

	public void addAsset(Asset asset);
	
	public Asset getAssetDetailsWithMaxPrice();
	
}
