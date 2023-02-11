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
		
		System.out.println("����� UpdateProductAction ����");		
		System.out.println("menu��?=================");
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
		//productVO.setRegDate(request.getParameter("regDate")); <== getParameter�� String���̶� Date type�� RegDate �� ���� �� ����
		//productVO.setRegDate(SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("price")));  // <== ����
		//productVO.setRegDate((valueOF(request.getParameter("regDate"))));	// <== �Ȱǰ�..? ����
						
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);
		
		System.out.println("========������� ��������========");
		
		
		
		//return "redirect:/getProduct.do?prodNo=&munu="+prodNo+manu; // �ٽ�. �޴����� ���� getProductAction���� �ѱ�����.
																	// name,value name,value
		return "forword:/getProduct.do?prodNo="+prodNo+"&menu="+manu;
		
		
	}

	
}