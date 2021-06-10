package POJOs;


import javax.persistence.*;


@Entity
@Table(name = "Class")
public class Classroom implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maLop")
    private String maLop;

    @Column(name = "tenLop")
    private String tenLop;

    @Column(name = "tongSo")
    private int tongSo;

    @Column(name = "soNam")
    private int soNam;

    @Column(name = "soNu")
    private int soNu;

    public Classroom() {
    }
    public Classroom(String maLop) {
        this.maLop = maLop;
    }
    public Classroom(String maLop, String tenLop, int tongSo, int soNam, int soNu) {
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