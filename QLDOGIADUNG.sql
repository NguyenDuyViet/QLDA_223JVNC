create database QLSHOPDOGIADUNG
go
use QLSHOPDOGIADUNG
go
create table Users
(
	MaKH int identity(1,1) primary key,
	Ho nvarchar(10),
	Ten nvarchar(30),
	SDT char(10) unique,
	Email varchar(50) unique,
	DiaChi nvarchar(50)	,
	MatKhau varchar(20)
)
create table KhoHang
(
	MaLoai varchar(5) primary key,
	TenLoai nvarchar(50)
)

create table SanPham
(
	MaSanPham char(5) primary key,
	TenSanPham nvarchar(30),
	GiaBan bigint ,
	SoLuong integer,
	MaLoai varchar(5) foreign key references KhoHang(MaLoai)
	ON DELETE CASCADE  ON UPDATE CASCADE
)

create table HoaDonDatHang
(
	MaHoaDon int identity(1,1) primary key,
	--TrangThaiDatHang nvarchar(20) ,
	TrangThaiGiaoHang nvarchar(20),
	NgayDatHang date,
	NgayGiaoHang date,
	SoLuong integer ,
	GiaMua bigint ,
	MaKH int foreign key references Users(MaKH),
	MaSanPham char(5) foreign key references SanPham(MaSanPham)
	ON DELETE CASCADE  ON UPDATE CASCADE
)

create table GioHang
(
	MaGioHang char(5) primary key,
	MaKH int foreign key references Users(MaKH),
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

drop database QLSHOPDOGIADUNG

insert into KhoHang(MaLoai, TenLoai) values ('TL',N'Tủ Lạnh'),
											('HB',N'Thiết bị hút bụi'),
											('LVS',N'Lò vi sóng'),
											('B',N'Bếp'),
											('NC',N'Nồi chảo')
insert into SanPham(MaSanPham,TenSanPham,GiaBan,SoLuong,MaLoai) values	('B0001',N'Bếp gas mini',200000,20,'B'), 
																		('NC001',N'Bộ nồi chảo',500000,10,'NC'),
																		('C0001',N'Chảo chống dính',70000,40,'NC'),
																		('N0001',N'Nồi cơm điện Apricots',100000,60,'NC'),
																		('VS001',N'Lò vi sóng',300000,20,'LVS'),
																		('TL001',N'Tủ lạnh',1000000,30,'TL'),
																		('HB001',N'Máy hút bụi',200000,70,'HB'),
																		('HB002',N'Robot hút bụi',500000,70,'HB')
insert into Users(Ho,Ten,SDT,Email,DiaChi,MatKhau) 
values	(N'Nguyễn',N'Văn A','0123456789','nva@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvana'),
		(N'Nguyễn',N'Văn B','0123456788','nvb@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvanb'),
		(N'Nguyễn',N'Văn C','0123456787','nvc@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvanc'),
		(N'Nguyễn',N'Văn D','0123456786','nvd@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvand')

drop database QLSHOPDOGIADUNG