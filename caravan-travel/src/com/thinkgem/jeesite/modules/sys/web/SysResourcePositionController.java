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
import com.thinkgem.jeesite.modules.sys.entity.SysResourcePosition;
import com.thinkgem.jeesite.modules.sys.service.SysResourcePositionService;

/**
 * 资源挂载位置管理Controller
 * @author liuxiaoyu
 * @version 2015-10-19
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysResourcePosition")
public class SysResourcePositionController extends BaseController {

	@Autowired
	private SysResourcePositionService sysResourcePositionService;
	
	@ModelAttribute
	public SysResourcePosition get(@RequestParam(required=false) String id) {
		SysResourcePosition entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysResourcePositionService.get(id);
		}
		if (entity == null){
			entity = new SysResourcePosition();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysResourcePosition:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysResourcePosition sysResourcePosition, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysResourcePosition> page = sysResourcePositionService.findPage(new Page<SysResourcePosition>(request, response), sysResourcePosition); 
		model.addAttribute("page", page);
		return "modules/sys/sysResourcePositionList";
	}

	@RequiresPermissions("sys:sysResourcePosition:view")
	@RequestMapping(value = "form")
	public String form(SysResourcePosition sysResourcePosition, Model model) {
		model.addAttribute("sysResourcePosition", sysResourcePosition);
		return "modules/sys/sysResourcePositionForm";
	}

	@RequiresPermissions("sys:sysResourcePosition:edit")
	@RequestMapping(value = "save")
	public String save(SysResourcePosition sysResourcePosition, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysResourcePosition)){
			return form(sysResourcePosition, model);
		}
		sysResourcePositionService.save(sysResourcePosition);
		addMessage(redirectAttributes, "保存资源挂载位置成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysResourcePosition/?repage";
	}
	
	@RequiresPermissions("sys:sysResourcePosition:edit")
	@RequestMapping(value = "delete")
	public String delete(SysResourcePosition sysResourcePosition, RedirectAttributes redirectAttributes) {
		sysResourcePositionService.delete(sysResourcePosition);
		addMessage(redirectAttributes, "删除资源挂载位置成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysResourcePosition/?repage";
	}

}