package com.example.demo.NhanVien.controller;

import com.example.demo.NhanVien.entity.ChucVu;
import com.example.demo.NhanVien.entity.CuaHang;
import com.example.demo.NhanVien.entity.NhanVien;
import com.example.demo.NhanVien.repository.ChucVuRepository;
import com.example.demo.NhanVien.repository.CuaHangRepository;
import com.example.demo.NhanVien.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienRepository nv1;
    @Autowired
    private ChucVuRepository cv;
    @Autowired
    private CuaHangRepository ch;
    @GetMapping("nhan-vien/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listNhanVien",nv1.findAll());
        model.addAttribute("listCuaHang",ch.findAll());
        model.addAttribute("listChucVu",cv.findAll());
        return "nhan-vien/hien-thi";
    }
    @PostMapping("nhan-vien/add")
    private String add(NhanVien nhanVien){
        if (nhanVien.getIdCH() != null && nhanVien.getIdCH().getId() == null) {
            ch.save(nhanVien.getIdCH());
        }
        if (nhanVien.getIdCV() != null && nhanVien.getIdCV().getId() == null) {
            cv.save(nhanVien.getIdCV());
        }
        nv1.save(nhanVien);

        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("nhan-vien/delete/{id}")
    private String delete(@PathVariable("id") Long id,Model model){
        nv1.deleteById(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("nhan-vien/viewUpdate/{id}")
    private String detail(@PathVariable("id")Long id,Model model){
        model.addAttribute("list",nv1.findById(id));
        return "nhan-vien/update";
    }
    @PostMapping("nhan-vien/update")
    private String update(NhanVien nhanVien){
        nv1.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }


}
