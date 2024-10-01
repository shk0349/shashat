package com.mbc.shk010.score;

import java.util.ArrayList;

import com.mbc.shk010.board.BoardDTO;
import com.mbc.shk010.board.PageDTO;

public interface ScoreService {

	void inserts(int sclass, int sban, int sbunho, String sname, int kor, int eng, int mat, int tot, double avg);

	ArrayList<ScoreDTO> outs();

	ArrayList<ScoreDTO> delvs(int dvsclass, int dvsban, int dvsbunho);
	void deletes(int delsclass, int delsban, int delsbunho);

	ArrayList<ScoreDTO> updvs(int udvsclass, int udvsban, int udvsbunho);
	void updates(int udkor, int udeng, int udmat, int udtot, double udavg, int udsclass, int udsban, int udsbunho);

	ArrayList<ScoreDTO> ssc(String svalue);
	ArrayList<ScoreDTO> ssb(String svalue);
	ArrayList<ScoreDTO> ssn(String svalue);
	
    public int total();
    public ArrayList<BoardDTO> page(PageDTO dto);
}
