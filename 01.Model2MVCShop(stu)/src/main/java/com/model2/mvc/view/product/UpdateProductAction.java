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
		System.out.println("menu값?=================");
		System.out.println(request.getParameter("menu"));
		
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		String manu = request.getParameter("menu");
		
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
		
		
		
		//return "redirect:/getProduct.do?prodNo=&munu="+prodNo+manu; // 다시. 메뉴값을 같이 getProductAction으로 넘기고싶음.
																	// name,value name,value
		return "forword:/getProduct.do?prodNo="+prodNo+"&menu="+manu;
		
		
	}

	
}