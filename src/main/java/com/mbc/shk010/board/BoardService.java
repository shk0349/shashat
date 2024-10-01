package com.mbc.shk010.board;

import java.util.ArrayList;

public interface BoardService {

	void insertb(String bwriter, String btitle, String bcontents);

	ArrayList<BoardDTO> outb();

	BoardDTO detailvb(int dvbnum);
	void countb(int dvbnum);

	BoardDTO replyb(int rebnum);

	void stepup(int rsgroups, int rsstep);
	void replyinsertb(int rsbnum, String bwriter, String btitle, String bcontents, int rsgroups, int rsstep, int rsindent);

    public int total();
    public ArrayList<BoardDTO> page(PageDTO dto);

	ArrayList<BoardDTO> delviewb(int dvbnum);
	void deleteb(int dbnum);

	ArrayList<BoardDTO> uptviewb(int uvbnum);
	void updateb(String udbwriter, String udbtitle, String udbcontents, int udbnum);

	ArrayList<BoardDTO> bsw(String svalue);
	ArrayList<BoardDTO> bst(String svalue);
	ArrayList<BoardDTO> bsc(String svalue);



}
