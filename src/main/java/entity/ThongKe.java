
package entity;

public class ThongKe {
    private String IdSP;
    private String tenSP;
    private double doanhThu;
    private int soLuongDaBan;
    private int soLuongKhachHangDaMua;

    public ThongKe() {
    }

    public ThongKe(String IdSP, String tenSP, double doanhThu, int soLuongDaBan, int soLuongKhachHangDaMua) {
        this.IdSP = IdSP;
        this.tenSP = tenSP;
        this.doanhThu = doanhThu;
        this.soLuongDaBan = soLuongDaBan;
        this.soLuongKhachHangDaMua = soLuongKhachHangDaMua;
    }

    public String getIdSP() {
        return IdSP;
    }

    public void setIdSP(String IdSP) {
        this.IdSP = IdSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public int getSoLuongKhachHangDaMua() {
        return soLuongKhachHangDaMua;
    }

    public void setSoLuongKhachHangDaMua(int soLuongKhachHangDaMua) {
        this.soLuongKhachHangDaMua = soLuongKhachHangDaMua;
    }

    @Override
    public String toString() {
        return "ThongKeSanPham{" +
                "maSanPham='" + IdSP + '\'' +
                ", tenSanPham='" + tenSP + '\'' +
                ", doanhThu=" + doanhThu +
                ", soLuongDaBan=" + soLuongDaBan +
                ", soLuongKhachHangDaMua=" + soLuongKhachHangDaMua +
                '}';
    }
}
