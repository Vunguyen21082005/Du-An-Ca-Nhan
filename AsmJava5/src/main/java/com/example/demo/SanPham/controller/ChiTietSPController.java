package com.example.demo.SanPham.controller;

import com.example.demo.SanPham.entity.ChiTietSP;
import com.example.demo.SanPham.entity.DongSP;
import com.example.demo.SanPham.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChiTietSPController {
    @Autowired
    private ChiTietRepository ct;
  @Autowired
    private DongSPRepository dongSP;
    @Autowired
    private MauSPRepository mau;
    @Autowired
    private NsxRepository nsx;
    @Autowired
    private SanPhamRepository sp;
    @GetMapping("chi-tiet-san-pham/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listChiTiet",ct.findAll());
        model.addAttribute("listSP",sp.findAll());
        model.addAttribute("listDong",dongSP.findAll());
        model.addAttribute("listMau",mau.findAll());
        model.addAttribute("listNSX",nsx.findAll());
        return "chi-tiet-san-pham/hien-thi";
    }
    @PostMapping("chi-tiet-san-pham/add")
    private String add(ChiTietSP ctsp){
        ct.save(ctsp);
        return "redirect: chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("chi-tiet-san-pham/delete/{id}")
    private String delete(@PathVariable("id")Long id){
        ct.deleteById(id);
        return "redirect: chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("chi-tiet-san-pham/viewUpdate/{id}")
    private String detail(@PathVariable("id") Long id,Model model){
        model.addAttribute("list",ct.findById(id));
        return "chi-tiet-san-pham/update";
    }
    @GetMapping("chi-tiet-san-pham/update")
    private String update(ChiTietSP sp){
        ct.save(sp);
        return "redirect: chi-tiet-san-pham/hien-thi";
    }

}
