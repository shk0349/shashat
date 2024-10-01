package com.mbc.shk010.board;

public class BoardDTO {
	int bnum;
	String bwriter, btitle, bcontents, bdate;
	int bcnt, groups, step, indent;
	
	public BoardDTO() {}

	public BoardDTO(int bnum, String bwriter, String btitle, String bcontents, String bdate, int bcnt, int groups,
			int step, int indent) {
		super();
		this.bnum = bnum;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bdate = bdate;
		this.bcnt = bcnt;
		this.groups = groups;
		this.step = step;
		this.indent = indent;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontents() {
		return bcontents;
	}

	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBcnt() {
		return bcnt;
	}

	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}

	public int getGroups() {
		return groups;
	}

	public void setGroups(int groups) {
		this.groups = groups;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}
	
}
