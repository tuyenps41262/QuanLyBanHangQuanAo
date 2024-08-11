CREATE DATABASE QLBanHang_DUAN1;

USE QLBanHang_DUAN1;

CREATE TABLE NhanVien (
    IdNV Int Identity(1,1) primary key,
    TenNV NVARCHAR(50),
    DienThoai NVARCHAR(20),
    Email NVARCHAR(50),
    GioiTinh NVARCHAR(10),
    DiaChi NVARCHAR(50)
);

CREATE TABLE KhachHang (
    IdKH Int Identity(1,1) primary key,
    TenKH NVARCHAR(50),
    email NVARCHAR(50),
    DienThoai NVARCHAR(20),
	GioiTinh NVARCHAR(10),
	DiaChi NVARCHAR(50)
);

CREATE TABLE TaiKhoan (
    username NVARCHAR(50) PRIMARY KEY,
	matkhau NVARCHAR(50),
    vaitro NVARCHAR(50),
	trangthai bit,
    IDNV int  null,
    IDKH int null,
    FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV),
    FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH)
);

CREATE TABLE SanPham (
    IdSP Nvarchar(20) PRIMARY KEY,
    TenSP NVARCHAR(50),
    SoLuong INT,
    MoTa NVARCHAR(200),
    GiaBan FLOAT,
    LoaiSp NVARCHAR(30),
    Hinh NVarchar(30)
);

CREATE TABLE HoaDon(
    IdHD Int Identity(1,1) primary key,
    SoDienThoai NVARCHAR(20),
    TrangThaiThanhToan NVARCHAR(50),
    NgayLap DATE,
    DiaChi Nvarchar(200),
	TenNguoiNhan nvarchar(50),
	ThanhTien decimal(18,2),
    IdKH int,
    FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH)
);

CREATE TABLE HoaDonChiTiet (
    SoLuong INT,
    GiaBan FLOAT,
    IdHD INT,
    IdSP Nvarchar(20),
    FOREIGN KEY (IdHD) REFERENCES HoaDon(IdHD),
    FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP)
);

CREATE TABLE GioHang (
	SoLuong INT,   
    IdKH int,
    IdSP Nvarchar(20),
    FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH),
    FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP)
);

------------------CHÈN DỮ LIỆU VÀO BẢNG------------------------------
INSERT INTO NhanVien (TenNV, DienThoai, Email, GioiTinh, DiaChi) VALUES
  ( N'Nguyen Van Anh', '0123456789', 'nvana@example.com', N'Nam', N'123 Duong ABC'),
  ( N'Tran Thi Binh', '0987654321', 'ttb@example.com', N'Nữ', N'456 Duong XYZ'),
  ( N'Le Van Cao', '0159753456', 'lvc@example.com', N'Nam', N'789 Duong PQR'),
  ( N'Pham Thi Dinh', '0741852963', 'ptd@example.com', N'Nữ', N'159 Duong LMN'),
  ( N'Hoang Van En', '0369258147', 'hve@example.com', N'Nam', N'357 Duong GHI'),
  ( N'Nguyen Thi Ri', '0852147369', 'ntf@example.com', N'Nữ', N'951 Duong JKL'),
  ( N'Tran Van Gia', '0147852369', 'tvg@example.com', N'Nam', N'753 Duong MNO'),
  ( N'Pham Thi Hai', '0369741852', 'pth@example.com', N'Nữ', N'357 Duong PQR'),
  ( N'Le Van I', '0258147369', 'lvi@example.com', N'Nam', N'159 Duong STU'),
  ( N'Hoang Thi Khoa', '0147852963', 'htk@example.com', N'Nữ', N'951 Duong VWX');

INSERT INTO KhachHang (TenKH, email, DienThoai, GioiTinh, DiaChi) VALUES
(N'Nguyễn Văn An', 'nguyenvana@example.com', '0123456789', N'Nam', N'123 Đường ABC, Quận XYZ, Thành phố HCM'),
(N'Ngô Thị Bích', 'ngothib@example.com', '0987654321', N'Nữ', N'456 Đường DEF, Quận UVW, Thành phố Hà Nội'),
(N'Trần Đức Cường', 'tranducc@example.com', '0456789123', N'Nam', N'789 Đường GHI, Quận RST, Thành phố Đà Nẵng'),
(N'Lê Hồng Dung', 'lehongd@example.com', '0789456123', 'Nữ', N'321 Đường JKL, Quận MNO, Thành phố Cần Thơ'),
(N'Phạm Thị Én', 'phamthie@example.com', '0159753456', 'Nữ', N'654 Đường PQR, Quận STU, Thành phố Vũng Tàu'),
(N'Hoàng Văn Hoàng', 'hoangvanf@example.com', '0753951456', 'Nam', N'987 Đường UVW, Quận XYZ, Thành phố HCM'),
(N'Đặng Thị Giang', 'dangthig@example.com', '0456123789', 'Nữ', N'741 Đường MNO, Quận RST, Thành phố Hà Nội'),
(N'Vũ Đức Hùng', 'vuduch@example.com', '0789456321', 'Nam', N'852 Đường STU, Quận PQR, Thành phố Đà Nẵng'),
(N'Nguyễn Thị Ỉn', 'nguyenthi@example.com', '0159753258', 'Nữ', N'369 Đường KLM, Quận NOP, Thành phố Cần Thơ'),
(N'Lê Văn Khương', 'levankan@example.com', '0753951357', 'Nam', N'159 Đường EFG, Quận HIJ, Thành phố Vũng Tàu');

INSERT INTO TaiKhoan (username, matkhau, vaitro, trangthai, IDNV, IDKH)VALUES
	('user1', '123', 'admin', 1,  1, NULL),
	('user2', '123', 'admin', 1,  2, NULL),
	('user3', '123', 'admin', 0,  3, NULL),
	('user4', '123', 'admin', 1,  4, NULL),
	('user5', '123', 'admin', 1,  5, NULL),
	('user6', '123', 'admin', 0,  6, NULL),
	('user7', '123', 'admin', 1,  7, NULL),
	('user8', '123', 'admin', 1,  8, NULL),
	('user9', '123', 'admin', 0,  9, NULL),
	('user10', '123', 'admin', 1,  10, NULL),
	--User khách hàng
	('user11', '123', 'customer', 1,  NULL, 1),
	('user12', '123', 'customer', 1,  NULL, 2),
	('user13', '123', 'customer', 0,  NULL, 3),
	('user14', '123', 'customer', 1,  NULL, 4),
	('user15', '123', 'customer', 1,  NULL, 5),
	('user16', '123', 'customer', 0,  NULL, 6),
	('user17', '123', 'customer', 1,  NULL, 7),
	('user18', '123', 'customer', 1,  NULL, 8),
	('user19', '123', 'customer', 0,  NULL, 9),
	('user20', '123', 'customer', 1,  NULL, 10);

INSERT INTO SanPham (IdSP, TenSP, SoLuong, MoTa, GiaBan, LoaiSp, Hinh)VALUES
    ('SP001', N'Áo Sơ Mi Nam', 50, N'Áo sơ mi nam cổ truyền, chất liệu cotton mềm mại', 299000.0, N'Quần Áo', 'ao1.avif'),
    ('SP002', N'Váy Xòe Nữ', 30, N'Váy xòe nữ kiểu dáng sang trọng, chất liệu voan nhẹ nhàng', 499000.0, N'Quần Áo', 'ao2.avif'),
    ('SP003', N'Quần Jeans Nam', 80, N'Quần jeans nam thời trang, chất liệu bền chắc', 399000.0, N'Quần Áo', 'ao3.avif'),
    ('SP004', N'Áo Thun Nữ', 70, N'Áo thun nữ họa tiết đẹp, chất liệu cotton thoáng mát', 199000.0, N'Quần Áo', 'ao4.avif'),
    ('SP005', N'Đầm Dự Tiệc Nữ', 20, N'Đầm dự tiệc nữ sang trọng, chất liệu lụa mềm mại', 799000.0, N'Quần Áo', 'ao5.avif'),
    ('SP006', N'Áo Khoác Nam', 40, N'Áo khoác nam thời trang, chất liệu polyester ấm áp', 599000.0, N'Quần Áo', 'ao6.avif'),
    ('SP007', N'Quần Tây Nữ', 60, N'Quần tây nữ thiết kế tinh tế, chất liệu cotton mịn', 499000.0, N'Quần Áo', 'ao7.avif'),
    ('SP008', N'Áo Sơ Mi Nữ', 90, N'Áo sơ mi nữ kiểu dáng trẻ trung, chất liệu vải thoáng', 249000.0, N'Quần Áo', 'ao8.avif'),
    ('SP009', N'Váy Maxi Nữ', 25, N'Váy maxi nữ dáng suông, chất liệu vải mềm mại', 599000.0, N'Quần Áo', 'ao9.avif'),
    ('SP010', N'Quần Kaki Nam', 65, N'Quần kaki nam thiết kế năng động, chất liệu bền đẹp', 349000.0, N'Quần Áo', 'ao10.avif');

INSERT INTO HoaDon ( SoDienThoai, TrangThaiThanhToan, NgayLap, DiaChi, IdKH)VALUES
    (N'0987654321', N'Đã thanh toán', '2023-06-15', N'123 Nguyễn Văn Cừ, Quận 5, TP.HCM', 1),
    (N'0123456789', N'Chưa thanh toán', '2023-06-20', N'456 Lê Lợi, Quận 1, TP.HCM', 2 ),
    (N'0987123456', N'Đã thanh toán', '2023-06-22', N'789 Trần Hưng Đạo, Quận 3, TP.HCM', 3),
    (N'0456789012', N'Chưa thanh toán', '2023-06-25', N'321 Võ Văn Ngân, Quận Thủ Đức, TP.HCM', 4),
    (N'0789123456', N'Đã thanh toán', '2023-07-01', N'159 Nguyễn Huệ, Quận 1, TP.HCM', 5),
    (N'0159753486', N'Chưa thanh toán', '2023-07-05', N'753 Lê Văn Sỹ, Quận Phú Nhuận, TP.HCM', 6),
    (N'0369258147', N'Đã thanh toán', '2023-07-10', N'951 Trường Chinh, Quận Tân Bình, TP.HCM', 6),
    (N'0258147369', N'Chưa thanh toán', '2023-07-12', N'753 Bùi Viện, Quận 1, TP.HCM', 7),
    (N'0147852369', N'Đã thanh toán', '2023-07-15', N'159 Trần Quốc Toản, Quận 3, TP.HCM', 8),
    (N'0369147852', N'Chưa thanh toán', '2023-07-16', N'951 Nguyễn Trãi, Quận 5, TP.HCM', 9);


INSERT INTO HoaDonChiTiet (SoLuong, GiaBan, IdHD, IdSP)VALUES
    (2, 100000.00, 'HD001', 'SP001'),
    (1, 50000.00, 'HD002', 'SP002'),
    (3, 75000.00, 'HD003', 'SP003'),
    (4, 120000.00, 'HD004', 'SP004'),
    (1, 80000.00, 'HD005', 'SP005'),
    (2, 90000.00, 'HD006', 'SP006'),
    (3, 60000.00, 'HD007', 'SP007'),
    (1, 150000.00, 'HD008', 'SP008'),
    (2, 70000.00, 'HD009', 'SP009'),
    (4, 85000.00, 'HD010', 'SP010');

INSERT INTO GioHang (SoLuong, IdSP, IdKH) VALUES
  (2, 'SP001', 1),
  (1, 'SP002', 2),
  (3, 'SP003', 4),
  (1,'SP004', 5),
  (2, 'SP005', 6),
  (1, 'SP006', 3),
  (2, 'SP007', 7),
  (1, 'SP008', 8),
  (3, 'SP009',9),
  (1,'SP010', 5);


  SELECT gh.IdSP, sp.TenSP, sp.GiaBan, gh.SoLuong FROM GioHang gh LEFT JOIN SanPham sp ON gh.IdSP = sp.IdSP WHERE IdKH = ?

  
SELECT* FROM TAIKHOAN
select * from NhanVien
select * from khachHang
select * from HoaDon
select * from HoaDonChiTiet
select * from SanPham
insert into sanpham values ('SP012','đsds','10','IIIII','90','kkk','null')
UPDATE SanPham SET TenSP ='qần tây' ,SoLuong = 2, MoTa = 'mỏng',GiaBan=60,LoaiSp='qần áo', Hinh= 'null' WHERE IdSP ='sp012'
-------------------------------------------------BẢNG NHÂN VIÊN-------------------------------------------
-------------------------------THÊM TÀI KHOẢN-----------
go
select * from nhanvien
GO
CREATE or alter PROCEDURE sp_CreateNhanVienAndUser
    @TenNV NVARCHAR(50),
    @DienThoai NVARCHAR(20),
    @Email NVARCHAR(50),
    @GioiTinh NVARCHAR(10),
    @DiaChi NVARCHAR(50),
	@username NVARCHAR(50),
	@matkhau NVARCHAR(50),
    @vaitro NVARCHAR(50),
	@trangthai bit
as 
BEGIN TRY
    -- insert into NhanVien Table 
    INSERT INTO NhanVien(TenNV, DienThoai, Email, GioiTinh, DiaChi)
    VALUES (@TenNV, @DienThoai, @Email, @GioiTinh, @DiaChi);

    -- get the employee ID
    DECLARE @IdNV INT;
    SET @IdNV = SCOPE_IDENTITY();

    -- insert into TaiKhoan table
    INSERT INTO TaiKhoan(username, matkhau, vaitro, trangthai, IdNV)
    VALUES(@username, @matkhau, @vaitro, @trangthai, @IdNV)

    -- commit the transaction
    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    THROW;
END CATCH;

------------------------------------------BẢNG KHÁCH HÀNG------------------------------------------------
GO
CREATE or alter PROCEDURE sp_createKhachHangAndUser
    @TenKH NVARCHAR(50),
    @email NVARCHAR(50),
    @DienThoai NVARCHAR(20),
	@GioiTinh NVARCHAR(10),
	@username NVARCHAR(50),
	@matkhau NVARCHAR(50),
    @vaitro NVARCHAR(50),
	@trangthai bit
as 
BEGIN TRY
    -- insert into NhanVien Table 
    INSERT INTO KhachHang(TenKH, Email, DienThoai, GioiTinh)
    VALUES (@TenKH, @Email, @DienThoai, @GioiTinh);

    -- get the employee ID
    DECLARE @IdKH INT;
    SET @IdKh = SCOPE_IDENTITY();

    -- insert into TaiKhoan table
    INSERT INTO TaiKhoan(username, matkhau, vaitro, trangthai, IdKH)
    VALUES(@username, @matkhau, @vaitro, @trangthai, @IdKH)

    -- commit the transaction
    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    THROW;
END CATCH;




go
CREATE or ALTER PROC sp_CreateKHandUser
--IdNV Int Identity(1,1) primary key,
@TenKH NVARCHAR(50),
@email NVARCHAR(50),
@DienThoai NVARCHAR(20),
@GioiTinh NVARCHAR(10),
@DiaChi NVARCHAR(50),
@username NVARCHAR(50),
@matkhau NVARCHAR(50),
@vaitro NVARCHAR(50),
@trangthai bit
AS
BEGIN TRY
-- insert into KhachHang Table
INSERT INTO KhachHang(TenKH, Email, DienThoai, GioiTinh, DiaChi)
VALUES				 (@TenKH, @Email, @DienThoai, @GioiTinh, @DiaChi);

-- get the customer ID
DECLARE @IdKH INT;
SET @IdKH = SCOPE_IDENTITY();

-- insert into TaiKhoan table
INSERT INTO TaiKhoan(username, matkhau, vaitro, trangthai, IDKH)
VALUES(@username, @matkhau, @vaitro, @trangthai, @IdKH)

-- commit the transaction
COMMIT TRANSACTION;
END TRY
BEGIN CATCH
ROLLBACK TRANSACTION;
THROW;
END CATCH;























-----------------------------THÊM SẢN PHẨM -----------------------------
GO
CREATE or alter PROCEDURE ThemSanPham
    @IdSP NVARCHAR(20),
    @TenSP NVARCHAR(50),
    @SoLuong INT,
    @MoTa NVARCHAR(200),
    @GiaBan FLOAT,
    @LoaiSp NVARCHAR(30),
    @Hinh NVARCHAR(30)
AS
BEGIN
    INSERT INTO SanPham (IdSP, TenSP, SoLuong, MoTa, GiaBan, LoaiSp, Hinh)
    VALUES (@IdSP, @TenSP, @SoLuong, @MoTa, @GiaBan, @LoaiSp, @Hinh);
END

-- Sửa thông tin sản phẩm
go
CREATE or alter PROC CapNhatSanPham_New
    @IdSP NVARCHAR(20),
    @TenSP NVARCHAR(50),
    @SoLuong INT,
    @MoTa NVARCHAR(200),
    @GiaBan FLOAT,
    @LoaiSp NVARCHAR(30),
	@hinh nvarchar(50)
AS
BEGIN
    SET NOCOUNT ON; -- Tắt số hàng ảnh hưởng
    UPDATE SanPham
    SET TenSP = @TenSP,
        SoLuong = @SoLuong,
        MoTa = @MoTa,
        GiaBan = @GiaBan,
        LoaiSp = @LoaiSp,
		Hinh = @hinh
    WHERE IdSP = @IdSP
END


EXEC CapNhatSanPham_New'SP012', 'Áo', 30, 'Mô tả', 50.5, 'Loại', 'a1.jpg';


--------------------------- THỐNG KÊ------------------
GO
CREATE or alter PROCEDURE sp_ThongKeSanPham
    @Nam INT
AS
BEGIN
    SELECT 
        sp.IdSP AS 'Mã Sản Phẩm',
        sp.TenSP AS 'Tên Sản Phẩm',
        SUM(hdct.SoLuong * hdct.GiaBan) AS 'Doanh Thu',
        SUM(hdct.SoLuong) AS 'Số Lượng Đã Bán',
        COUNT(DISTINCT hd.IdKH) AS 'Số Lượng Khách Hàng Đã Mua'
    FROM 
        SanPham sp
    JOIN 
        HoaDonChiTiet hdct ON sp.IdSP = hdct.IdSP
    JOIN 
        HoaDon hd ON hdct.IdHD = hd.IdHD
    WHERE 
        YEAR(hd.NgayLap) = @Nam
    GROUP BY 
        sp.IdSP, sp.TenSP
    ORDER BY 
        'Doanh Thu' DESC
END







go

CREATE or alter PROCEDURE sp_HoaDon
    @IdHoaDon NVARCHAR(20),
	@DienThoai NVARCHAR(20),
	@trangthai bit,
	@NgayLap NVARCHAR(50),
	@DiaChi NVARCHAR(50),
	@TenNguoiNhan NVARCHAR(50),
	@ThanhTien NVARCHAR(50),
	@IdKhachHang int,

	@IdSP nvarchar(20),
	@TenSP nvarchar(20),
	@SoLuong int,
	@MoTa nvarchar(20),
	@GiaBan float,
	@LoaiSp nvarchar(20),
	@hinh nvarchar(20)
as 
BEGIN TRY
    -- insert into HoaDon Table 
    INSERT INTO HoaDon(IdHD, DienThoai, TrangThaiThanhToan, NgayLap, DiaChi, TenNguoiNhan, ThanhTien,IdKH)
    VALUES (@IdHoaDon, @DienThoai,@trangthai, @NgayLap, @DiaChi, @TenNguoiNhan, @ThanhTien, @IdKhachHang);


    -- insert into HoaDonChiTiet table
    INSERT INTO HoaDonChiTiet(SoLuong, GiaBan, IdHD, IdSP)
    VALUES(@SoLuong, @GiaBan, @IdHoaDon, @IdSP)

	-- insert into HoaDonChiTiet table
	INSERT INTO SanPham(IdSP, TenSP, SoLuong, MoTa, GiaBan, LoaiSp, Hinh)
    VALUES(@IdSP, @TenSP, @SoLuong, @MoTa, @GiaBan, @LoaiSp, @hinh)
    -- commit the transaction
    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    THROW;
END CATCH;



EXEC sp_HoaDon 
    @IdHoaDon = 'HD001',
    @DienThoai = '0987654321',
    @trangthai = 1,
    @NgayLap = '2023-05-15',
    @DiaChi = '123 Đường ABC, Quận XYZ, TP.HCM',
    @TenNguoiNhan = 'Nguyễn Văn A',
    @ThanhTien = '500000',
    @IdKhachHang = 1,

    @IdSP = 'SP001',
    @TenSP = 'Sản phẩm A',
    @SoLuong = 2,
    @MoTa = 'Mô tả sản phẩm A',
    @GiaBan = 250000,
    @LoaiSp = 'Loại A',
    @hinh = 'anh1.jpg'


	go
CREATE PROC sp_createHoaDonAndSanpham
	@IdSP NVARCHAR(20),
    @TenSP NVARCHAR(50),
    @SoLuong INT,
    @MoTa NVARCHAR(200),
    @GiaBan FLOAT,
    @LoaiSp NVARCHAR(30),
    @Hinh NVarchar(30)
as 
BEGIN TRY
    -- insert into SanPham Table 
    INSERT INTO SanPham(IdSP, TenSP, SoLuong, MoTa, GiaBan, LoaiSP, Hinh)
    VALUES (@IdSP, @TenSP, @SoLuong, @MoTa, @GiaBan, @LoaiSP, @Hinh);


    -- insert into HoaDon table
    -- DECLARE @IdHD NVARCHAR(20);
   -- INSERT INTO HoaDon(IdHD, DienThoai, TrangThaiThanhToan, NgayLap, DiaChi, IdKH)
   -- VALUES (@IdHD, @DienThoai, @TrangThaiThanhToan, @NgayLap, @DiaChi, @IdKH);
   -- SET @IdHD = SCOPE_IDENTITY();

	--insert HoaDonChiTiet table 
	 DECLARE @IdHD NVARCHAR(20);
 INSERT INTO HoaDonChiTiet(SoLuong, GiaBan, IdHD, IdSP)
 VALUES(@SoLuong, @GiaBan, @IdHD, @IdSP)

-- commit the transaction
COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    THROW;
END CATCH;


EXEC sp_createHoaDonAndSanpham @IdSP = 'SP0012', @TenSP = N'Quần tây đen',  @SoLuong = 2,  @MoTa = N'Quần đúng với thiết kế, đẹp',  @GiaBan = 350000, @LoaiSP = N'Quần tây',  @Hinh = 'null';