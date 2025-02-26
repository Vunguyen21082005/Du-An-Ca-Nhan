package com.example.demo.Dong.controller;

import com.example.demo.SanPham.entity.DongSP;
import com.example.demo.SanPham.entity.MauSac;
import com.example.demo.SanPham.repository.DongSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DongController {
    @Autowired
    private DongSPRepository dong;
    @GetMapping("dong/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listMauSac",dong.findAll());
        return "dong/hien-thi";
    }
    @GetMapping("/dong/delete/{Id}")
    private String delete(@PathVariable("Id") Long Id){
        dong.deleteById(Id);
        return "redirect: dong/hien-thi";
    }
    @PostMapping("dong/add")
    private String add( DongSP dongSP){
        dong.save(dongSP);
        return "redirect: dong/hien-thi";
    }
    @GetMapping("dong/viewUpdate/{Id}")
    private String detail(@PathVariable("Id")Long Id,Model model){
        model.addAttribute("list",dong.findById(Id));
        return "dong/update";
    }
    @PostMapping("dong/update")
    private  String update(DongSP dongSP){
        dong.save(dongSP);
        return "redirect: dong/hien-thi";
    }
}
