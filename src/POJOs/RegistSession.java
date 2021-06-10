package POJOs;

import java.util.Date;

public class RegistSession implements java.io.Serializable {
    private String maHocKi;
    private String maSession;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public RegistSession() {
    }
    public RegistSession(String maHocKi) {
        this.maHocKi = maHocKi;
    }
    public RegistSession(String maSession, String maHocKi, Date ngayBatDau, Date ngayKetThuc) {
        this.maHocKi = maHocKi;
        this.maSession = maSession;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaHocKi() {
        return this.maHocKi;
    } public void setMaHocKi(String maHocKi) {
        this.maHocKi = maHocKi;
    } public String getMaSession() {
        return this.maSession;
    } public void setMaSession(String maSession) {
        this.maSession = maSession;
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