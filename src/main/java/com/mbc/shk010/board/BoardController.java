package com.mbc.shk010.board;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/boardinput", method = RequestMethod.GET)
	public String boardinput() {
		return "boardinput";
	}//
	
	@RequestMapping(value = "/boardsave", method = RequestMethod.POST)
	public String boardsave(HttpServletRequest request) {
		String bwriter=request.getParameter("bwriter");
		String btitle=request.getParameter("btitle");
		String bcontents=request.getParameter("bcontents");
		BoardService bs=sqlsession.getMapper(BoardService.class);
		bs.insertb(bwriter, btitle, bcontents);
		return "redirect:/main";
	}//
	
//	@RequestMapping(value = "/boardout", method = RequestMethod.GET)
//	public String boardout(Model mo) {
//		BoardService bs=sqlsession.getMapper(BoardService.class);
//		ArrayList<BoardDTO>list=bs.outb();
//		mo.addAttribute("list", list);
//		return "boardout";
//	}//
	
	@RequestMapping(value="/boardout")
	public String ko16(HttpServletRequest request, PageDTO dto, Model mo, HttpServletResponse response) throws IOException {
		HttpSession hs=request.getSession();
		boolean yy=(Boolean)hs.getAttribute("loginstate");
		if(yy) {
		String nowPage=request.getParameter("nowPage");
		String cntPerPage=request.getParameter("cntPerPage");
		BoardService bs = sqlsession.getMapper(BoardService.class);
		//전체레코드수구하기
		int total=bs.total();
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
		mo.addAttribute("list", bs.page(dto));
		return "boardout";
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
	
	@RequestMapping(value = "/boarddetail", method = RequestMethod.GET)
	public String boarddetail(HttpServletRequest request, Model mo) {
		int dvbnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService bs=sqlsession.getMapper(BoardService.class);
		bs.countb(dvbnum);
		BoardDTO list=bs.detailvb(dvbnum);
		mo.addAttribute("list", list);
		return "boarddetailview";
	}//
	
	@RequestMapping(value = "/boardreply", method = RequestMethod.POST)
	public String boardreply(HttpServletRequest request, Model mo) {
		int rebnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService bs=sqlsession.getMapper(BoardService.class);
		BoardDTO dto=bs.replyb(rebnum);
		mo.addAttribute("dto", dto);
		return "boardreply";
	}//
	
	@RequestMapping(value = "/boardreplysave", method = RequestMethod.POST)
	public String boardreplysave(HttpServletRequest request, Model mo) {
		int rsbnum=Integer.parseInt(request.getParameter("bnum"));
		int rsgroups=Integer.parseInt(request.getParameter("groups"));
		int rsstep=Integer.parseInt(request.getParameter("step"));
		int rsindent=Integer.parseInt(request.getParameter("indent"));
		String bwriter=request.getParameter("bwriter");
		String btitle=request.getParameter("btitle");
		String bcontents=request.getParameter("bcontents");
		BoardService bs=sqlsession.getMapper(BoardService.class);
		bs.stepup(rsgroups, rsstep);
		rsstep++;
		rsindent++;
		bs.replyinsertb(rsbnum, bwriter, btitle, bcontents, rsgroups, rsstep, rsindent);
		return "redirect:/boardout";
	}//
	
	@RequestMapping(value = "/boarddelv", method = RequestMethod.GET)
	public String boarddelv(HttpServletRequest request, Model mo) {
		int dvbnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService bs=sqlsession.getMapper(BoardService.class);
		ArrayList<BoardDTO>list=bs.delviewb(dvbnum);
		mo.addAttribute("list", list);
		return "boarddeleteview";
	}//

	@RequestMapping(value = "/boarddel", method = RequestMethod.POST)
	public String boarddel(HttpServletRequest request) {
		int dbnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService bs=sqlsession.getMapper(BoardService.class);
		bs.deleteb(dbnum);
		return "redirect:/boardout";
	}//
	
	@RequestMapping(value = "/boardupdv", method = RequestMethod.GET)
	public String boardupdv(HttpServletRequest request, Model mo) {
		int uvbnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService bs=sqlsession.getMapper(BoardService.class);
		ArrayList<BoardDTO>list=bs.uptviewb(uvbnum);
		mo.addAttribute("list", list);
		return "boardupdateview";
	}//
	
	@RequestMapping(value = "/boardupd", method = RequestMethod.POST)
	public String boardupd(MultipartHttpServletRequest mul) throws IOException {
		int udbnum=Integer.parseInt(mul.getParameter("bnum"));
		String udbwriter=mul.getParameter("bwriter");
		String udbtitle=mul.getParameter("btitle");
		String udbcontents=mul.getParameter("bcontents");
		BoardService bs=sqlsession.getMapper(BoardService.class);
		bs.updateb(udbwriter, udbtitle, udbcontents, udbnum);
		return "redirect:/boardout";
	}//
	
	@RequestMapping(value = "/boardsearch", method = RequestMethod.GET)
	public String boardsearch() {
		return "boardsearch";
	}//
	
	@RequestMapping(value = "/boardsearchsave", method = RequestMethod.POST)
	public String boardsearchsave(HttpServletRequest request, Model mo) {
		String boardkey=request.getParameter("boardkey");
		String svalue="%"+request.getParameter("svalue")+"%";
		BoardService bs=sqlsession.getMapper(BoardService.class);
		ArrayList<BoardDTO>list;
		if(boardkey.equals("bwriter")) {
			list=bs.bsw(svalue);
		}
		else if(boardkey.equals("btitle")) {
			list=bs.bst(svalue);
		}
		else {
			list=bs.bsc(svalue);
		}
        mo.addAttribute("list", list);
		return "boardsearchview";
	}//
	
	@RequestMapping(value="/musicplay")
	public String musicplay(HttpServletRequest request, PageDTO dto, Model mo, HttpServletResponse response) throws IOException {
		HttpSession hs=request.getSession();
		boolean yy=(Boolean)hs.getAttribute("loginstate");
		if(yy) {
		return "musicplay";
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
	
}
