/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.CmsSlide;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CmsSlideService;

/**
 * 幻灯片Controller
 * @author liuxiaoyu
 * @version 2015-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsSlide")
public class CmsSlideController extends BaseController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private CmsSlideService cmsSlideService;
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute
	public CmsSlide get(@RequestParam(required=false) String id) {
		CmsSlide entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsSlideService.get(id);
		}
		if (entity == null){
			entity = new CmsSlide();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsSlide:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsSlide cmsSlide,HttpServletRequest request, HttpServletResponse response, Model model) {
		if (StringUtils.isEmpty(cmsSlide.getCategoryid())) {
			String categoryid = request.getParameter("category.id");
			cmsSlide.setCategoryid(categoryid);
		}
		Page<CmsSlide> page = cmsSlideService.findPage(new Page<CmsSlide>(request, response), cmsSlide); 
		model.addAttribute("page", page);
		model.addAttribute("categoryid",cmsSlide.getCategoryid());
		return "modules/cms/cmsSlideList";
	}

	@RequiresPermissions("cms:cmsSlide:view")
	@RequestMapping(value = "form")
	public String form(CmsSlide cmsSlide, Model model,HttpServletRequest request, HttpServletResponse response) {
		String catid = request.getParameter("categoryid");
		Category category = categoryService.get(catid);
		if (StringUtils.isEmpty(cmsSlide.getId())) {
			cmsSlide.setCategoryid(catid);
		}
		cmsSlide.setImagehref(category.getHref());
		model.addAttribute("cmsSlide", cmsSlide);
		return "modules/cms/cmsSlideForm";
	}

	@RequiresPermissions("cms:cmsSlide:edit")
	@RequestMapping(value = "save")
	public String save(CmsSlide cmsSlide, Model model, HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsSlide)){
			return form(cmsSlide, model,request,response);
		}
		cmsSlideService.save(cmsSlide);
		addMessage(redirectAttributes, "保存图片成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsSlide/?category.id="+cmsSlide.getCategoryid()+"&repage";
	}
	
	@RequiresPermissions("cms:cmsSlide:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsSlide cmsSlide, RedirectAttributes redirectAttributes) {
		cmsSlideService.delete(cmsSlide);
		addMessage(redirectAttributes, "删除图片成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsSlide/?category.id="+cmsSlide.getCategoryid()+"&repage";
	}

}