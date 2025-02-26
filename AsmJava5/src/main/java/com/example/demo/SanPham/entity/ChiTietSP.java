package com.example.demo.SanPham.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "IdSP",referencedColumnName = "Id")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "IdNsx",referencedColumnName = "Id")
    private NSX nsx;
    @ManyToOne
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac mau;
    @ManyToOne
    @JoinColumn(name = "IdDongSP",referencedColumnName = "Id")
    private DongSP dong;
    @Column
    private Integer NamBH;
    @Column
    private String MoTa;
    @Column
    private Integer SoLuongTon;
    @Column
    private Integer GiaNhap;
    @Column
    private Integer GiaBan;

}
