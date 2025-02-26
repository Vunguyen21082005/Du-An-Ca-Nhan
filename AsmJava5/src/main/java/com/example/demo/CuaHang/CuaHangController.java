package com.example.demo.CuaHang;

import com.example.demo.NhanVien.entity.CuaHang;
import com.example.demo.NhanVien.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CuaHangController {
    @Autowired
    private CuaHangRepository cuaHang;
    @GetMapping("cua-hang/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listCuaHang",cuaHang.findAll());
        return "cua-hang/hien-thi";
    }
    @GetMapping("/cua-hang/delete/{Id}")
    private String delete(@PathVariable("Id") Long Id){
        cuaHang.deleteById(Id);
        return "redirect: cua-hang/hien-thi";
    }
    @PostMapping("cua-hang/add")
    private String add( CuaHang ch){
        cuaHang.save(ch);
        return "redirect: cua-hang/hien-thi";
    }
    @GetMapping("cua-hang/viewUpdate/{Id}")
    private String detail(@PathVariable("Id")Long Id,Model model){
        model.addAttribute("list",cuaHang.findById(Id));
        return "redirect: cua-hang/hien-thi";
    }
    @PostMapping("cua-hang/update")
    private  String update(CuaHang ch){
        cuaHang.save(ch);
        return "redirect: cua-hang/hien-thi";
    }
}
