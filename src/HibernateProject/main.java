package HibernateProject;
import java.util.*;

import DAO.ClassroomDAO;
import POJOs.Classroom;

public class main {
    public static void main(String[] args) {

//        List<SinhVienAccount> ds= SinhVienAccountDAO.layDanhSachSinhVien();
//        for(int i=0; i<ds.size(); i++){
//            SinhVienAccount sv=ds.get(i);
//            System.out.println("MSSV: "+sv.getMaSinhVien());
//            System.out.println("Họ và tên: "+sv.getHoTen());
//        }

        List<Classroom> ds= ClassroomDAO.layDanhSachLop();
        for(int i=0; i<ds.size(); i++){
            Classroom sv= ds.get(i);
            System.out.println("MSSV: "+sv.getMaLop());
            System.out.println("Họ và tên: "+sv.getTenLop());
        }
    }
}
