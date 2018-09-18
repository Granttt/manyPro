package com.thinkgem.jeesite.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;


@Controller
@RequestMapping("/web/testJsp")
public class TestJsp {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping("/anli")
	public String anli(){
		return "wwwpage/beixin/anli";
	}
	@RequestMapping("/core")
	public String core(){
		return "wwwpage/beixin/core";
	}
	@RequestMapping("/deed")
	public String deed(){
		return "wwwpage/beixin/deed";
	}
	@RequestMapping("/new")
	public String newn(){
		return "wwwpage/beixin/new";
	}
	@RequestMapping("/news")
	public String news(){
		return "wwwpage/beixin/news";
	}
	
	@RequestMapping("/guide")
	public String guide(){
		return "wwwpage/beixin/guide";
	}
	@RequestMapping("/index")
	public String index(){
		return "wwwpage/beixin/index";
	}
	@RequestMapping("/product_idea/{child}")
	public ModelAndView  product_idea(HttpServletRequest request,HttpServletResponse response,@PathVariable String child){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("child", child);
		
		
		return new ModelAndView("wwwpage/beixin/product-idea", map);
	}
	
	@RequestMapping("/product_type/{child}")
	public ModelAndView product_type(HttpServletRequest request, HttpServletResponse response, @PathVariable String child){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("child", child);

		
		return new ModelAndView("wwwpage/beixin/product-type", map);
	}
	
	@RequestMapping("/shichang")
	public String shichang(){
		return "wwwpage/beixin/shichangfenbu";
	}
	@RequestMapping("/video")
	public String video(){
		return "wwwpage/beixin/video-center";
	}
	@RequestMapping("/yi")
	public String yi(){
		return "wwwpage/beixin/yihujian";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus(){
		return "wwwpage/beixin/aboutus";
	}
	
	@RequestMapping("/picture")
	public String picture(){
		return "wwwpage/beixin/picture";
	}
	
	@RequestMapping("/cascade")
	public String cascade(Map<String,Object> map){
	
		
		
		//CategoryService categoryService =(CategoryService)ac.getBean("categoryService");
	/*	List<Category> topCategory=categoryService.getTopCategory("0");
		
		List<Category> categoryList=categoryService.findAllCategory(topCategory);
		
		map.put("list", categoryList);*/
		return "wwwpage/beixin/cascade";
	}
	
	
	


}
