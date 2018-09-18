package com.thinkgem.jeesite.modules.enterprise.web.sanheyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;

@Controller
@RequestMapping(value = "${frontPath}")
public class AboutController extends BaseController {
	@Autowired
	private PublicHzbController publicController;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleDataService articleDataService;
	
	
	
		//公司简介
		@RequestMapping(value="enterprise/{child}.html")
		public ModelAndView enterprise(HttpServletRequest request, HttpServletResponse response,@PathVariable String child){
			Map<String, Object> map = new HashMap<String, Object>();
			String imageUrl = publicController.selectImage(child);
			Category cat  = new Category();
			cat.setId(child);
			cat=categoryService.get(child);
			map.put("categoryid",cat.getParentId());
			map.put("imageUrl",imageUrl);
			map.put("child",child);
			return new ModelAndView("wwwpage/sanheyi/SHY_company_profile",map);
		}
		
		//总裁致辞
		@RequestMapping(value="president/{child}.html")
		public ModelAndView president(HttpServletRequest request, HttpServletResponse response,@PathVariable String child){
			Map<String, Object> map = new HashMap<String, Object>();
			String imageUrl = publicController.selectImage(child);
			Category cat  = new Category();
			cat.setId(child);
			cat=categoryService.get(child);
			map.put("categoryid",cat.getParentId());
			map.put("imageUrl",imageUrl);
			map.put("child",child);
			return new ModelAndView("wwwpage/hezhengbao/about/HZB_president_speech",map);
		}
		
		
		//管理团队
		@RequestMapping(value="management/{child}.html")
		public ModelAndView management(HttpServletRequest request, HttpServletResponse response,@PathVariable String child) {
			Map<String, Object> map = new HashMap<String, Object>();
			String imageUrl = publicController.selectImage(child);
			Category cat  = new Category();
			cat.setId(child);
			cat=categoryService.get(child);
			map.put("categoryid",cat.getParentId());
			map.put("imageUrl",imageUrl);
			map.put("child",child);
			
			Article art = new Article();
			art.setCategory(cat);
			art.setDelFlag("0");
			Page<Article> initPage = new Page<Article>(request, response);
			initPage.setPageSize(4);
			Page<Article> page = articleService.findPage(initPage, art, true); 
			
			map.put("page",page);
			return new ModelAndView("wwwpage/hezhengbao/about/HZB_management_team",map);
		}
		
		
}
