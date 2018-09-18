/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 幻灯片Entity
 * @author liuxiaoyu
 * @version 2015-12-18
 */
public class CmsSlide extends DataEntity<CmsSlide> {
	
	private static final long serialVersionUID = 1L;
	private String imagename;		// 图片名称
	private String imageurl;		// 资源url
	private String imagetitle;		// 图片标题
	private String imagehref;		// 链接地址
	private String imagedesc;		// 图片描述
	private String categoryid;		// 分类ID
	private String homeView;		// 是否首页显示
//	private Date createtTime;		// 文章创建时间
	protected Integer sort;	
	
	public CmsSlide() {
		super();
	}

	public CmsSlide(String id){
		super(id);
	}

	@Length(min=1, max=500, message="图片名称长度必须介于 1 和 500 之间")
	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	@Length(min=1, max=500, message="资源url长度必须介于 1 和 500 之间")
	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	@Length(min=0, max=200, message="图片标题长度必须介于 0 和 200 之间")
	public String getImagetitle() {
		return imagetitle;
	}

	public void setImagetitle(String imagetitle) {
		this.imagetitle = imagetitle;
	}
	
	@Length(min=0, max=500, message="链接地址长度必须介于 0 和 500 之间")
	public String getImagehref() {
		return imagehref;
	}

	public void setImagehref(String imagehref) {
		this.imagehref = imagehref;
	}
	
	@Length(min=0, max=500, message="图片描述长度必须介于 0 和 500 之间")
	public String getImagedesc() {
		return imagedesc;
	}

	public void setImagedesc(String imagedesc) {
		this.imagedesc = imagedesc;
	}
	
	@Length(min=1, max=64, message="分类ID长度必须介于 1 和 64 之间")
	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getHomeView() {
		return homeView;
	}

	public void setHomeView(String homeView) {
		this.homeView = homeView;
	}

//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	public Date getCreatetTime() {
//		return createtTime;
//	}
//
//	public void setCreatetTime(Date createtTime) {
//		this.createtTime = createtTime;
//	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}