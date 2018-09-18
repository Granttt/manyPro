/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

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
import com.thinkgem.jeesite.modules.sys.entity.SysWebConst;
import com.thinkgem.jeesite.modules.sys.service.SysWebConstService;

/**
 * 网站常量数据Controller
 * @author liuxiaoyu
 * @version 2015-12-21
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysWebConst")
public class SysWebConstController extends BaseController {

	@Autowired
	private SysWebConstService sysWebConstService;
	
	@ModelAttribute
	public SysWebConst get(@RequestParam(required=false) String id) {
		SysWebConst entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysWebConstService.get(id);
		}
		if (entity == null){
			entity = new SysWebConst();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysWebConst:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysWebConst sysWebConst, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysWebConst> page = sysWebConstService.findPage(new Page<SysWebConst>(request, response), sysWebConst); 
		model.addAttribute("page", page);
		return "modules/sys/sysWebConstList";
	}

	@RequiresPermissions("sys:sysWebConst:view")
	@RequestMapping(value = "form")
	public String form(SysWebConst sysWebConst, Model model) {
		model.addAttribute("sysWebConst", sysWebConst);
		return "modules/sys/sysWebConstForm";
	}

	@RequiresPermissions("sys:sysWebConst:edit")
	@RequestMapping(value = "save")
	public String save(SysWebConst sysWebConst, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysWebConst)){
			return form(sysWebConst, model);
		}
		sysWebConstService.save(sysWebConst);
		addMessage(redirectAttributes, "保存网站常量成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysWebConst/?repage";
	}
	
	@RequiresPermissions("sys:sysWebConst:edit")
	@RequestMapping(value = "delete")
	public String delete(SysWebConst sysWebConst, RedirectAttributes redirectAttributes) {
		sysWebConstService.delete(sysWebConst);
		addMessage(redirectAttributes, "删除网站常量成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysWebConst/?repage";
	}

}