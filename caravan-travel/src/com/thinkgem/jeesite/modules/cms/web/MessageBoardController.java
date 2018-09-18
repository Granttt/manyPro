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
import com.thinkgem.jeesite.modules.cms.entity.MessageBoard;
import com.thinkgem.jeesite.modules.cms.service.MessageBoardService;

/**
 * 留言内容Controller
 * @author gaoxiyang
 * @version 2016-12-20
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/messageBoard")
public class MessageBoardController extends BaseController {

	@Autowired
	private MessageBoardService messageBoardService;
	
	@ModelAttribute
	public MessageBoard get(@RequestParam(required=false) String id) {
		MessageBoard entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = messageBoardService.get(id);
		}
		if (entity == null){
			entity = new MessageBoard();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:messageBoard:view")
	@RequestMapping(value = {"list", ""})
	public String list(MessageBoard messageBoard, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MessageBoard> page = messageBoardService.findPage(new Page<MessageBoard>(request, response), messageBoard); 
		model.addAttribute("page", page);
		return "modules/cms/messageBoardList";
	}

	@RequiresPermissions("cms:messageBoard:view")
	@RequestMapping(value = "form")
	public String form(MessageBoard messageBoard, Model model) {
		model.addAttribute("messageBoard", messageBoard);
		return "modules/cms/messageBoardForm";
	}

	@RequiresPermissions("cms:messageBoard:edit")
	@RequestMapping(value = "save")
	public String save(MessageBoard messageBoard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, messageBoard)){
			return form(messageBoard, model);
		}
		messageBoardService.save(messageBoard);
		addMessage(redirectAttributes, "保存留言内容成功");
		return "redirect:"+Global.getAdminPath()+"/cms/messageBoard/?repage";
	}
	
	@RequiresPermissions("cms:messageBoard:edit")
	@RequestMapping(value = "delete")
	public String delete(MessageBoard messageBoard, RedirectAttributes redirectAttributes) {
		messageBoardService.delete(messageBoard);
		addMessage(redirectAttributes, "删除留言内容成功");
		return "redirect:"+Global.getAdminPath()+"/cms/messageBoard/?repage";
	}

}