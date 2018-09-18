/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.SysMediaResource;
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;
import com.thinkgem.jeesite.modules.sys.service.SysMediaResourceService;
import com.thinkgem.jeesite.modules.sys.service.SysResourceRelationService;

/**
 * 资源关联Controller
 * @author liuxiaoyu
 * @version 2015-10-25
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysResourceRelation")
public class SysResourceRelationController extends BaseController {

	@Autowired
	private SysResourceRelationService sysResourceRelationService;
	
	@Autowired
	private SysMediaResourceService sysMediaResourceService;
	
	@ModelAttribute
	public SysResourceRelation get(@RequestParam(required=false) String id) {
		SysResourceRelation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysResourceRelationService.get(id);
		}
		if (entity == null){
			entity = new SysResourceRelation();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysResourceRelation:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysResourceRelation sysResourceRelation, HttpServletRequest request, HttpServletResponse response, Model model) {
		String positionid = request.getParameter("positionid");
		if (!StringUtils.isEmpty(positionid) && StringUtils.uuidReg(positionid)) {
			sysResourceRelation.setPositionid(positionid);
			model.addAttribute("positionid", positionid);
		} 
		Page<SysResourceRelation> page = sysResourceRelationService.findPage(new Page<SysResourceRelation>(request, response), sysResourceRelation); 
		model.addAttribute("page", page);
		return "modules/sys/sysResourceRelationList";
	}

	@RequiresPermissions("sys:sysResourceRelation:view")
	@RequestMapping(value = "form")
	public String form(SysResourceRelation sysResourceRelation,SysMediaResource sysMediaResource, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysMediaResource> page = sysMediaResourceService.findPage(new Page<SysMediaResource>(request, response), sysMediaResource); 
		model.addAttribute("page", page);
		String positionid=(String) request.getParameter("positionid");
		if(positionid!=null)
			model.addAttribute("positionid", positionid);
		model.addAttribute("sysResourceRelation", sysResourceRelation);
		logger.debug(sysResourceRelation.getPositionid());
		return "modules/sys/sysResourceRelationForm";
	}

	@RequiresPermissions("sys:sysResourceRelation:edit")
	@RequestMapping(value = "save")
	public String save(SysResourceRelation sysResourceRelation,SysMediaResource sysMediaResource, HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysResourceRelation)){
			return form(sysResourceRelation,sysMediaResource,request,response, model);
		}
		if (StringUtils.isNotBlank(sysResourceRelation.getResourceid())) {
			String positionid = sysResourceRelation.getPositionid();
			String resourceids[] = sysResourceRelation.getResourceid().substring(0, sysResourceRelation.getResourceid().length()-1).split(",");
			List<SysResourceRelation> list = new ArrayList<SysResourceRelation>();;
			for (String resourceid : resourceids) {
				SysResourceRelation bean = new SysResourceRelation(IdGen.uuid());
				bean.setPositionid(positionid);
				bean.setIsNewRecord(true);
				bean.setResourceid(resourceid);
				list.add(bean);
			}
			if (!CollectionUtils.isEmpty(list)) {
				sysResourceRelationService.batchSave(list);
				addMessage(redirectAttributes, "您己成功关联"+list.size()+"个资源");
			} else {
				addMessage(redirectAttributes, "保存关联失败");
			}
		}
		return "redirect:"+Global.getAdminPath()+"/sys/sysResourceRelation?positionid="+sysResourceRelation.getPositionid();
	}
	
	@RequiresPermissions("sys:sysResourceRelation:edit")
	@RequestMapping(value = "delete")
	public String delete(SysResourceRelation sysResourceRelation, RedirectAttributes redirectAttributes,@RequestParam(required=false) String positionid,Model model) {
		sysResourceRelationService.delete(sysResourceRelation);
		addMessage(redirectAttributes, "删除关联成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysResourceRelation?positionid="+positionid;
	}

}