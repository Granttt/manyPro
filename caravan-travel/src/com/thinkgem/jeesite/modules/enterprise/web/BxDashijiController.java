/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.web;

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
import com.thinkgem.jeesite.modules.enterprise.entity.BxDashiji;
import com.thinkgem.jeesite.modules.enterprise.service.BxDashijiService;

/**
 * 北新大事记Controller
 * @author liuxiaoyu
 * @version 2015-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/enterprise/bxDashiji")
public class BxDashijiController extends BaseController {

	@Autowired
	private BxDashijiService bxDashijiService;
	
	@ModelAttribute
	public BxDashiji get(@RequestParam(required=false) String id) {
		BxDashiji entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bxDashijiService.get(id);
		}
		if (entity == null){
			entity = new BxDashiji();
		}
		return entity;
	}
	
	@RequiresPermissions("enterprise:bxDashiji:view")
	@RequestMapping(value = {"list", ""})
	public String list(BxDashiji bxDashiji, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BxDashiji> page = bxDashijiService.findPage(new Page<BxDashiji>(request, response), bxDashiji); 
		model.addAttribute("page", page);
		return "modules/enterprise/bxDashijiList";
	}

	@RequiresPermissions("enterprise:bxDashiji:view")
	@RequestMapping(value = "form")
	public String form(BxDashiji bxDashiji, Model model) {
		model.addAttribute("bxDashiji", bxDashiji);
		return "modules/enterprise/bxDashijiForm";
	}

	@RequiresPermissions("enterprise:bxDashiji:edit")
	@RequestMapping(value = "save")
	public String save(BxDashiji bxDashiji, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bxDashiji)){
			return form(bxDashiji, model);
		}
		bxDashijiService.save(bxDashiji);
		addMessage(redirectAttributes, "保存大事记成功");
		return "redirect:"+Global.getAdminPath()+"/enterprise/bxDashiji/?repage";
	}
	
	@RequiresPermissions("enterprise:bxDashiji:edit")
	@RequestMapping(value = "delete")
	public String delete(BxDashiji bxDashiji, RedirectAttributes redirectAttributes) {
		bxDashijiService.delete(bxDashiji);
		addMessage(redirectAttributes, "删除大事记成功");
		return "redirect:"+Global.getAdminPath()+"/enterprise/bxDashiji/?repage";
	}

}