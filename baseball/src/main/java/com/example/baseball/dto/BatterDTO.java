package com.example.baseball.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BatterDTO {
    int season;
    String proteam, bname;
    int bgame, pa, epa, ab, runs, single, doub, triple, hr, rbi, sb, cs, bb, hp, ib, so, gdp, sh, sf, hits, tb;
    double wrcp, bwar, avg, obp, slg, ops, isod, isop, kp, bp, bbk, sbsp;
}
