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
	GiaBan varchar(20) ,
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
	SoLuongDat integer ,
	GiaMua varchar(20) ,
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

----------------------------------------------Vài ràng buộc------------------------------------------------------
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

-------------------------------------------Insert-------------------------------------------------
insert into KhoHang(MaLoai, TenLoai) values ('TL',N'Tủ Lạnh'),
											('HB',N'Thiết bị hút bụi'),
											('LVS',N'Lò vi sóng'),
											('B',N'Bếp'),
											('NC',N'Nồi chảo')
insert into SanPham(MaSanPham,TenSanPham,GiaBan,SoLuong,MaLoai) values	('B0001',N'Bếp gas mini','200000',100,'B'), 
																		('NC001',N'Bộ nồi chảo','500000',100,'NC'),
																		('C0001',N'Chảo chống dính','70000',100,'NC'),
																		('N0001',N'Nồi cơm điện Apricots','100000',100,'NC'),
																		('VS001',N'Lò vi sóng','300000',100,'LVS'),
																		('TL001',N'Tủ lạnh','1000000',100,'TL'),
																		('HB001',N'Máy hút bụi','200000',100,'HB'),
																		('HB002',N'Robot hút bụi','500000',100,'HB')
insert into Users(Ho,Ten,SDT,Email,DiaChi,MatKhau) 
values	(N'Nguyễn',N'Văn A','0123456789','nva@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvana'),
		(N'Nguyễn',N'Văn B','0123456788','nvb@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvanb'),
		(N'Nguyễn',N'Văn C','0123456787','nvc@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvanc'),
		(N'Nguyễn',N'Văn D','0123456786','nvd@gmail.com',N'48 Cao Thắng, Hải Châu, Đà Nẵng','nguyenvand')

--------------------------------------------Drop----------------------------------------------
drop database QLSHOPDOGIADUNG

-----------------------------------------Select----------------------------------------------
select * from SanPham
select * from Users
select * from HoaDonDatHang

--------------------------------------------Trigger--------------------------------------------
create trigger tg_giamsoluong_in_tblSanPham
	on HoaDonDatHang 
	after insert
	as
	begin
	save transaction sp1
		UPDATE SanPham
		SET SoLuong = SanPham.SoLuong - inserted.SoLuongDat
	from SanPham inner join inserted on SanPham.MaSanPham = inserted.MaSanPham
	if
		exists(select SoLuongDat from  inserted inner join SanPham on inserted.MaSanPham=SanPham.MaSanPham where inserted.SoLuongDat>SanPham.SoLuong)
	begin
		print N'Số lượng đặt vượt quá mức'
		rollback transaction sp1
	end
	else commit
	end

create trigger tg_tangsoluong_in_tblSanPham2
	on HoaDonDatHang 
	after delete
	as
	begin
		save transaction sp2
		UPDATE SanPham
		SET SoLuong = SoLuong + deleted.SoLuongDat
		from SanPham inner join deleted on SanPham.MaSanPham = deleted.MaSanPham
		if exists(select SoLuongDat from  deleted inner join SanPham on deleted.MaSanPham=SanPham.MaSanPham where deleted.SoLuongDat>SanPham.SoLuong)
		begin
			print N'Số lượng đặt vượt quá mức'
			rollback transaction sp2
		end
		else commit
	end