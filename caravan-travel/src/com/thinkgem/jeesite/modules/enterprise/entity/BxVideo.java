/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.enterprise.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 北新视频管理Entity
 * @author liuxiaoyu
 * @version 2015-12-08
 */
public class BxVideo extends DataEntity<BxVideo> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 视频名称
	private String imageurl;		// 视频预览图地址
	private String vidiourl;		// 视频地址
	private String mark;		// 视频说明
	private Date createtime;		// 创建时间
	
	public BxVideo() {
		super();
	}

	public BxVideo(String id){
		super(id);
	}

	@Length(min=0, max=50, message="视频名称长度必须介于 0 和 50 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=500, message="视频预览图地址长度必须介于 0 和 500 之间")
	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	@Length(min=0, max=500, message="视频地址长度必须介于 0 和 500 之间")
	public String getVidiourl() {
		return vidiourl;
	}

	public void setVidiourl(String vidiourl) {
		this.vidiourl = vidiourl;
	}
	
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}