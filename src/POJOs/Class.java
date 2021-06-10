package POJOs;

import java.util.Date;

public class Class implements java.io.Serializable {
    private String maLop;
    private String tenLop;
    private int tongSo;
    private int soNam;
    private int soNu;

    public Class() {
    }
    public Class(String maLop) {
        this.maLop = maLop;
    }
    public Class(String maLop, String tenLop, int tongSo, int soNam, int soNu) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.tongSo = tongSo;
        this.soNam = soNam;
        this.soNu = soNu;
    }

    public String getMaLop() {
        return this.maLop;
    } public void setMaLop(String maLop) {
        this.maLop = maLop;
    } public String getTenLop() {
        return this.tenLop;
    } public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    } public int getTongSo() {
        return this.tongSo;
    } public void setTongSo(int tongSo) {
        this.tongSo = tongSo;
    } public int getSoNam() {
        return this.soNam;
    } public void setSoNam(int soNam) {
        this.soNam = soNu;
    } public int getSoNu() {
        return this.soNu;
    } public void setSoNu(int soNu) {
        this.soNu = soNu;
    }
}