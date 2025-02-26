package com.example.demo.SanPham.repository;

import com.example.demo.SanPham.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSPRepository extends JpaRepository<DongSP,Long> {
}
