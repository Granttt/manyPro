package com.thinkgem.jeesite.modules.enterprise.web.sanheyi;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.ArticleData;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.MessageBoard;
import com.thinkgem.jeesite.modules.cms.service.ArticleDataService;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.MessageBoardService;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class CultureController extends BaseController{
	@Autowired
	private PublicHzbController publicController;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleDataService articleDataService;
	@Autowired
	private MessageBoardService messageBoardService;
	
	//联系我们
	@RequestMapping(value="corporate/{child}.html")
	public ModelAndView corporate(HttpServletRequest request, HttpServletResponse response,@PathVariable String child) {
		Map<String, Object> map = new HashMap<String, Object>();
		String imageUrl = publicController.selectImage(child);
		map.put("imageUrl",imageUrl);
		map.put("child",child);
		map.put("categoryid",child);
		return new ModelAndView("wwwpage/sanheyi/SHY_contact_us",map);
	}
	
	@RequestMapping(value = "messageBoard.html")  
	public String messageBoard(HttpServletRequest request, HttpServletResponse response,Model model) {
		Map<String, Object>  map=new HashMap<String, Object>();
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String saytext=request.getParameter("saytext");
		MessageBoard messageBoard=new MessageBoard();
		messageBoard.setName(lname);
		messageBoard.setEmail(email);
		messageBoard.setPhone(phone);
		messageBoard.setContent(saytext);
		messageBoardService.save(messageBoard);
		map.put("status","200");
		map.put("message",messageBoard);
		return renderString(response, map);
	}


	/**企业宗旨精神
	 * 功能描述：
	 * @author chenmc
	 * @date 2018/9/20 10:50
	 * @param
	 * @return
	 */
	@RequestMapping(value="mission/{child}.html")
	ModelAndView mission(HttpServletRequest request, HttpServletResponse response, @PathVariable String child) {
		Map<String, Object> map = new HashMap<String, Object>();
		String imageUrl = publicController.selectImage(child);
		Category cat  = new Category();
		cat.setId(child);
		cat=categoryService.get(child);
		map.put("categoryid",cat.getParentId());
		map.put("imageUrl",imageUrl);
		map.put("child",child);
		Article article = articleService.get("c1f948b1f6534654a7c0450fc814f0f8");
		ArticleData articleData = articleDataService.get("c1f948b1f6534654a7c0450fc814f0f8");
		map.put("aritcle", article);
		map.put("articleData", articleData);
		return new ModelAndView("wwwpage/hezhengbao/culture/HZB_mission_statement",map);
	}
	
	//企业精神
	@RequestMapping(value="spirit/{child}.html")
	public ModelAndView spirit(HttpServletRequest request, HttpServletResponse response,@PathVariable String child) {
		Map<String, Object> map = new HashMap<String, Object>();
		String imageUrl = publicController.selectImage(child);
		Category cat  = new Category();
		cat.setId(child);
		cat=categoryService.get(child);
		map.put("categoryid",cat.getParentId());
		map.put("imageUrl",imageUrl);
		map.put("child",child);
		Article article = articleService.get("0e037203e9744b7083e376189955ab5b");
		ArticleData articleData = articleDataService.get("0e037203e9744b7083e376189955ab5b");
		map.put("aritcle", article);
		map.put("articleData", articleData);
		return new ModelAndView("wwwpage/hezhengbao/culture/HZB_spirit",map);
	}
	
}
