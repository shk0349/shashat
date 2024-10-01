package com.mbc.shk010.score;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mbc.shk010.board.PageDTO;

@Controller
public class ScoreController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/scoreinput", method = RequestMethod.GET)
	public String scoreinput() {
		return "scoreinput";
	}//
	
	@RequestMapping(value = "/scoresave", method = RequestMethod.POST)
	public String scoresave(HttpServletRequest request) {
		int sclass=Integer.parseInt(request.getParameter("sclass"));
		int sban=Integer.parseInt(request.getParameter("sban"));
		int sbunho=Integer.parseInt(request.getParameter("sbunho"));
		String sname=request.getParameter("sname");
		int kor=Integer.parseInt(request.getParameter("kor"));
		int eng=Integer.parseInt(request.getParameter("eng"));
		int mat=Integer.parseInt(request.getParameter("mat"));
		int tot=kor+eng+mat;
		double avg=(double)tot/3;
		ScoreService ss=sqlsession.getMapper(ScoreService.class);
		ss.inserts(sclass, sban, sbunho, sname, kor, eng, mat, tot, avg);
		return "main";
	}//
	
	@RequestMapping(value = "/scoreout", method = RequestMethod.GET)
	public String scoreout(HttpServletRequest request, Model mo, HttpServletResponse response, PageDTO dto) throws IOException {
		HttpSession hs=request.getSession();
		boolean yy=(Boolean)hs.getAttribute("loginstate");
		if(yy) {
			String nowPage=request.getParameter("nowPage");
			String cntPerPage=request.getParameter("cntPerPage");
			ScoreService ss=sqlsession.getMapper(ScoreService.class);
			//전체레코드수구하기
			int total=ss.total();
			if(nowPage==null && cntPerPage == null) {
				nowPage="1";
				cntPerPage="5";
			}
			else if(nowPage==null) {
				nowPage="1";
			}
			else if(cntPerPage==null) {
				cntPerPage="5";
			} 
			dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			mo.addAttribute("paging",dto);
			mo.addAttribute("list", ss.page(dto));
			return "scoreout";
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter prw=response.getWriter();
			prw.print("<script> alert('로그인 먼저 해주세요...!');</script>");
			prw.print("<script> location.href='login';</script>");
			prw.close();
			return "redirect:/login";
		}
	}//

	@RequestMapping(value = "/scoredelv", method = RequestMethod.GET)
	public String scoredelv(HttpServletRequest request, Model mo) {
		int dvsclass=Integer.parseInt(request.getParameter("sclass"));
		int dvsban=Integer.parseInt(request.getParameter("sban"));
		int dvsbunho=Integer.parseInt(request.getParameter("sbunho"));
		ScoreService ss=sqlsession.getMapper(ScoreService.class);
		ArrayList<ScoreDTO>list=ss.delvs(dvsclass, dvsban, dvsbunho);
		mo.addAttribute("list", list);
		return "scoredeleteview";
	}//
	
	@RequestMapping(value = "/scoredel", method = RequestMethod.POST)
	public String scoredel(HttpServletRequest request) {
		int delsclass=Integer.parseInt(request.getParameter("sclass"));
		int delsban=Integer.parseInt(request.getParameter("sban"));
		int delsbunho=Integer.parseInt(request.getParameter("sbunho"));
		ScoreService ss=sqlsession.getMapper(ScoreService.class);
		ss.deletes(delsclass, delsban, delsbunho);
		return "redirect:/scoreout";
	}//
	
	@RequestMapping(value = "/scoreupdv", method = RequestMethod.GET)
	public String scoreupdv(HttpServletRequest request, Model mo) {
		int udvsclass=Integer.parseInt(request.getParameter("sclass"));
		int udvsban=Integer.parseInt(request.getParameter("sban"));
		int udvsbunho=Integer.parseInt(request.getParameter("sbunho"));
		ScoreService ss=sqlsession.getMapper(ScoreService.class);
		ArrayList<ScoreDTO>list=ss.updvs(udvsclass, udvsban, udvsbunho);
		mo.addAttribute("list", list);
		return "scoreupdateview";
	}//
	
	@RequestMapping(value = "/scoreupdate", method = RequestMethod.POST)
	public String scoreupdate(HttpServletRequest request, Model mo) {
		int udsclass=Integer.parseInt(request.getParameter("sclass"));
		int udsban=Integer.parseInt(request.getParameter("sban"));
		int udsbunho=Integer.parseInt(request.getParameter("sbunho"));
		String udsname=request.getParameter("sname");
		int udkor=Integer.parseInt(request.getParameter("kor"));
		int udeng=Integer.parseInt(request.getParameter("eng"));
		int udmat=Integer.parseInt(request.getParameter("mat"));
		int udtot=udkor+udeng+udmat;
		double udavg=(double)udtot/3;
		ScoreService ss=sqlsession.getMapper(ScoreService.class);
		ss.updates(udkor, udeng, udmat, udtot, udavg, udsclass, udsban, udsbunho);
		return "redirect:/scoreout";
	}//
	
	@RequestMapping(value = "/scoresearch", method = RequestMethod.GET)
	public String scoresearch() {
		return "scoresearch";
	}//
	
	@RequestMapping(value = "/scoresearchsave", method = RequestMethod.POST)
	public String scoresearchsave(HttpServletRequest request, Model mo) {
		String scorekey=request.getParameter("scorekey");
		String svalue="%"+request.getParameter("svalue")+"%";
		ScoreService ss=sqlsession.getMapper(ScoreService.class);
		ArrayList<ScoreDTO>list;
		if(scorekey.equals("sclass")) {
			list=ss.ssc(svalue);
		}
		else if(scorekey.equals("sban")) {
			list=ss.ssb(svalue);
		}
		else {
			list=ss.ssn(svalue);
		}
        mo.addAttribute("list", list);
		return "scoresearchview";
	}//
	
}
