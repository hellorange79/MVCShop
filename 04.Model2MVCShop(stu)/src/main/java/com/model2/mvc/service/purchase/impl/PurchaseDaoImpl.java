package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;


@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession ) {
		this.sqlSession= sqlSession;
	}
	public PurchaseDaoImpl() {
		System.out.println(this.getClass());
	}
	
	public void insertPurchase(Purchase purchase) throws Exception {
		sqlSession.insert("PurchaseMapper.addPurchase",purchase);
		
	}

	@Override
	public Purchase findPurchase(int prodNo) throws Exception {
		
		return sqlSession.selectOne("PurchaseMapper.getPurchase", prodNo);
	}

	@Override
	public Purchase findPurchase2(int tranNo) throws Exception {
		
		return sqlSession.selectOne("PurchaseMapper.getPurchase2", tranNo);
	}

	@Override
	public List<Purchase> getPurchaseList(Search search, String buyerId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("PurchaseMapper.getPurchaseList", search,buyerId);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		sqlSession.update("ProductMapper.updatePurchase", purchase);
		
	}

	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		sqlSession.update("ProductMapper.updateTranCode", purchase);
		
		
	}
	
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}
	
}
