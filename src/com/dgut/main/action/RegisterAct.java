package com.dgut.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgut.common.web.RequestUtils;
import com.dgut.common.web.ResponseUtils;
import com.dgut.common.web.session.SessionProvider;
import com.dgut.main.entity.Admin;
import com.dgut.main.entity.AdminLog;
import com.dgut.main.manager.AdminLogMng;
import com.dgut.main.manager.AdminMng;
import com.dgut.main.web.WebErrors;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;


@Controller
public class RegisterAct {
	private static final Logger log = LoggerFactory.getLogger(RegisterAct.class);
	
	@RequestMapping(value="input.do",method=RequestMethod.GET)
	public String getRegisterView(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "register";
	}
	
	@RequestMapping(value="v_checkUsername.do",method=RequestMethod.POST)
	public void checkUsername(HttpServletRequest request,HttpServletResponse response,ModelMap model,String username){
		Admin admin = adminMng.findByUsername(username);
		boolean pass = admin == null;
		ResponseUtils.renderText(response, pass?"true":"false");
	}

	@RequestMapping(value="register.do" ,method=RequestMethod.POST)
	public String AdminSave(HttpServletRequest request,HttpServletResponse response,ModelMap model,String captcha){
		WebErrors errors = validateCaptcha(captcha,request,response);
		if(errors.hasErrors()){
			errors.toModel(model);
			return "register";
		}
		String ip = RequestUtils.getIpAddr(request);
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		adminMng.saveAdmin(username, null, password, ip, 8, gender.equals("1")?true:false, realname, 2);
		//adminLogMng.operating(request, "cms.member.register", "register.username="+username);
		return "login";
	}
	
	private WebErrors validateCaptcha(String captcha, HttpServletRequest request, HttpServletResponse response) {
		WebErrors errors = WebErrors.create(request);
		try {
			if (!imageCaptchaService.validateResponseForID(session
					.getSessionId(request, response), captcha)) {
				errors.addErrorCode("error.invalidCaptcha");
				return errors;
			}
		} catch (CaptchaServiceException e) {
			errors.addErrorCode("error.exceptionCaptcha");
			log.warn("", e);
			return errors;
		}
		return errors;
	}

	@Autowired
	private AdminMng adminMng;
	@Autowired
	private SessionProvider session;
	@Autowired
	private ImageCaptchaService imageCaptchaService;
	@Autowired
	private AdminLogMng adminLogMng;
}
