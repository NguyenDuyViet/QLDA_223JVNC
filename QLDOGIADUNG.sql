create database QLSHOPDOGIADUNG
go
use QLSHOPDOGIADUNG
go
create table Users
(
	MaKH char(7) primary key,
	Ho nvarchar(10),
	Ten nvarchar(30),
	SDT char(10) unique,
	Email varchar(50) unique,
	DiaChi nvarchar(50)	,
	MatKhau varchar(20)
)
create table DonDatHang
(
	MaDatHang char(7) primary key,
	TrangThaiDatHang integer default '1' /* 0 là hủy đặt hàng, 1 là đặt thành công*/,
	TrangThaiGiaoHang integer default '1' /* 0 là khách hủy đặt hàng, 1 là đang giao hàng, 2 là giao hàng thành công*/,
	NgayDatHang date,
	NgayGiaoHang date,
	SoLuong integer check (SoLuong >=0),
	MaKH char(7) foreign key references Users(MaKH)
	ON DELETE CASCADE  ON UPDATE CASCADE
)
create table HangDuocDat
(
	MaHang char(7) primary key,
	Gia money check (Gia >=0),
	MaDatHang char(7) foreign key references DonDatHang(MaDatHang),
	MaSanPham char(7) foreign key references SanPham(MaSanPham)
	ON DELETE CASCADE  ON UPDATE CASCADE
)
create table SanPham
(
	MaSanPham char(7) primary key,
	TenSanPham nvarchar(30),
	GiaBan money check (GiaBan >=0),
	MaLoai char(7) foreign key references KhoHang(MaLoai),
	MaHang char(7) foreign key references Hang(MaHang)
	ON DELETE CASCADE  ON UPDATE CASCADE
)
create table KhoHang
(
	MaLoai char(7) primary key,
	TenLoai nvarchar(50),
	SoLuongNhapVao integer,
	GiaNhap money check (GiaNhap >=0),
	TonKho integer	
)
create table Hang /*Hãng*/
(
	MaHang char(7) primary key,
	TenHang nvarchar(20)
)