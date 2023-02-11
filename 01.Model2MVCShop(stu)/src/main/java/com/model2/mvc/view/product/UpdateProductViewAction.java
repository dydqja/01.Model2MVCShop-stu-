package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class UpdateProductViewAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		System.out.println("여기는 UpdateProductViewAction 내부");		
		System.out.println("menu값은?? = ");
		System.out.println(request.getParameter("menu"));
		
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService service=new ProductServiceImpl();
		ProductVO productVO = service.getProduct(prodNo);
		
		System.out.println("prodNo를 받은 vo 값은 = " + productVO);
		
		request.setAttribute("productVO", productVO);		

		//return "forward:/product/readProduct.jsp";
		//return "forward:/listProductManage.do?prodNo";  updateproductview로 가야되는거 아님?
		return "forward:/product/updateProductView.jsp";		
	}
}
