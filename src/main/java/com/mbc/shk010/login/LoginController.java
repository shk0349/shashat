package com.mbc.shk010.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}//
	
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String logincheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String adminid="admin";
		String adminpw="admin";
		LoginService ls=sqlsession.getMapper(LoginService.class);
		LoginDTO dto=ls.logincheck(id, pw);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter prw=response.getWriter();
		if(dto!=null) {
			HttpSession hs=request.getSession();
			hs.setAttribute("loginstate", true);
			hs.setAttribute("member", dto);
			hs.setMaxInactiveInterval(600);
			prw.print("<script> alert('로그인에 성공하였습니다...!');</script>");
			prw.print("<script> location.href='main';</script>");
			prw.close();
			return "redirect:/main";
		}
		else if(id.equals(adminid)&&pw.equals(adminpw)) {
			HttpSession hs=request.getSession();
			hs.setAttribute("adminloginstate", true);
			hs.setMaxInactiveInterval(600);
			prw.print("<script> alert('관리자 로그인에 성공하였습니다...!');</script>");
			prw.print("<script> location.href='main';</script>");
			prw.close();
			return "redirect:/main";
		}
		else {
			prw.print("<script> alert('로그인에 실패하였습니다...아이디 및 비밀번호를 확인해주세요...');</script>");
			prw.print("<script> location.href='login';</script>");
			prw.close();
			return "redirect:/login";
		}
	}//
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession hs=request.getSession();
		hs.setAttribute("loginstate", false);
		hs.setAttribute("adminloginstate", false);
		hs.removeAttribute("member");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter prw=response.getWriter();
		prw.print("<script> alert('로그아웃에 성공하였습니다...!');</script>");
		prw.print("<script> location.href='main';</script>");
		prw.close();
		return "redirect:/main";
	}//

}
