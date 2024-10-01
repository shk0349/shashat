package com.mbc.shk010.member;

import java.util.ArrayList;

public interface MemberService {

	void insertm(String id, String pw, String name, String phone, String gender, String address, String hobby, String hello);

	ArrayList<MemberDTO> outm();

	ArrayList<MemberDTO> delviewm(String did);
	void delm(String dokid);

	ArrayList<MemberDTO> updviewm(String uid);
	void updatem(String uokpw, String uokname, String uoktell, String uokgender, String uokaddress, String uohobby, String uokhello, String uokid);

	ArrayList<MemberDTO> smi(String svalue);
	ArrayList<MemberDTO> smn(String svalue);
	ArrayList<MemberDTO> smg(String svalue);
	ArrayList<MemberDTO> sma(String svalue);

	int idch2(String id);

}
