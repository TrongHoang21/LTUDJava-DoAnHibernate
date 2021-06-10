package POJOs;

public class Subject implements java.io.Serializable {
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public Subject() {
    }
    public Subject(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    public Subject(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public String getMaMonHoc() {
        return this.maMonHoc;
    } public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    } public String getTenMonHoc() {
        return this.tenMonHoc;
    } public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    } public int getSoTinChi() {
        return this.soTinChi;
    } public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
