-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 20, 2021 lúc 08:01 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `password`) VALUES
('admin', 'admin'),
('nhanvien', 'nhanvien');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `MaPhieuMuon` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaSach` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_nopad_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`MaPhieuMuon`, `MaSach`, `SoLuong`) VALUES
('PM1', 'MS-3', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuphat`
--

CREATE TABLE `chitietphieuphat` (
  `MaPhieuPhat` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoiPhat` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `MaPN` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaSach` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `MaDG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HoLot` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ten` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` tinyint(1) NOT NULL,
  `DienThoai` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgheNghiep` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TrinhDo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`MaDG`, `HoLot`, `Ten`, `NgaySinh`, `GioiTinh`, `DienThoai`, `DiaChi`, `NgheNghiep`, `TrinhDo`) VALUES
('a', 'a', 'a', '28-02-2000', 1, '00', 'a', '4', 'Cao học'),
('DG-1', 'Truong Huynh', 'Loc', '13-06-2001', 1, '0937', '15', 'sinh vien', 'Đại học'),
('DG-2', 'Dam Mai', 'Tram', '01-01-2001', 0, '0999', '14', 'sinh vien', 'Đại học'),
('DG-3', 'Truong Mai Nhat', 'Tan', '02-02-2001', 1, '0877', '15', 'sinh vien', 'Trung học'),
('DG-4', 'Pham Nguyen Thao', 'Vy', '03-03-2001', 0, '0999', '14', 'sinh vien', 'Tiểu học');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loiphat`
--

CREATE TABLE `loiphat` (
  `MaLoiPhat` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenLoiPhat` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TienPhat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loiphat`
--

INSERT INTO `loiphat` (`MaLoiPhat`, `TenLoiPhat`, `TienPhat`) VALUES
('a', 'a', 2),
('b', 'b', 2),
('LP1', 'Rách sách', 100);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenNCC` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`) VALUES
('A', 'AMAK'),
('I', 'TMP'),
('T', 'Trẻ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `HoLot` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Ten` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DienThoai` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HoLot`, `Ten`, `NgaySinh`, `DienThoai`) VALUES
('1', 'Phạm', 'Vy', '09/09/2001', '0364323594');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNXB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNXB` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`) VALUES
('NXB-1', 'Nhà xuất bản Tổng hợp'),
('NXB-2', 'Nhà xuất bản Trẻ'),
('NXB-3', 'Nhà xuất bản văn hoá - nghệ thuật');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuon`
--

CREATE TABLE `phieumuon` (
  `MaPhieuMuon` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaDocGia` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayMuon` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayHenTra` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_nopad_ci;

--
-- Đang đổ dữ liệu cho bảng `phieumuon`
--

INSERT INTO `phieumuon` (`MaPhieuMuon`, `MaDocGia`, `MaNhanVien`, `NgayMuon`, `NgayHenTra`, `TinhTrang`) VALUES
('PM1', 'DG1', 'NV1', '24/04/2021', '01/05/2021', 0),
('PM2', 'DG2', 'NV2', '01/04/2021', '12/04/2021', 0),
('PM3', 'DG4', 'NV2', '30/04/2021', '04/05/2021', 0),
('PM4', 'DG6', 'NV3', '25/03/2021', '01/04/2001', 0),
('PM5', 'DG20', 'NV2', '05/05/2021', '11/05/2021', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `MaPN` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaNCC` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhapHang` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuphat`
--

CREATE TABLE `phieuphat` (
  `MaPhieuPhat` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaPhieuMuon` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TongTienPhat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenSach` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaTG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNXB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NamXuatBan` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `MaTL`, `MaTG`, `MaNXB`, `NamXuatBan`, `SoLuong`, `DonGia`) VALUES
('1', '1', 'TL-3', 'TG-2', 'NXB-1', 1, 1, 1),
('2', '2', 'TL-1', 'TG-1', 'NXB-1', 2, 2, 2),
('3', '3', 'TL-1', 'TG-1', 'NXB-1', 3, 3, 3),
('MS-2', 'Số Đỏ', 'TL-2', 'TG-2', 'NXB-3', 1999, 4, 80000),
('MS-3', 'Hoàng Tử Bé', 'TL-1', 'TG-1', 'NXB-2', 1998, 5, 45000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenTG` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`MaTG`, `TenTG`) VALUES
('TG-1', 'Antoine'),
('TG-2', 'Vũ Trọng Phụng'),
('TG-3', 'Hồng Nương Tử');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `MaTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenTL` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`MaTL`, `TenTL`) VALUES
('TL-1', 'Thiếu nhi'),
('TL-2', 'Văn học nghệ thuật'),
('TL-3', 'Tiểu thuyết');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD KEY `MaPhieuMuon` (`MaPhieuMuon`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Chỉ mục cho bảng `chitietphieuphat`
--
ALTER TABLE `chitietphieuphat`
  ADD KEY `MaPhieuPhat` (`MaPhieuPhat`),
  ADD KEY `MaLoiPhat` (`MaLoiPhat`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `ctpn_ibfk_1` (`MaPN`),
  ADD KEY `ctpn_ibfk_2` (`MaSach`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`MaDG`);

--
-- Chỉ mục cho bảng `loiphat`
--
ALTER TABLE `loiphat`
  ADD PRIMARY KEY (`MaLoiPhat`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`MaNXB`);

--
-- Chỉ mục cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`MaPhieuMuon`);

--
-- Chỉ mục cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `nhanvien_ibfk_1` (`MaNV`),
  ADD KEY `nhanvien_ibfk_2` (`MaNCC`);

--
-- Chỉ mục cho bảng `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD PRIMARY KEY (`MaPhieuPhat`),
  ADD KEY `MaPhieuMuon` (`MaPhieuMuon`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `MaTL` (`MaTL`),
  ADD KEY `MaTG` (`MaTG`),
  ADD KEY `MaNXB` (`MaNXB`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTG`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MaTL`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `ctpm_ibfk_1` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`MaPhieuMuon`),
  ADD CONSTRAINT `ctpm_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Các ràng buộc cho bảng `chitietphieuphat`
--
ALTER TABLE `chitietphieuphat`
  ADD CONSTRAINT `ctpp_ibfk_1` FOREIGN KEY (`MaPhieuPhat`) REFERENCES `phieuphat` (`MaPhieuPhat`),
  ADD CONSTRAINT `ctpp_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  ADD CONSTRAINT `ctpp_ibfk_3` FOREIGN KEY (`MaLoiPhat`) REFERENCES `loiphat` (`MaLoiPhat`);

--
-- Các ràng buộc cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctpn_ibfk_1` FOREIGN KEY (`MaPN`) REFERENCES `phieunhaphang` (`MaPN`),
  ADD CONSTRAINT `ctpn_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Các ràng buộc cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`);

--
-- Các ràng buộc cho bảng `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD CONSTRAINT `phieuphat_ibfk_1` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`MaPhieuMuon`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaTG`) REFERENCES `tacgia` (`MaTG`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaTL`) REFERENCES `theloai` (`MaTL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
