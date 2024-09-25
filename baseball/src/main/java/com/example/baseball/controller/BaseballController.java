package com.example.baseball.controller;

import com.example.baseball.dto.BatterDTO;
import com.example.baseball.service.BaseballService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class BaseballController {

    @Autowired
    SqlSession sqlsession;

    @GetMapping("/")
    public String Home() {
        return "main";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/batterinput")
    public String batterinput() {
        return "batterinput";
    }

    @PostMapping("/battersave")
    public String battersave(HttpServletRequest request) {
        int season=Integer.parseInt(request.getParameter("season"));
        String proteam=request.getParameter("proteam");
        String bname=request.getParameter("bname");
        int bgame=Integer.parseInt(request.getParameter("bgame"));
        int pa=Integer.parseInt(request.getParameter("pa"));
        int epa=Integer.parseInt(request.getParameter("epa"));
        int ab=Integer.parseInt(request.getParameter("ab"));
        int runs=Integer.parseInt(request.getParameter("runs"));
        int single=Integer.parseInt(request.getParameter("single"));
        int doub=Integer.parseInt(request.getParameter("doub"));
        int triple=Integer.parseInt(request.getParameter("triple"));
        int hr=Integer.parseInt(request.getParameter("hr"));
        int rbi=Integer.parseInt(request.getParameter("rbi"));
        int sb=Integer.parseInt(request.getParameter("sb"));
        int cs=Integer.parseInt(request.getParameter("cs"));
        int bb=Integer.parseInt(request.getParameter("bb"));
        int hp=Integer.parseInt(request.getParameter("hp"));
        int ib=Integer.parseInt(request.getParameter("ib"));
        int so=Integer.parseInt(request.getParameter("so"));
        int gdp=Integer.parseInt(request.getParameter("gdp"));
        int sh=Integer.parseInt(request.getParameter("sh"));
        int sf=Integer.parseInt(request.getParameter("sf"));
        double wrcp = Double.parseDouble(request.getParameter("wrcp"));
        double bwar = Double.parseDouble(request.getParameter("bwar"));
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        bs.insertb(season, proteam, bname, bgame, pa, epa, ab, runs, single, doub, triple, hr, rbi, sb, cs, bb, hp, ib, so, gdp, sh, sf, wrcp, bwar);
        return "main";
    }

    @GetMapping("/batterout")
    public String batterout(Model mo) {
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        ArrayList<BatterDTO>bt=bs.outb();
        mo.addAttribute("bt",bt);
        return "batterout";
    }

    @GetMapping("/batterdetailview")
    public String batterdetailview(Model mo, HttpServletRequest request) {
        String bname=request.getParameter("bname");
        int season=Integer.parseInt(request.getParameter("season"));
        String proteam=request.getParameter("proteam");
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        BatterDTO bt=bs.dtvb(bname, season, proteam);
        mo.addAttribute("bt",bt);
        return "batterdetailview";
    }

    @GetMapping("/batterdeleteview")
    public String batterdeleteview(Model mo, HttpServletRequest request) {
        String bname=request.getParameter("bname");
        int season=Integer.parseInt(request.getParameter("season"));
        String proteam=request.getParameter("proteam");
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        BatterDTO bt=bs.delvb(bname, season, proteam);
        mo.addAttribute("bt",bt);
        return "batterdeleteview";
    }

    @PostMapping("/batterdelete")
    public String batterdelete(HttpServletRequest request) {
        String bname=request.getParameter("bname");
        int season=Integer.parseInt(request.getParameter("season"));
        String proteam=request.getParameter("proteam");
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        bs.deleteb(bname, season, proteam);
        return "redirect:/batterout";
    }

    @GetMapping("/batterupdateview")
    public String batterupdateview(Model mo, HttpServletRequest request) {
        String bname=request.getParameter("bname");
        int season=Integer.parseInt(request.getParameter("season"));
        String proteam=request.getParameter("proteam");
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        BatterDTO bt=bs.updvb(bname, season, proteam);
        mo.addAttribute("bt",bt);
        return "batterupdateview";
    }

    @PostMapping("/batterupdate")
    public String batterupdate(HttpServletRequest request) {
        int season=Integer.parseInt(request.getParameter("season"));
        String proteam=request.getParameter("proteam");
        String bname=request.getParameter("bname");
        int bgame=Integer.parseInt(request.getParameter("bgame"));
        int pa=Integer.parseInt(request.getParameter("pa"));
        int epa=Integer.parseInt(request.getParameter("epa"));
        int ab=Integer.parseInt(request.getParameter("ab"));
        int runs=Integer.parseInt(request.getParameter("runs"));
        int single=Integer.parseInt(request.getParameter("single"));
        int doub=Integer.parseInt(request.getParameter("doub"));
        int triple=Integer.parseInt(request.getParameter("triple"));
        int hr=Integer.parseInt(request.getParameter("hr"));
        int rbi=Integer.parseInt(request.getParameter("rbi"));
        int sb=Integer.parseInt(request.getParameter("sb"));
        int cs=Integer.parseInt(request.getParameter("cs"));
        int bb=Integer.parseInt(request.getParameter("bb"));
        int hp=Integer.parseInt(request.getParameter("hp"));
        int ib=Integer.parseInt(request.getParameter("ib"));
        int so=Integer.parseInt(request.getParameter("so"));
        int gdp=Integer.parseInt(request.getParameter("gdp"));
        int sh=Integer.parseInt(request.getParameter("sh"));
        int sf=Integer.parseInt(request.getParameter("sf"));
        double wrcp = Double.parseDouble(request.getParameter("wrcp"));
        double bwar = Double.parseDouble(request.getParameter("bwar"));
        BaseballService bs=sqlsession.getMapper(BaseballService.class);
        bs.updateb(season, proteam, bname, bgame, pa, epa, ab, runs, single, doub, triple, hr, rbi, sb, cs, bb, hp, ib, so, gdp, sh, sf, wrcp, bwar);
        return "redirect:/batterout";
    }

}
