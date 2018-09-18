package com.thinkgem.jeesite.modules.enterprise.web.sanheyi;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
@Controller
@RequestMapping(value = "${frontPath}")
public class PublicHzbController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	/**
	 * 是否是三级栏目
	 * @param request
	 * @param response
	 * @param child
	 * @return
	 */
	public String selectCategory(String child){
		String secCategoryId = null;
		Category category = categoryService.get(child);
		int length = category.getParentIds().split(",").length;
		if(length>=4){
			Category pcategory = categoryService.get(category.getParentId());
			secCategoryId = pcategory.getId();
		}
		return secCategoryId;
	}
	/**
	 * 栏目图片
	 * @param request
	 * @param response
	 * @param child
	 * @return
	 */
	public String selectImage(String child){
		Category category = categoryService.get(child);
		Category pcategory = categoryService.get(category.getParentId());
		String imageUrl = category.getImage();
		String pimageUrl = pcategory.getImage();
		if(StringUtils.isBlank(imageUrl)&&StringUtils.isNotBlank(pimageUrl)){
			imageUrl = pimageUrl;
		}else if(StringUtils.isBlank(pimageUrl)&&StringUtils.isBlank(imageUrl)){
			imageUrl = categoryService.get(pcategory.getParentId()).getImage();
		}
		return imageUrl;
	}
	
}
