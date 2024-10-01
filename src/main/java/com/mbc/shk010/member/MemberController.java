package com.mbc.shk010.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/meminput")
	public String meminput() {
		return "meminput";
	}//
	
	@RequestMapping(value = "/memsave", method = RequestMethod.POST)
	public String memsave(HttpServletRequest request) {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String phone1=request.getParameter("phone1");
		String phone2=request.getParameter("phone2");
		String phone3=request.getParameter("phone3");
		String phone=phone1+"-"+phone2+"-"+phone3;
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String hobby=request.getParameter("hobby");
		String hello=request.getParameter("hello");
		MemberService ss=sqlsession.getMapper(MemberService.class);
		ss.insertm(id, pw, name, phone, gender, address, hobby, hello);
		return "main";
	}//
	
	@RequestMapping(value = "/memout", method = RequestMethod.GET)
	public String memout(Model mo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession hs=request.getSession();
		boolean yy=(Boolean)hs.getAttribute("adminloginstate");
		if(yy) {
			MemberService ss=sqlsession.getMapper(MemberService.class);
			ArrayList<MemberDTO>list=ss.outm();
			mo.addAttribute("list",list);
			return "memout";
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter prw=response.getWriter();
			prw.print("<script> alert('관리자만 접근 가능합니다...');</script>");
			prw.print("<script> location.href='main';</script>");
			prw.close();
			return "redirect:/main";
		}
	}//
	
	@RequestMapping(value = "/memdelv", method = RequestMethod.GET)
	public String memdelv(HttpServletRequest request, Model mo) {
		String did=request.getParameter("id");
		MemberService ss=sqlsession.getMapper(MemberService.class);
		ArrayList<MemberDTO>list=ss.delviewm(did);
		mo.addAttribute("list",list);
		return "memdeleteview";
	}//
	
	@RequestMapping(value = "/memdel", method=RequestMethod.POST)
	public String memdel(HttpServletRequest request) {
		String dokid=request.getParameter("id");
		MemberService ss=sqlsession.getMapper(MemberService.class);
		ss.delm(dokid);
		return "main";
	}//
	
	@RequestMapping(value = "/memupdv", method = RequestMethod.GET)
	public String memupdv(HttpServletRequest request, Model mo) {
		String uid=request.getParameter("id");
		MemberService ss=sqlsession.getMapper(MemberService.class);
		ArrayList<MemberDTO>list=ss.updviewm(uid);
		mo.addAttribute("list",list);
		return "memupdateview";
	}//
	
	@RequestMapping(value = "/memupd", method=RequestMethod.POST)
	public String memupd(HttpServletRequest request) {
		String uokid=request.getParameter("id");
		String uokpw=request.getParameter("pw");
		String uokname=request.getParameter("name");
		String uokphone1=request.getParameter("phone1");
		String uokphone2=request.getParameter("phone2");
		String uokphone3=request.getParameter("phone3");
		String uokphone=uokphone1+"-"+uokphone2+"-"+uokphone3;
		String uokgender=request.getParameter("gender");
		String uokaddress=request.getParameter("address");
		String uokhobby=request.getParameter("hobby");
		String uokhello=request.getParameter("hello");
		MemberService ss=sqlsession.getMapper(MemberService.class);
		ss.updatem(uokpw, uokname, uokphone, uokgender, uokaddress, uokhobby, uokhello, uokid);
		return "redirect:/memout";
	}//
	
	@RequestMapping(value = "/memsearch", method = RequestMethod.GET)
	public String memsearch(HttpServletRequest request, Model mo, HttpServletResponse response) throws IOException {
		HttpSession hs=request.getSession();
		boolean yy=(Boolean)hs.getAttribute("adminloginstate");
		if(yy) {
			return "memsearch";
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter prw=response.getWriter();
			prw.print("<script> alert('관리자만 접근 가능합니다...');</script>");
			prw.print("<script> location.href='main';</script>");
			prw.close();
			return "redirect:/main";
		}
	}//
	
	@RequestMapping(value = "/memsearchsave", method = RequestMethod.POST)
	public String memsearchsave(HttpServletRequest request, Model mo) {
		String memkey=request.getParameter("memkey");
		String svalue="%"+request.getParameter("svalue")+"%";
		MemberService ss=sqlsession.getMapper(MemberService.class);
		ArrayList<MemberDTO>list;
		if(memkey.equals("id")) {
			list=ss.smi(svalue);
		}
		else if(memkey.equals("name")) {
			list=ss.smn(svalue);
		}
		else if(memkey.equals("gender")) {
			list=ss.smg(svalue);
		}
		else {
			list=ss.sma(svalue);
		}
		mo.addAttribute("list",list);
		
		return "memsearchview";
	}//
	
	@ResponseBody // 비동기식
	@RequestMapping(value = "/idcheck2")
	public String idcheck2(String id) {
		MemberService ss=sqlsession.getMapper(MemberService.class);
		int idchco=ss.idch2(id);
		if(idchco==0) {
			return "available";
		}
		else {
			return "impossible";
		}
		
	}//
	
}
