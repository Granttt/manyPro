package com.thinkgem.jeesite.modules.enterprise.web.sanheyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.CmsSlide;
import com.thinkgem.jeesite.modules.cms.entity.Link;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CmsSlideService;
import com.thinkgem.jeesite.modules.cms.service.LinkService;
import com.thinkgem.jeesite.modules.cms.web.LinkController;

/**
 * 首页-Products
 * @Theme:
 * @Author:gaoxiyang
 * @Date:2016-5-12下午1:33:45
 * @Description:
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class IndexController extends BaseController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CmsSlideService cmsSlideService;	
	
	@RequestMapping()
	public String index(Model model) {
		
		return this.indexhzb(model);
	}
	@RequestMapping(value = "index.html")
	public String indexhzb(Model model) {
		
		CmsSlide cmsSlide=new CmsSlide();
		cmsSlide.setHomeView("1");
		cmsSlide.setCategoryid("24");
		List<CmsSlide> cmslist=cmsSlideService.findList(cmsSlide);
		
		model.addAttribute("categoryid", "2");
		model.addAttribute("cmslist", cmslist);
		return "wwwpage/sanheyi/MSV_HTML";
	}
	/**
     *返回json给前台ajax
     *Spring框架的@ResponseBody注解可自动返回json
     *@ResponseBody可以直接返回json数据
     *@return void
     */
	@RequestMapping(value="/ajaxJson.json",method=RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> check(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		String aString=request.getParameter("parameter1");
		String bString=request.getParameter("parameter2");
		String cString=bString+aString;
		System.out.println(cString);
		map.put("cString", cString);
		return map;
    }
}
