package POJOs;

public class GiaoVuAccount implements java.io.Serializable {
    private String maSo;
    private String userName;
    private String passWord;

    public GiaoVuAccount() {
    }
    public GiaoVuAccount(String maSo) {
        this.maSo = maSo;
    }
    public GiaoVuAccount(String maSo, String userName, String passWord) {
        this.maSo = maSo;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getMaSo() {
        return this.maSo;
    } public void setMaSo(String maSo) {
        this.maSo = maSo;
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
