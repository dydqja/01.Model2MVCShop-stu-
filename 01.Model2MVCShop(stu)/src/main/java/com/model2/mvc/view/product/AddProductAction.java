package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;



public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		System.out.println("여기는 AddProductAction 내부");
		
		ProductVO productVO = new ProductVO();
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));		
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));		
		productVO.setFileName(request.getParameter("fileName"));		
		
		ProductService service = new ProductServiceImpl();
		service.addProduct(productVO);
		//db 저장끝
		request.setAttribute("vo", productVO);
		
		
		return "forward:/product/readProduct.jsp";
	}
}