package com.example.demo.ChucVu;

import com.example.demo.NhanVien.entity.ChucVu;
import com.example.demo.NhanVien.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChucVuController {
    @Autowired
    private ChucVuRepository chucVu;
    @GetMapping("chuc-vu/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listChucVu",chucVu.findAll());
        return "chuc-vu/hien-thi";
    }
    @GetMapping("/chuc-vu/delete/{Id}")
    private String delete(@PathVariable("Id") Long Id){
        chucVu.deleteById(Id);
        return "redirect: chuc-vu/hien-thi";
    }
    @PostMapping("chuc-vu/add")
    private String add( ChucVu cv){
        chucVu.save(cv);
        return "redirect: chuc-vu/hien-thi";
    }
    @GetMapping("chuc-vu/viewUpdate/{Id}")
    private String detail(@PathVariable("Id")Long Id,Model model){
        model.addAttribute("list",chucVu.findById(Id));
        return "chuc-vu/update";
    }
    @PostMapping("chuc-vu/update")
    private  String update(ChucVu cv){
        chucVu.save(cv);
        return "redirect: chuc-vu/hien-thi";
    }

}
