package com.example.demo.SanPham.repository;

import com.example.demo.SanPham.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSPRepository extends JpaRepository<MauSac,Long> {
}
