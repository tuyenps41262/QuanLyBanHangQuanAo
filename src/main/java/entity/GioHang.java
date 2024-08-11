
package entity;

public class GioHang {
    private int soLuong;
    private int idKH;
    private String idSP;
    private String TenSP;
    private double GiaBan;

    public GioHang() {
    }

    public GioHang(int soLuong, int idKH, String idSP, String TenSP, double GiaBan) {
        this.soLuong = soLuong;
        this.idKH = idKH;
        this.idSP = idSP;
        this.TenSP = TenSP;
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    

    
}
