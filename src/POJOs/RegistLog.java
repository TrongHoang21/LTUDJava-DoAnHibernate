package POJOs;

import java.util.Date;

public class RegistLog implements java.io.Serializable {
    private String maSinhVien;
    private String maCourse;
    private Date ngayDangKi;

    public RegistLog() {
    }
    public RegistLog(String maSinhVien, String maCourse, Date ngayDangKi) {
        this.maCourse = maCourse;
        this.maSinhVien = maSinhVien;
        this.ngayDangKi = ngayDangKi;
    }

    public String getMaCourse() {
        return this.maCourse;
    } public void setMaCourse(String maCourse) {
        this.maCourse = maCourse;
    } public String getMaSinhVien() {
        return this.maSinhVien;
    } public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    } public Date getNgayDangKi() {
        return this.ngayDangKi;
    } public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }
}