package com.example.demo.SanPham.repository;

import com.example.demo.SanPham.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
//    List<SanPham> findSanPhamAndTen(Long id, String Ten);
//
//
//    @Query("SELECT c FROM SanPham c WHERE c.Id = ?2 AND c.Ten = ?1")
//    List<SanPham> search(String name, Long id);

}
