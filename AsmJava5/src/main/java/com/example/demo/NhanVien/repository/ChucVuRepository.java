package com.example.demo.NhanVien.repository;

import com.example.demo.NhanVien.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,Long> {
}
