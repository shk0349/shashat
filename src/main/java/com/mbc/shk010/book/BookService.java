package com.mbc.shk010.book;

import java.util.ArrayList;

import com.mbc.shk010.board.BoardDTO;
import com.mbc.shk010.board.PageDTO;

public interface BookService {

	void insertb(String bname, String bwriter, String bcompany, int bprice, String bdate, String binfo, String bimagefn);

	ArrayList<BookDTO> outb();

	ArrayList<BookDTO> delviewb(int dvbnum);
	void deleteb(int debnum);
	
	ArrayList<BookDTO> updviewb(int uvbnum);
	void updateb(String udbname, String udbwriter, String udbcompany, int udbprice, String udbdate, String udbinfo, String udbimagefn, int udbnum);

	void readcntb(int detbnum);
	ArrayList<BookDTO> detailb(int detbnum);

	ArrayList<BookDTO> bsn(String svalue);
	ArrayList<BookDTO> bsw(String svalue);
	ArrayList<BookDTO> bsc(String svalue);
	ArrayList<BookDTO> bsi(String svalue);

    public int total();
    public ArrayList<BoardDTO> page(PageDTO dto);
}
