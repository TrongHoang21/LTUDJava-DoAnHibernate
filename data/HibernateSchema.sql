create database Hibernate;
use Hbernate;

create table GiaoVuAccount(
	iD Varchar(10) PRIMARY KEY,
    userame varchar(10),
    password varchar(10)
);

create table SinhVienAccount(
	iD varchar(10) PRIMARY KEY,
    username varchar(10),
    password varchar(10),
    hoTen varchar(10),
    maSinhVien varchar(10),
    maLop varchar(10)
);
    
create table Subject(
    





