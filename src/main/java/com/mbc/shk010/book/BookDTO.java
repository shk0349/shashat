package com.mbc.shk010.book;

public class BookDTO {
	int bnum;
	String bname, bwriter, bcompany;
	int bprice;
	String bdate, binfo, bimage;
	int bcnt;
	
	public BookDTO() {}

	public BookDTO(int bnum, String bname, String bwriter, String bcompany, int bprice, String bdate, String binfo,
			String bimage, int bcnt) {
		super();
		this.bnum = bnum;
		this.bname = bname;
		this.bwriter = bwriter;
		this.bcompany = bcompany;
		this.bprice = bprice;
		this.bdate = bdate;
		this.binfo = binfo;
		this.bimage = bimage;
		this.bcnt = bcnt;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBcompany() {
		return bcompany;
	}

	public void setBcompany(String bcompany) {
		this.bcompany = bcompany;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	public String getBimage() {
		return bimage;
	}

	public void setBimage(String bimage) {
		this.bimage = bimage;
	}

	public int getBcnt() {
		return bcnt;
	}

	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}

}
