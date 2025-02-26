package com.example.demo.SanPham.repository;

import com.example.demo.SanPham.entity.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietRepository extends JpaRepository<ChiTietSP,Long> {
}
