package com.isoftstone.gyl.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.ProductService;
import com.isoftstone.gyl.domain.basedata.Product;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.basedata.ProductQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{

	@Resource(name="productService")
	private ProductService productService;
	
	private ProductQuery baseQuery = new ProductQuery();

	
	public String showPageResult(){
		System.out.println(baseQuery.getCurrentPage());
		String currStr = ServletActionContext.getRequest().getParameter("currentPage");
		System.out.println(currStr);
		if(currStr==null){
			baseQuery.setCurrentPage(1);
			System.out.println(baseQuery.getCurrentPage());
		}else{
			Integer currentpage = Integer.parseInt(currStr);
			baseQuery.setCurrentPage(currentpage);
			System.out.println(currentpage);
		}
		
		PageResult<Product> pageResult = this.productService.getPageResult(this.baseQuery);
		//List<Product> products = pageResult.getRows();
		ActionContext.getContext().put("productsPageResult", pageResult);
		return LISTACTION;
	}
	public String deleteProductById(){
		String currStr = ServletActionContext.getRequest().getParameter("pid");
		if(currStr!=null){
			
			this.productService.deleteEntity(Long.parseLong(currStr));
		}
		return SUCCESS;
	}
	
	public String addUI(){
		
		return ADDUI;
	}
	
	public String addProduct(){
		Product product = super.getModel();
		System.out.println(product);
		this.productService.saveEntity(product);
		return SUCCESS;
	}
	
	public String getAllProduct(){
		Collection<Product> products = this.productService.getEntities();
		ActionContext.getContext().getValueStack().push(products);
		return "json";
	};
	public String getProductByIds(){
		String pids = ServletActionContext.getRequest().getParameter("pids");
		String[] pidss = pids.split("_");
		System.out.println(pids);
		Collection<Product> products = this.productService.getEntitiesByids(pidss);
		System.out.println("商品个数："+products.size());
		ActionContext.getContext().getValueStack().push(products);
		return "json";
	}
	
}
