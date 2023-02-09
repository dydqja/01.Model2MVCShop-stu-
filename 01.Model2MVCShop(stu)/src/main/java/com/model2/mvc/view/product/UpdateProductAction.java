package com.model2.mvc.view.product;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		System.out.println("여기는 UpdateProductAction 내부");
		
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		System.out.println("request.getParameter로 받은 prodNo 값은? ="+prodNo);
		
		ProductVO productVO=new ProductVO();
		productVO.setProdNo(prodNo);
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));		
		//productVO.setRegDate(request.getParameter("regDate")); <== getParameter는 String값이라 Date type인 RegDate 로 받을 수 없음
		//productVO.setRegDate(SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("price")));  // <== 실패
		//productVO.setRegDate((valueOF(request.getParameter("regDate"))));	// <== 된건가..? 실패
						
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);
		
		System.out.println("========여기까진 문제없음========");
		
		//HttpSession session=request.getSession();
		
		//int sessionId=((ProductVO)session.getAttribute("product")).getProdNo();
		
		
		//System.out.println(sessionId);
		
		

		//request.setAttribute("product", productVO); ###
//		if(sessionId==prodNo){
//			session.setAttribute("product", productVO);
//		}
		
		return "redirect:/getProduct.do?prodNo="+prodNo; // 다시. getProductAction? jsp?? // 여기로 가서 등록일자 가져오기?
		//return "forward:/product/getProduct.jsp"; // <== jsp로 바로가니까 등록일자 정보를 못가져옴.
	}

	
}