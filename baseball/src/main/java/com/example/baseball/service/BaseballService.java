package com.example.baseball.service;

import com.example.baseball.dto.BatterDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface BaseballService {

    void insertb(int season, String proteam, String bname, int bgame, int pa, int epa, int ab, int runs, int single, int doub, int triple, int hr, int rbi, int sb, int cs, int bb, int hp, int ib, int so, int gdp, int sh, int sf, double wrcp, double bwar);

    ArrayList<BatterDTO> outb();

    BatterDTO dtvb(String bname, int season, String proteam);

    BatterDTO delvb(String bname, int season, String proteam);
    void deleteb(String bname, int season, String proteam);

    BatterDTO updvb(String bname, int season, String proteam);
    void updateb(int season, String proteam, String bname, int bgame, int pa, int epa, int ab, int runs, int single, int doub, int triple, int hr, int rbi, int sb, int cs, int bb, int hp, int ib, int so, int gdp, int sh, int sf, double wrcp, double bwar);

}
