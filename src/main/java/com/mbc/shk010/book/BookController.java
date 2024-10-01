package com.mbc.shk010.book;

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
public class BookController {
	String imagepath="C://Java//spring//day010_board//src//main//webapp//image";
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "/bookinput", method = RequestMethod.GET)
	public String bookinput() {
		return "bookinput";
	}//
	
	@RequestMapping(value = "/booksave", method = RequestMethod.POST)
	public String booksave(MultipartHttpServletRequest mul) throws IOException {
		String bname=mul.getParameter("bname");
		String bwriter=mul.getParameter("bwriter");
		String bcompany=mul.getParameter("bcompany");
		int bprice=Integer.parseInt(mul.getParameter("bprice"));
		String bdate=mul.getParameter("bdate");
		String binfo=mul.getParameter("binfo");
		MultipartFile mf=mul.getFile("bimage");
		String bimagefn=mf.getOriginalFilename();
		bimagefn=filesave(bimagefn, mf.getBytes());
		BookService bs=sqlSession.getMapper(BookService.class);
		mf.transferTo(new File(imagepath+"//"+bimagefn));
		bs.insertb(bname, bwriter, bcompany, bprice, bdate, binfo, bimagefn);
		return "main";
	}//

	private String filesave(String bimagefn, byte[] bytes) {
		UUID ud=UUID.randomUUID();
		String birname=ud.toString()+"_"+bimagefn;
		return birname;
	}//
	
	@RequestMapping(value = "/bookout", method = RequestMethod.GET)
	public String bookout(Model mo, HttpServletRequest request, HttpServletResponse response, PageDTO dto) throws IOException {
		HttpSession hs=request.getSession();
		boolean yy=(Boolean)hs.getAttribute("loginstate");
		if(yy) {
			String nowPage=request.getParameter("nowPage");
			String cntPerPage=request.getParameter("cntPerPage");
			BookService bs=sqlSession.getMapper(BookService.class);
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
			return "bookout";
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
	
	@RequestMapping(value = "/bookdelv", method = RequestMethod.GET)
	public String bookdelv(HttpServletRequest request, Model mo) {
		int dvbnum=Integer.parseInt(request.getParameter("bnum"));
		BookService bs=sqlSession.getMapper(BookService.class);
		ArrayList<BookDTO>list=bs.delviewb(dvbnum);
		mo.addAttribute("list", list);
		return "bookdeleteview";
	}//
	
	@RequestMapping(value = "/bookdel", method = RequestMethod.POST)
	public String bookdel(HttpServletRequest request) {
		int debnum=Integer.parseInt(request.getParameter("bnum"));
		BookService bs=sqlSession.getMapper(BookService.class);
		bs.deleteb(debnum);
		return "redirect:/bookout";
	}//
	
	@RequestMapping(value = "/bookupdv", method = RequestMethod.GET)
	public String bookupdv(HttpServletRequest request, Model mo) {
		int udvbnum=Integer.parseInt(request.getParameter("bnum"));
		BookService bs=sqlSession.getMapper(BookService.class);
		ArrayList<BookDTO>list=bs.updviewb(udvbnum);
		mo.addAttribute("list", list);
		return "bookupdateview";
	}//
	
	@RequestMapping(value = "/bookupd", method = RequestMethod.POST)
	public String bookupd(MultipartHttpServletRequest mul) throws IOException {
		int udbnum=Integer.parseInt(mul.getParameter("bnum"));
		String udbname=mul.getParameter("bname");
		String udbwriter=mul.getParameter("bwriter");
		String udbcompany=mul.getParameter("bcompany");
		int udbprice=Integer.parseInt(mul.getParameter("bprice"));
		String udbdate=mul.getParameter("bdate");
		String udbinfo=mul.getParameter("binfo");
		MultipartFile mf=mul.getFile("bimage");
		String udbimagefn=mf.getOriginalFilename();
		udbimagefn=filesave(udbimagefn, mf.getBytes());
		BookService bs=sqlSession.getMapper(BookService.class);
		mf.transferTo(new File(imagepath+"//"+udbimagefn));
		bs.updateb(udbname, udbwriter, udbcompany, udbprice, udbdate, udbinfo, udbimagefn, udbnum);
		return "redirect:/bookout";
	}//
	
	@RequestMapping(value = "/bookdetv", method = RequestMethod.GET)
	public String bookdetv(HttpServletRequest request, Model mo) {
		int detbnum=Integer.parseInt(request.getParameter("bnum"));
		BookService bs=sqlSession.getMapper(BookService.class);
		bs.readcntb(detbnum);
		ArrayList<BookDTO>list=bs.detailb(detbnum);
		mo.addAttribute("list", list);
		return "bookdetailview";
	}//
	
	@RequestMapping(value = "/booksearch", method = RequestMethod.GET)
	public String booksearch() {
		return "booksearch";
	}//

	@RequestMapping(value = "/booksearchsave", method = RequestMethod.POST)
	public String booksearchsave(HttpServletRequest request, Model mo) {
		String bookkey=request.getParameter("bookkey");
		String svalue="%"+request.getParameter("svalue")+"%";
		BookService bs=sqlSession.getMapper(BookService.class);
		ArrayList<BookDTO>list;
		if(bookkey.equals("bname")) {
			list=bs.bsn(svalue);
		}
		else if(bookkey.equals("bwriter")) {
			list=bs.bsw(svalue);
		}
		else if(bookkey.equals("bcompany")) {
			list=bs.bsc(svalue);
		}
		else {
			list=bs.bsi(svalue);
		}
		mo.addAttribute("list", list);
		return "booksearchview";
	}//
	
}
