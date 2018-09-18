/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 留言内容Entity
 * @author gaoxiyang
 * @version 2016-12-20
 */
public class MessageBoard extends DataEntity<MessageBoard> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String phone;		// 电话
	private String email;		// 邮箱
	private String content;		// 内容
//	private Date creattime;		// 提交时间
	
	public MessageBoard() {
		super();
	}

	public MessageBoard(String id){
		super(id);
	}

	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="电话长度必须介于 0 和 255 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=255, message="邮箱长度必须介于 0 和 255 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}*/
	
}