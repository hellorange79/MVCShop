package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

public class UpdatePurchaseAction extends Action {
	
	public String execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		
		String userId = ((User) session.getAttribute("user")).getUserId();
		
		int tranNo =Integer.parseInt(request.getParameter("tranNo"));
		
		UserService userService = new UserServiceImpl();
		User user = userService.getUser(userId);
		
		
		PurchaseVO purchaseVO=new PurchaseVO();
		
		purchaseVO.setBuyer(((User) session.getAttribute("user")));
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(request.getParameter("divyAddr"));
		purchaseVO.setDivyRequest(request.getParameter("divyRequest"));
		purchaseVO.setDivyDate(request.getParameter("divyDate"));
		System.out.println("updatePurchase : "+purchaseVO);
		
		
		PurchaseService purchaseService=new PurchaseServiceImpl();
		purchaseService.updatePurcahse(purchaseVO);
		
		
		request.setAttribute("purchaseVO", purchaseVO);
		
		return "redirect:/getPurchase.do?tranNo="+tranNo;
	}
	

}