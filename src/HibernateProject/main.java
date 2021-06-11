package HibernateProject;
import java.util.*;

import DAO.ClassroomDAO;
import DAO.SinhVienAccountDAO;
import POJOs.Classroom;
import POJOs.SinhVienAccount;

public class main {
    public static void main(String[] args) {



//        SinhVienAccount sv = SinhVienAccountDAO.searchSinhVien("1001");
//        if(sv!=null){
//            System.out.println("MSSV: " + sv.getMaSinhVien());
//            System.out.println("Họ và tên: " +
//                    sv.getHoTen());
//        }else{
//            System.out.println("Sinh viên 1001 không tồn tại");
//        }

//        SinhVienAccount sv1 = new SinhVienAccount();
//        sv1.setMaSinhVien("1008");
//        sv1.setHoTen("Tạ Tấn Thêm");
//        sv1.setMaSo("s008");
//        boolean kq = SinhVienAccountDAO.addSinhVien(sv1);
//        if (kq == true) {
//            System.out.println("Thêm thành công");
//        } else {
//            System.out.println("Thêm thất bại");
//        }

//        SinhVienAccount sv1 = SinhVienAccountDAO.searchSinhVien("1008");
//        if (sv1 != null) {
//            sv1.setHoTen("Tạ Tấn Trung");
//            boolean kq = SinhVienAccountDAO.updateSinhVien(sv1);
//            if (kq == true) {
//                System.out.println("Cập nhật thành công");
//            } else {
//                System.out.println("Cập nhật thất bại");
//            }
//        }

        boolean kq = SinhVienAccountDAO.deleteSinhVien("1008");
        if (kq == true) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }

        List<SinhVienAccount> ds= SinhVienAccountDAO.showListSinhVien();
        for(int i=0; i<ds.size(); i++){
            SinhVienAccount sv=ds.get(i);
            System.out.println("MSSV: "+sv.getMaSinhVien());
            System.out.println("Họ và tên: "+sv.getHoTen());
        }

    }
}
