package POJOs;

import java.util.Date;

public class Course implements java.io.Serializable {
    private String maCourse;
    private String maMonHoc;
    private String giaoVienLiThuyet;
    private String tenPhongHoc;
    private int ngayHoc;
    private int caHoc;
    private int soSlotToiDa;

    public Course() {
    }
    public Course(String maCourse) {
        this.maCourse = maCourse;
    }
    public Course(String maCourse, String maMonHoc, String giaoVienLiThuyet, String tenPhongHoc,
                  int ngayHoc, int caHoc, int soSlotToiDa) {
        this.maCourse = maCourse;
        this.maMonHoc = maMonHoc;
        this.giaoVienLiThuyet = giaoVienLiThuyet;
        this.tenPhongHoc = tenPhongHoc;
        this.ngayHoc = ngayHoc;
        this.caHoc = caHoc;
        this.soSlotToiDa = soSlotToiDa;

    }

    public String getMaCourse() {
        return this.maCourse;
    } public void setMaCourse(String maCourse) {
        this.maCourse = maCourse;
    } public String getMaMonHoc() {
        return this.maMonHoc;
    } public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    } public String getTenPhongHoc() {
        return this.tenPhongHoc;
    } public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    } public String getGiaoVienLiThuyet() {
        return this.giaoVienLiThuyet;
    } public void setGiaoVienLiThuyet(String giaoVienLiThuyet) {
        this.giaoVienLiThuyet = giaoVienLiThuyet;
    } public int getNgayHoc() {
        return this.ngayHoc;
    } public void setNgayHoc(int ngayHoc) {
        this.ngayHoc = ngayHoc;
    } public int getCaHoc() {
        return this.caHoc;
    } public void setCaHoc(int caHoc) {
        this.caHoc = caHoc;
    } public int getSoSlotToiDa() {
        return this.soSlotToiDa;
    } public void setSoSlotToiDa(int soSlotToiDa) {
        this.soSlotToiDa = soSlotToiDa;
    }
}