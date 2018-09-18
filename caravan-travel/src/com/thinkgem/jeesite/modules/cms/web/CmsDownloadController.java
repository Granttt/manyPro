/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.CmsDownload;
import com.thinkgem.jeesite.modules.cms.service.CmsDownloadService;

/**
 * 下载模型Controller
 * @author allen
 * @version 2016-02-23
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsDownload")
public class CmsDownloadController extends BaseController {

	@Autowired
	private CmsDownloadService cmsDownloadService;
	
	@ModelAttribute
	public CmsDownload get(@RequestParam(required=false) String id) {
		CmsDownload entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsDownloadService.get(id);
		}
		if (entity == null){
			entity = new CmsDownload();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsDownload:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsDownload cmsDownload, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsDownload> page = cmsDownloadService.findPage(new Page<CmsDownload>(request, response), cmsDownload); 
		model.addAttribute("page", page);
		return "modules/cms/cmsDownloadList";
	}

	@RequiresPermissions("cms:cmsDownload:view")
	@RequestMapping(value = "form")
	public String form(CmsDownload cmsDownload, Model model) {
		model.addAttribute("cmsDownload", cmsDownload);
		return "modules/cms/cmsDownloadForm";
	}

	@RequiresPermissions("cms:cmsDownload:edit")
	@RequestMapping(value = "save")
	public String save(CmsDownload cmsDownload, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsDownload)){
			return form(cmsDownload, model);
		}
		cmsDownloadService.save(cmsDownload);
		addMessage(redirectAttributes, "保存下载文件成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsDownload/?repage";
	}
	
	@RequiresPermissions("cms:cmsDownload:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsDownload cmsDownload, RedirectAttributes redirectAttributes) {
		cmsDownloadService.delete(cmsDownload);
		addMessage(redirectAttributes, "删除下载文件成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsDownload/?repage";
	}

}