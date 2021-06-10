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
    hoTen varchar(10),
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
	giaoVienLiThuyet varchar(10),
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




