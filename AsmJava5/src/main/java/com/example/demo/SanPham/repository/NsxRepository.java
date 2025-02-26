package com.example.demo.SanPham.repository;

import com.example.demo.SanPham.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NsxRepository extends JpaRepository<NSX,Long> {
}
