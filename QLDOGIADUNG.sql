create database QLSHOPDOGIADUNG
go
use QLSHOPDOGIADUNG
go
create table Users
(
	MaKH char(5) primary key,
	Ho nvarchar(10),
	Ten nvarchar(30),
	SDT char(10) unique,
	Email varchar(50) unique,
	DiaChi nvarchar(50)	,
	MatKhau varchar(20)
)
create table KhoHang
(
	MaLoai char(5) primary key,
	TenLoai nvarchar(50),
	SoLuongNhapVao integer,
	GiaNhap money check (GiaNhap >=0),
	TonKho integer	
)
create table SanPham
(
	MaSanPham char(5) primary key,
	TenSanPham nvarchar(30),
	GiaBan money check (GiaBan >=0),
	MaLoai char(5) foreign key references KhoHang(MaLoai)
	--MaHang char(7) foreign key references Hang(MaHang)
	ON DELETE CASCADE  ON UPDATE CASCADE
)

create table HoaDonDatHang
(
	MaHoaDon int identity(1,1) primary key,
	--TrangThaiDatHang nvarchar(20) ,
	TrangThaiGiaoHang nvarchar(20),
	NgayDatHang date,
	NgayGiaoHang date,
	SoLuong integer check (SoLuong >=0),
	GiaMua money check (GiaMua >= 0),
	MaKH char(5) foreign key references Users(MaKH),
	MaSanPham char(5) foreign key references SanPham(MaSanPham)
	ON DELETE CASCADE  ON UPDATE CASCADE
)

create table GioHang
(
	MaGioHang char(5) primary key,
	MaKH char(5) foreign key references Users(MaKH),
	MaSanPham char(5) foreign key references SanPham(MaSanPham)
	ON DELETE CASCADE  ON UPDATE CASCADE
)

--Vài ràng buộc
alter table Users
add constraint email_check check (
    Email like '[a-z]%@gmail.com'
    AND Email NOT LIKE '%@%@%'
)
alter table Users
add constraint SDT_check check (SDT like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]');
alter table HoaDonDatHang
add constraint trangthaiGiaoHang_check check (TrangThaiGiaoHang IN (N'Chờ xác nhận', N'Chờ lấy hàng', N'Đang giao', N'Đã giao', N'Đã hủy', N'Trả hàng', N'Đánh giá'));
alter table HoaDonDatHang
add constraint kiemtrangaygiaohang_check check (NgayGiaoHang >= NgayDatHang);

--drop database QLSHOPDOGIADUNG

