/**
 * 
 */
package com.thinkgem.jeesite.modules.enterprise.web.sanheyi;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.CmsSlide;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CmsSlideService;
import com.thinkgem.jeesite.modules.sys.service.SysResourceRelationService;

/**
 * @Project:hezhengbaoo  
 * @Class：ProjectController 
 * @author 高希阳
 * @date 2016-9-19 上午11:43:00   
 * @version 1.0.0 
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class ProjectController {
	
Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CmsSlideService cmsSlideService;
	@Autowired
	private ArticleDataService articleDataService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublicHzbController publicController;
	
	@RequestMapping(value = "projectdetail/{child}/{categoryid}/{contentId}.html")
	public String view(@PathVariable String child,@PathVariable String categoryid,
			@PathVariable String contentId, Model model) {
		Category category = categoryService.get(child);
		if ("article".equals(category.getModule())) {
			// 获取文章内容
			Article article = articleService.get(contentId);
			if (article == null || !Article.DEL_FLAG_NORMAL.equals(article.getDelFlag())) {
				return "error/404";
			}
			// 文章阅读次数+1
			articleService.updateHitsAddOne(contentId);
			article.setArticleData(articleDataService.get(article.getId()));
			//栏目图片
			String imageUrl = publicController.selectImage(child);
			
			model.addAttribute("imageUrl",imageUrl);
			model.addAttribute("article", article);
			model.addAttribute("child",child);
			model.addAttribute("categoryid",categoryid);
		}
		return "wwwpage/hezhengbao/HZB_project_cooperation_detail";
		
	}

	@RequestMapping(value="projectlist/{child}")
	public ModelAndView selectAllNewss(HttpServletRequest request, HttpServletResponse response,@PathVariable String child){
		Map<String, Object> map = new HashMap<String, Object>();
		Category cat  = new Category();
		cat.setId(child);
		CmsSlide cms = new CmsSlide();
		cms.setCategoryid(child);
		cms.setDelFlag("0");
		Page<CmsSlide> initPage = new Page<CmsSlide>(request, response);
		initPage.setPageSize(6);
		initPage.setFront(true);
		Page<CmsSlide> page = cmsSlideService.findPage(initPage, cms); 
//		栏目图片
		String imageUrl = publicController.selectImage(child);
		cat=categoryService.get(child);
		map.put("imageUrl",imageUrl);
		map.put("page",page);
		map.put("categoryid",child);
		map.put("child",child);
		return new ModelAndView ("wwwpage/sanheyi/SHY_Product_display",map);
	}
}
