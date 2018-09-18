/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.web;

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
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.enterprise.entity.BxVideo;
import com.thinkgem.jeesite.modules.enterprise.service.BxVideoService;

/**
 * 北新视频管理Controller
 * @author liuxiaoyu
 * @version 2015-12-08
 */
@Controller
@RequestMapping(value = "${adminPath}/enterprise/bxVideo")
public class BxVideoController extends BaseController {

	@Autowired
	private BxVideoService bxVideoService;
	
	@ModelAttribute
	public BxVideo get(@RequestParam(required=false) String id) {
		BxVideo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bxVideoService.get(id);
		}
		if (entity == null){
			entity = new BxVideo();
		}
		return entity;
	}
	
	@RequiresPermissions("enterprise:bxVideo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BxVideo bxVideo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BxVideo> page = bxVideoService.findPage(new Page<BxVideo>(request, response), bxVideo); 
		model.addAttribute("page", page);
		return "modules/enterprise/bxVideoList";
	}

	@RequiresPermissions("enterprise:bxVideo:view")
	@RequestMapping(value = "form")
	public String form(BxVideo bxVideo, Model model) {
		model.addAttribute("bxVideo", bxVideo);
		return "modules/enterprise/bxVideoForm";
	}

	@RequiresPermissions("enterprise:bxVideo:edit")
	@RequestMapping(value = "save")
	public String save(BxVideo bxVideo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bxVideo)){
			return form(bxVideo, model);
		}
		if(bxVideo.getCreatetime()==null){
			bxVideo.setCreatetime(new Date());
		}
		bxVideoService.save(bxVideo);
		addMessage(redirectAttributes, "保存视频成功");
		return "redirect:"+Global.getAdminPath()+"/enterprise/bxVideo/?repage";
	}
	
	@RequiresPermissions("enterprise:bxVideo:edit")
	@RequestMapping(value = "delete")
	public String delete(BxVideo bxVideo, RedirectAttributes redirectAttributes) {
		bxVideoService.delete(bxVideo);
		addMessage(redirectAttributes, "删除视频成功");
		return "redirect:"+Global.getAdminPath()+"/enterprise/bxVideo/?repage";
	}

}