package POJOs;


public class SinhVienAccount implements java.io.Serializable {
    private String maSo;
    private String userName;
    private String passWord;
    private String maLop;
    private String maSinhVien;
    private String hoTen;
    public SinhVienAccount() {
    }
    public SinhVienAccount(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public SinhVienAccount(String maSo, String userName, String passWord, String maLop, String maSinhVien, String hoTen) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.maSo = maSo;
        this.userName = userName;
        this.passWord = passWord;
        this.maLop = maLop;
    }

    public String getMaSinhVien() {
        return this.maSinhVien;
    } public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    } public String getHoTen() {
        return this.hoTen;
    } public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    } public String getID() {
        return this.maSo;
    } public void setID(String maSo) {
        this.maSo = maSo;
    } public String getMaLop() {
        return this.maLop;
    } public void setMaLop(String maLop) {
        this.maLop = maLop;
    } public String getUserName() {
        return this.userName;
    } public void setUserName(String userName) {
        this.userName = userName;
    } public String getPassWord() {
        return this.passWord;
    } public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

