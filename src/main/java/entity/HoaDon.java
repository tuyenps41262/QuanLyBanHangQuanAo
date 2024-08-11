
package entity;

import java.util.Date;
import util.XDate;

public class HoaDon {
    private String idHD;
    private String dienThoai;
    private String trangThaiThanhToan;
    private Date ngayLap;
    private String diaChi;
    private int idKH;
    private String TenNguoiNhan;
    private Double ThanhTien;

    public HoaDon() {
    }

    public HoaDon(String idHD, String dienThoai, String trangThaiThanhToan, Date ngayLap, String diaChi, int idKH, String TenNguoiNhan, Double ThanhTien) {
        this.idHD = idHD;
        this.dienThoai = dienThoai;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.ngayLap = ngayLap;
        this.diaChi = diaChi;
        this.idKH = idKH;
        this.TenNguoiNhan = TenNguoiNhan;
        this.ThanhTien = ThanhTien;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String TenNguoiNhan) {
        this.TenNguoiNhan = TenNguoiNhan;
    }

    public Double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

   
    
    

    

}
