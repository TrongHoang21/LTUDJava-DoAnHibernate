create database Hibernate;
use Hibernate;

create table Class(
	maLop varchar(4) PRIMARY KEY,
    tenLop varchar(10),
    tongSo int,
    soNam int,
    soNu int
);

create table GiaoVuAccount(
	maSo Varchar(4) PRIMARY KEY,
    userame varchar(10),
    pass varchar(10)
);

create table SinhVienAccount(
	maSo varchar(4) PRIMARY KEY,
    username varchar(10),
    pass varchar(10),
    hoTen varchar(20),
    maSinhVien varchar(4) UNIQUE,
    maLop varchar(4),
    FOREIGN KEY SinhVienAccount(maLop) REFERENCES Class(maLop)
);
  
create table Subject(
	maMonHoc varchar(4) PRIMARY KEY,
    tenMonHoc varchar(10),
    soTinChi int
);

create table Semester(
	maHocKi varchar(4) PRIMARY KEY,
    tenHocKi int,
    namHoc int,
    ngayBatDau datetime,
    ngayKetThuc datetime
);

create table RegistSession(
	maSession varchar(4) PRIMARY KEY,
    ngayBatDau datetime,
    ngayKetThuc datetime,
    maHocKi varchar(4),
    FOREIGN KEY RegistSession(maHocKi) REFERENCES Semester(maHocKi)
);

create table Course(
	maCourse varchar(4) PRIMARY KEY,
	maMonHoc varchar(4), 
	giaoVienLiThuyet varchar(20),
	tenPhongHoc varchar(10),
	ngayHoc int,
	caHoc int,
	soSlotToiDa int,
    FOREIGN KEY Course(maMonHoc) REFERENCES Subject(maMonHoc)
);

create table RegistLog(
	maSinhVien varchar(4),
    maCourse varchar(4),
    ngayDangKi datetime,
    PRIMARY KEY (maSinhVien, maCourse),
    FOREIGN KEY RegistLog(maSinhVien) REFERENCES SinhVienAccount(maSinhVien),
    FOREIGN KEY RegistLog(maCourse) REFERENCES Course(maCourse)
);

insert into Class values ("cl01", "18ctt3", 2, 1, 1);
insert into Class values ("cl02", "18ctt4", 3, 2, 1);
insert into Class values ("cl03", "18ctt5", 2, 0, 2);

insert into GiaoVuAccount values ("gv01", "vu", "1");
insert into GiaoVuAccount values ("gv02", "nam", "1");
insert into GiaoVuAccount values ("gv03", "khoa", "1");

insert into SinhVienAccount values ("s001", "hoang", "1", "Bui Huy Hoang", "1001", "cl01");
insert into SinhVienAccount values ("s002", "nga", "1", "Tran Thi Nga", "1002", "cl01");
insert into SinhVienAccount values ("s003", "thu", "1", "Nguyen Xuan Thu", "1003", "cl02");
insert into SinhVienAccount values ("s004", "minh", "1", "Le Cong Minh", "1004", "cl02");
insert into SinhVienAccount values ("s005", "nam", "1", "Van Chi Nam", "1005", "cl02");
insert into SinhVienAccount values ("s006", "nguyen", "1", "Doan Hoang Nguyen", "1006", "cl03");
insert into SinhVienAccount values ("s007", "anh", "1", "Nguyen Minh Anh", "1007", "cl03");

insert into Subject values ("sj01", "Java", 4);
insert into Subject values ("sj02", "Python", 4);
insert into Subject values ("sj03", "Calculus 1", 4);

insert into Semester values ("sm01", "1", 2020, "2020-01-01", "2020-03-31");
insert into Semester values ("sm02", "2", 2020, "2020-04-01", "2020-06-30");
insert into Semester values ("sm03", "3", 2020, "2020-07-01", "2020-09-30");

insert into RegistSession values ("ss01", "2020-01-01", "2020-01-02", "sm01");
insert into RegistSession values ("ss02", "2020-04-01", "2020-04-02", "sm02");
insert into RegistSession values ("ss03", "2020-07-01", "2020-07-02", "sm03");
    
insert into Course values ("cs01", "sj01", "Huy Nam", "E101", 2, 1, 50);
insert into Course values ("cs02", "sj02", "Duy Toan", "F102", 3, 3, 50);
insert into Course values ("cs03", "sj03", "Duc Thinh", "G103", 4, 1, 50);

insert into RegistLog values ("1001", "cs01", "2020-01-01");
insert into RegistLog values ("1002", "cs02", "2020-04-01");
insert into RegistLog values ("1003", "cs03", "2020-07-01");
