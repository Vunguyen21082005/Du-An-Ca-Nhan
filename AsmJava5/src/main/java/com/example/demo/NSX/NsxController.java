package com.example.demo.NSX;

import com.example.demo.SanPham.entity.NSX;
import com.example.demo.SanPham.repository.NsxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NsxController {
    @Autowired
    private NsxRepository nsx;
    @GetMapping("nsx/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listNsx",nsx.findAll());
        return "nsx/hien-thi";
    }
    @GetMapping("/nsx/delete/{Id}")
    private String delete(@PathVariable("Id") Long Id){
        nsx.deleteById(Id);
        return "redirect: nsx/hien-thi";
    }
    @PostMapping("nsx/add")
    private String add( NSX ns){
        nsx.save(ns);
        return "redirect: nsx/hien-thi";
    }
    @GetMapping("nsx/viewUpdate/{Id}")
    private String detail(@PathVariable("Id")Long Id,Model model){
        model.addAttribute("list",nsx.findById(Id));
        return "nsx/update";
    }
    @PostMapping("nsx/update")
    private  String update(NSX ns){
        nsx.save(ns);
        return "redirect: nsx/hien-thi";
    }
}
