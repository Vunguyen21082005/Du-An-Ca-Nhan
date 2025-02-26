package com.example.demo.NhanVien.repository;

import com.example.demo.NhanVien.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang,Long> {
}
