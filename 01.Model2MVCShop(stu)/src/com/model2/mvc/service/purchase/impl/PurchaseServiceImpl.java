package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService {
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		
	}
	
	//����
	public void addPurchase(PurchaseVO purchaseVO)throws Exception{
		purchaseDAO = new PurchaseDAO();
	}

	@Override
	public PurchaseVO getPurchase(int tranNo) throws Exception {
		
		
		return null;
	}

	@Override
	public PurchaseVO getPurchase2(int ProdNo) throws Exception {
		
		
		return null;
	}

	@Override
	public HashMap<String, Object> getPurchaseList(Search search, String buyerId) throws Exception {
		
		return null;
	}

	@Override
	public HashMap<String, Object> getSaleList(Search search) throws Exception {
		
		return null;
	}

	@Override
	public void updatePurcahse(PurchaseVO purchaseVO) throws Exception {
		
		
	}

	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
		
		
	}
	

	
	

}
