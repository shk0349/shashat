package com.mbc.shk010.score;

public class ScoreDTO {
	int sclass, sban, sbunho;
	String sname;
	int kor, eng, mat, tot;
	double avg;
	String hakjum;
	int crank, brank;
	
	public ScoreDTO() {}

	public ScoreDTO(int sclass, int sban, int sbunho, String sname, int kor, int eng, int mat, int tot, double avg,
			String hakjum, int crank, int brank) {
		super();
		this.sclass = sclass;
		this.sban = sban;
		this.sbunho = sbunho;
		this.sname = sname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
		this.hakjum = hakjum;
		this.crank = crank;
		this.brank = brank;
	}

	public int getSclass() {
		return sclass;
	}

	public void setSclass(int sclass) {
		this.sclass = sclass;
	}

	public int getSban() {
		return sban;
	}

	public void setSban(int sban) {
		this.sban = sban;
	}

	public int getSbunho() {
		return sbunho;
	}

	public void setSbunho(int sbunho) {
		this.sbunho = sbunho;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getHakjum() {
		return hakjum;
	}

	public void setHakjum(String hakjum) {
		this.hakjum = hakjum;
	}

	public int getCrank() {
		return crank;
	}

	public void setCrank(int crank) {
		this.crank = crank;
	}

	public int getBrank() {
		return brank;
	}

	public void setBrank(int brank) {
		this.brank = brank;
	}
	
	

}
