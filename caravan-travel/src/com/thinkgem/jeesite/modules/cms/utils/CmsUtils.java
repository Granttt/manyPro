/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.ui.Model;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.CmsSlide;
import com.thinkgem.jeesite.modules.cms.entity.Link;
import com.thinkgem.jeesite.modules.cms.entity.Site;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CmsSlideService;
import com.thinkgem.jeesite.modules.cms.service.LinkService;
import com.thinkgem.jeesite.modules.cms.service.SiteService;
import com.thinkgem.jeesite.modules.enterprise.entity.BxVideo;
import com.thinkgem.jeesite.modules.enterprise.service.BxVideoService;
import com.thinkgem.jeesite.modules.sys.entity.SysResourceRelation;
import com.thinkgem.jeesite.modules.sys.service.SysResourceRelationService;

/**
 * 内容管理工具类
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
public class CmsUtils {
	
//	private final static Logger logger = Logger.getLogger(CmsUtils.class);

	private static SiteService siteService = SpringContextHolder.getBean(SiteService.class);
	private static CategoryService categoryService = SpringContextHolder.getBean(CategoryService.class);
	private static ArticleService articleService = SpringContextHolder.getBean(ArticleService.class);
	private static LinkService linkService = SpringContextHolder.getBean(LinkService.class);

	private static ServletContext context = SpringContextHolder.getBean(ServletContext.class);
	private static SysResourceRelationService resourceService = SpringContextHolder.getBean(SysResourceRelationService.class);
	private static ArticleDataService articleDataService = SpringContextHolder.getBean(ArticleDataService.class);
	private static BxVideoService bxVideoService = SpringContextHolder.getBean(BxVideoService.class);
	private static CmsSlideService cmsSlideservice =SpringContextHolder.getBean(CmsSlideService.class);


	private static final String CMS_CACHE = "cmsCache";

	/**
	 * 获得站点列表
	 */
	public static List<Site> getSiteList() {
		@SuppressWarnings("unchecked")
		List<Site> siteList = (List<Site>) CacheUtils.get(CMS_CACHE, "siteList");
		if (siteList == null) {
			Page<Site> page = new Page<Site>(1, -1);
			page = siteService.findPage(page, new Site());
			siteList = page.getList();
			CacheUtils.put(CMS_CACHE, "siteList", siteList);
		}
		return siteList;
	}

	/**
	 * 获得站点信息
	 * 
	 * @param siteId
	 *            站点编号
	 */
	public static Site getSite(String siteId) {
		String id = "1";
		if (StringUtils.isNotBlank(siteId)) {
			id = siteId;
		}
		for (Site site : getSiteList()) {
			if (site.getId().equals(id)) {
				return site;
			}
		}
		return new Site(id);
	}

	/**
	 * 获得主导航列表
	 * 
	 * @param siteId
	 *            站点编号
	 */
	public static List<Category> getMainNavList(String siteId) {
		@SuppressWarnings("unchecked")
		List<Category> mainNavList = (List<Category>) CacheUtils.get(CMS_CACHE, "mainNavList_" + siteId);
		if (mainNavList == null) {
			Category category = new Category();
			category.setSite(new Site(siteId));
			category.setParent(new Category("1"));
			category.setInMenu(Global.SHOW);
			Page<Category> page = new Page<Category>(1, -1);
			page = categoryService.find(page, category);
			mainNavList = page.getList();
			CacheUtils.put(CMS_CACHE, "mainNavList_" + siteId, mainNavList);
		}
		return mainNavList;
	}

	/**
	 * 获取栏目
	 * 
	 * @param categoryId
	 *            栏目编号
	 * @return
	 */
	public static Category getCategory(String categoryId) {
		return categoryService.get(categoryId);
	}

	/**
	 * 获得栏目列表
	 * 
	 * @param siteId
	 *            站点编号
	 * @param parentId
	 *            分类父编号
	 * @param number
	 *            获取数目
	 * @param param
	 *            预留参数，例： key1:'value1', key2:'value2' ...
	 */
	public static List<Category> getCategoryList(String siteId, String parentId, int number, String param) {
		Page<Category> page = new Page<Category>(1, number, -1);
		Category category = new Category();
		category.setSite(new Site(siteId));
		category.setParent(new Category(parentId));
		if (StringUtils.isNotBlank(param)) {
			@SuppressWarnings({ "unused", "rawtypes" })
			Map map = JsonMapper.getInstance().fromJson("{" + param + "}", Map.class);
		}
		page = categoryService.find(page, category);
		return page.getList();
	}

	/**
	 * 获取焦点图信息
	 * 
	 * @param positionid
	 *            图片位置ID
	 * @param number
	 *            需要图片数量
	 * @param param
	 * @return
	 */
	public static List<SysResourceRelation> getFocusList(String positionid, int number) {
		List<SysResourceRelation> sysResourceRelations = resourceService.findByTag(positionid, number);

		return sysResourceRelations;
	}

	/**
	 * 获取栏目
	 * 
	 * @param categoryIds
	 *            栏目编号
	 * @return
	 */
	public static List<Category> getCategoryListByIds(String categoryIds) {
		return categoryService.findByIds(categoryIds);
	}

	/**
	 * 获取文章
	 * 
	 * @param articleId
	 *            文章编号
	 * @return
	 */
	public static Article getArticle(String articleId) {
		return articleService.get(articleId);
	}

	/**
	 * 获取文章列表
	 * 
	 * @param siteId
	 *            站点编号
	 * @param categoryId
	 *            分类编号
	 * @param number
	 *            获取数目
	 * @param param
	 *            预留参数，例： key1:'value1', key2:'value2' ... posid
	 *            推荐位（1：首页焦点图；2：栏目页文章推荐；） image 文章图片（1：有图片的文章） orderBy 排序字符串
	 * @return ${fnc:getArticleList(category.site.id, category.id, not empty
	 *         pageSize?pageSize:8, 'posid:2, orderBy: \"hits desc\"')}"
	 */
	public static List<Article> getArticleList(String siteId, String categoryId, int number, String param) {
		Page<Article> page = new Page<Article>(1, number, -1);
		Category category = new Category(categoryId, new Site(siteId));
		category.setParentIds(categoryId);
		Article article = new Article(category);
		if (StringUtils.isNotBlank(param)) {
			@SuppressWarnings({ "rawtypes" })
			Map map = JsonMapper.getInstance().fromJson("{" + param + "}", Map.class);
			if (new Integer(1).equals(map.get("posid")) || new Integer(2).equals(map.get("posid"))) {
				article.setPosid(String.valueOf(map.get("posid")));
			}
			if (new Integer(1).equals(map.get("image"))) {
				article.setImage(Global.YES);
			}
			if (StringUtils.isNotBlank((String) map.get("orderBy"))) {
				page.setOrderBy((String) map.get("orderBy"));
			}
		}
		article.setDelFlag(Article.DEL_FLAG_NORMAL);
		page = articleService.findPage(page, article, false);
		return page.getList();
	}

	/**
	 * 获取链接
	 * 
	 * @param linkId
	 *            文章编号
	 * @return
	 */
	public static Link getLink(String linkId) {
		return linkService.get(linkId);
	}

	/**
	 * 获取链接列表
	 * 
	 * @param siteId
	 *            站点编号
	 * @param categoryId
	 *            分类编号
	 * @param number
	 *            获取数目
	 * @param param
	 *            预留参数，例： key1:'value1', key2:'value2' ...
	 * @return
	 */
	public static List<Link> getLinkList(String siteId, String categoryId, int number, String param) {
		Page<Link> page = new Page<Link>(1, number, -1);
		Link link = new Link(new Category(categoryId, new Site(siteId)));
		if (StringUtils.isNotBlank(param)) {
			@SuppressWarnings({ "unused", "rawtypes" })
			Map map = JsonMapper.getInstance().fromJson("{" + param + "}", Map.class);
		}
		link.setDelFlag(Link.DEL_FLAG_NORMAL);
		page = linkService.findPage(page, link, false);
		return page.getList();
	}

	// ============== Cms Cache ==============

	public static Object getCache(String key) {
		return CacheUtils.get(CMS_CACHE, key);
	}

	public static void putCache(String key, Object value) {
		CacheUtils.put(CMS_CACHE, key, value);
	}

	public static void removeCache(String key) {
		CacheUtils.remove(CMS_CACHE, key);
	}

	/**
	 * 获得文章动态URL地址
	 * 
	 * @param article
	 * @return url
	 */
	public static String getUrlDynamic(Article article) {
		if (StringUtils.isNotBlank(article.getLink())) {
			return article.getLink();
		}
		StringBuilder str = new StringBuilder();
		str.append(context.getContextPath()).append(Global.getFrontPath());
		str.append("/view-").append(article.getCategory().getId()).append("-").append(article.getId()).append(Global.getUrlSuffix());
		return str.toString();
	}

	/**
	 * 获得栏目动态URL地址
	 * 
	 * @param category
	 * @return url
	 */
	public static String getUrlDynamic(Category category) {
		if (StringUtils.isNotBlank(category.getHref())) {
			if (!category.getHref().contains("://")) {
				return context.getContextPath() + Global.getFrontPath() + category.getHref();
			} else {
				return category.getHref();
			}
		}
		StringBuilder str = new StringBuilder();
		str.append(context.getContextPath()).append(Global.getFrontPath());
		str.append("/list-").append(category.getId()).append(Global.getUrlSuffix());
		return str.toString();
	}

	/**
	 * 从图片地址中去除ContextPath地址
	 * 
	 * @param src
	 * @return src
	 */
	public static String formatImageSrcToDb(String src) {
		if (StringUtils.isBlank(src))
			return src;
		if (src.startsWith(context.getContextPath() + "/userfiles")) {
			return src.substring(context.getContextPath().length());
		} else {
			return src;
		}
	}

	/**
	 * 从图片地址中加入ContextPath地址
	 * 
	 * @param src
	 * @return src
	 */
	public static String formatImageSrcToWeb(String src) {
		if (StringUtils.isBlank(src))
			return src;
		if (src.startsWith(context.getContextPath() + "/userfiles")) {
			return src;
		} else {
			return context.getContextPath() + src;
		}
	}

	public static void addViewConfigAttribute(Model model, String param) {
		if (StringUtils.isNotBlank(param)) {
			@SuppressWarnings("rawtypes")
			Map map = JsonMapper.getInstance().fromJson(param, Map.class);
			if (map != null) {
				for (Object o : map.keySet()) {
					model.addAttribute("viewConfig_" + o.toString(), map.get(o));
				}
			}
		}
	}

	public static void addViewConfigAttribute(Model model, Category category) {
		List<Category> categoryList = Lists.newArrayList();
		Category c = category;
		boolean goon = true;
		do {
			if (c.getParent() == null || c.getParent().isRoot()) {
				goon = false;
			}
			categoryList.add(c);
			c = c.getParent();
		} while (goon);
		Collections.reverse(categoryList);
		for (Category ca : categoryList) {
			addViewConfigAttribute(model, ca.getViewConfig());
		}
	}

	public static Map<String, Object> getAllCategoryList() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Category> topCategory = categoryService.getTopCategory("0");
		List<Category> categoryList = categoryService.findAllCategory(topCategory);
		map.put("categoryList", categoryList);
		return map;
	}

	public static List<Category> getLeftCategory(String child) {
		List<Category> categoryLeftList = new ArrayList<Category>();
		Category category = categoryService.get(child);
		String parentId = category.getParentId();
		int length = category.getParentIds().split(",").length;
		if(length==3){//二级栏目
			categoryLeftList = categoryService.getTopCategory(parentId);
		}else if(length==4){//三级栏目
			Category secCategory = categoryService.get(parentId);
			categoryLeftList = categoryService.getTopCategory(secCategory.getParentId());
		}else{
			categoryLeftList = categoryService.getTopCategory(parentId);
		}
		return categoryLeftList;

	}

	public static List<Category> getCrumbs(String child) {
		Category bottom = categoryService.get(child);
		String pids = bottom.getParentIds();
		//优异性能_Excellent Performance
		if(StringUtils.equals(child, "9ef4703db13446cbafd0aeb225369199")){
			pids="0,1,6,";
		}
		//新闻资讯_News
		if(StringUtils.equals(child, "0c5de388a2fc49adb18b8cad9e995ed5")){
			pids="0,1,d5375a31aa1941f885f9b636cf02d515,";
		}
		List<Category> categoryCrumbsList = new ArrayList<Category>();
		String[] stringPid = null;
		stringPid = pids.split(",");
		List<String> listPid = new ArrayList<String>(Arrays.asList(stringPid));
		listPid.add(child);
		for (String string : listPid) {
			if (string != "0") {
				Category category = categoryService.get(string);
				categoryCrumbsList.add(category);
			}
		}
		List<Category> categoryReverseCrumbsList = new ArrayList<Category>();
		ListIterator<Category> iterator = categoryCrumbsList.listIterator(categoryCrumbsList.size());
		while (iterator.hasPrevious()) {
			categoryReverseCrumbsList.add(iterator.previous());
		}
		return categoryCrumbsList;
	}

	public static List<Category> getDownCategory(String child) {
		List<Category> categoryLeftList = new ArrayList<Category>();
		categoryLeftList = categoryService.getTopCategory(child);
		return categoryLeftList;

	}
	
	/*
	 * 获得article的所有的信息
	 */

	public static Article getArticleAllInfo(String contentId) {
		// 获取文章内容
//		Article article = articleService.get(contentId);
//		article.setArticleData(articleDataService.get(article.getId()));
		Article article = null;
		List<Article> articleList = articleService.findArticleByCategoryId(contentId);
		if(articleList.size()>0){
			article = articleList.get(0);
			article.setArticleData(articleDataService.get(article.getId()));
		}
		return article;
	}

	/*
	 * 获取父亲栏目
	 */
	public static Category getParentCategory(String categoryId) {
		Category category = categoryService.findParentByChildId(categoryId);
		return category;
	}

	/*
	 * 
	 * 获得第一个video
	 */

	public static BxVideo getFirstVideo() {
		return bxVideoService.getRecentVideo();

	}

    public static List<CmsSlide> getFirstSlide(String categroyId){
    	CmsSlide cmsSlide=new CmsSlide();
    	cmsSlide.setCategoryid(categroyId);
    	List<CmsSlide> slideList=cmsSlideservice.findList(cmsSlide);
		return slideList;
    }
    

    
    public static String getSlideUrlDynamic(Category category) {

      /*  if(StringUtils.isNotBlank(category.getHref())){
            return category.getHref();
        }*/
        StringBuilder str = new StringBuilder();
        str.append(context.getContextPath()).append(Global.getFrontPath());
        str.append("/slide/").append(category.getId()).append(Global.getUrlSuffix());
        category.setHref(str.toString());
        
        return str.toString();
    }
    /*
	 * 获得栏目下的article的所有的信息
	 */
	
	public static List<Article> getArticleLists(String contentId) {
		// 获取文章列表
		List<Article> articleList = articleService.findArticleByCategoryId(contentId);
		if(articleList.size()>0){
			for (Article article : articleList) {
				article.setArticleData(articleDataService.get(article.getId()));
			}
		}
		return articleList;
	}
    
    
}