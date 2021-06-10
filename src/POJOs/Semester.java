package POJOs;
import java.util.Date;

public class Semester implements java.io.Serializable {
    private String maHocKi;
    private String tenHocKi;
    private int namHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public Semester() {
    }
    public Semester(String maHocKi) {
        this.maHocKi = maHocKi;
    }
    public Semester(String maHocKi, String tenHocKi, int namHoc, Date ngayBatDau, Date ngayKetThuc) {
        this.maHocKi = maHocKi;
        this.tenHocKi = tenHocKi;
        this.namHoc = namHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaHocKi() {
        return this.maHocKi;
    } public void setMaHocKi(String maHocKi) {
        this.maHocKi = maHocKi;
    } public String getTenHocKi() {
        return this.tenHocKi;
    } public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
    } public int getNamHoc() {
        return this.namHoc;
    } public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    } public Date getNgayBatDau() {
        return this.ngayBatDau;
    } public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    } public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    } public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
