package com.thinkgem.jeesite.modules.enterprise.web.sanheyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.thinkgem.jeesite.modules.cms.entity.Site;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;
import com.thinkgem.jeesite.modules.sys.service.SysResourceRelationService;


@Controller
@RequestMapping(value = "${frontPath}")
public class NewsShyController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleDataService articleDataService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SysResourceRelationService sysResourceRelationService;
	@Autowired
	private PublicHzbController publicController;
	
	@RequestMapping(value = "articledetail/{contentId}.html")
	public String view(@PathVariable String contentId, Model model) {
//		Category category = categoryService.get(child);
//		if ("article".equals(category.getModule())) {
			// 获取文章内容
			Article article = articleService.get(contentId);
			Category category = categoryService.get(article.getCategory().getId());
			if (article == null || !Article.DEL_FLAG_NORMAL.equals(article.getDelFlag())) {
				return "error/404";
			}
			// 文章阅读次数+1
			articleService.updateHitsAddOne(contentId);
			article.setArticleData(articleDataService.get(article.getId()));
			//上一篇与下一篇
			List<Article> articles=articleService.findArticleByCategoryId(category.getId());
			for(int i=0;i<articles.size();i++){
				Article articleSelected =articles.get(i);
				if(contentId!=null&&contentId.equals(articleSelected.getId())){
					if(i-1>=0){
						Article articleUp=articles.get(i-1);
						articleUp.setArticleData(articleDataService.get(articleUp.getId()));
						model.addAttribute("up", articleUp);
					}else{
						model.addAttribute("up", null);
					}
					if(i+1<articles.size()){
						Article articleDown=articles.get(i+1);
						articleDown.setArticleData(articleDataService.get(articleDown.getId()));
						model.addAttribute("down", articleDown);
					}else{
						model.addAttribute("down", null);
					}
				}
			}
			
			
			
			//栏目图片
			String imageUrl = publicController.selectImage(article.getCategory().getId());
			model.addAttribute("imageUrl",imageUrl);
			model.addAttribute("article", article);
			model.addAttribute("child",article.getCategory().getId());
			model.addAttribute("categoryid",category.getParentId());
//		}
		return "wwwpage/sanheyi/SHY_news";
		
	}

	@RequestMapping(value="newslist/{child}")
	public ModelAndView selectAllNews(HttpServletRequest request, HttpServletResponse response,@PathVariable String child){
		Map<String, Object> map = new HashMap<String, Object>();
		Category cat  = new Category();
		cat.setId(child);
		Article art = new Article();
		art.setCategory(cat);
		art.setDelFlag("0");
		Page<Article> initPage = new Page<Article>(request, response);
		initPage.setPageSize(6);
		initPage.setFront(true);
		Page<Article> page = articleService.findPage(initPage, art, true); 
//		栏目图片
		String imageUrl = publicController.selectImage(child);
		cat=categoryService.get(child);
		map.put("imageUrl",imageUrl);
		map.put("page",page);
		map.put("categoryid",cat.getParentId());
		map.put("child",child);
		return new ModelAndView ("wwwpage/sanheyi/SHY_news_list",map);
	}
}
