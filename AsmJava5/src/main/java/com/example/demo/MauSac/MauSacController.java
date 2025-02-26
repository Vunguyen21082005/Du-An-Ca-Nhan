package com.example.demo.MauSac;

import com.example.demo.SanPham.entity.MauSac;
import com.example.demo.SanPham.repository.MauSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MauSacController {
    @Autowired
    private MauSPRepository mauSac;
    @GetMapping("mau-sac/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listMauSac",mauSac.findAll());
        return "mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/delete/{id}")
    private String delete(@PathVariable("id") Long id){
        mauSac.deleteById(id);
        return "redirect: mau-sac/hien-thi";
    }
    @PostMapping("mau-sac/add")
    private String add( MauSac ms){
        mauSac.save(ms);
        return "redirect: mau-sac/hien-thi";
    }
    @GetMapping("mau-sac/viewUpdate/{id}")
    private String detail(@PathVariable("id")Long id,Model model){
        model.addAttribute("list",mauSac.findById(id));
        return "mau-sac/update";
    }
    @PostMapping("mau-sac/update")
    private  String update(MauSac mau){
        mauSac.save(mau);
        return "redirect: mau-sac/hien-thi";
    }
}
