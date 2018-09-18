/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import java.util.Date;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.SysMediaResource;
import com.thinkgem.jeesite.modules.sys.service.SysMediaResourceService;

/**
 * 系统多媒体资源管理Controller
 * @author liuxiaoyu
 * @version 2015-11-04
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysMediaResource")
public class SysMediaResourceController extends BaseController {

	@Autowired
	private SysMediaResourceService sysMediaResourceService;
	
	@ModelAttribute
	public SysMediaResource get(@RequestParam(required=false) String id) {
		SysMediaResource entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysMediaResourceService.get(id);
		}
		if (entity == null){
			entity = new SysMediaResource();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysMediaResource:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysMediaResource sysMediaResource, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysMediaResource> page = sysMediaResourceService.findPage(new Page<SysMediaResource>(request, response), sysMediaResource); 
		model.addAttribute("page", page);
		return "modules/sys/sysMediaResourceList";
	}

	@RequiresPermissions("sys:sysMediaResource:view")
	@RequestMapping(value = "form")
	public String form(SysMediaResource sysMediaResource, Model model) {
		model.addAttribute("sysMediaResource", sysMediaResource);
		return "modules/sys/sysMediaResourceForm";
	}

	@RequiresPermissions("sys:sysMediaResource:edit")
	@RequestMapping(value = "save")
	public String save(SysMediaResource sysMediaResource, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysMediaResource)){
			return form(sysMediaResource, model);
		}
		if (StringUtils.isEmpty(sysMediaResource.getId())){
			sysMediaResource.setCreateDate(new Date());
		}
		sysMediaResourceService.save(sysMediaResource);
		addMessage(redirectAttributes, "保存多媒体资源成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysMediaResource/?repage";
	}
	
	@RequiresPermissions("sys:sysMediaResource:edit")
	@RequestMapping(value = "delete")
	public String delete(SysMediaResource sysMediaResource, RedirectAttributes redirectAttributes) {
		sysMediaResourceService.delete(sysMediaResource);
		addMessage(redirectAttributes, "删除多媒体资源成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysMediaResource/?repage";
	}

}