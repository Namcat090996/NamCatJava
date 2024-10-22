#Làm việc với các hàm số học
#Chuyển từ chuỗi về số
Select cast('025' as float)*2;

#Hàm làm tròn
Select round(3.56,1);
#Lấy số cận trên
Select Ceiling(3.56);

#Lấy số cận dưới
Select Floor(3.56);

#Lấy 1 số sau dấu phẩy
Select truncate(3.56,1);

#Hàm lấy số mũ
Select power(2,3);

#Hàm căn bậc hai
Select sqrt(9);

#Hàm chuỗi
#Chuyển về chữ thường
Select lower('Stanford - Day lap trinh');

#Chuyển về chữ hoa
Select upper('Stanford - Day lap trinh');

#Loại bỏ kí tự trắng bên trái
Select  ltrim('      Day lap trinh');

#Nối 2 chuỗi
Select concat('Stanford', ' Day lap trinh');

#Hàm thay thế
Select replace('Stanford - Day lap trinh','t','T');

#Hàm lấy chuỗi con
Select substring('Stanford - Day lap trinh', 1,9);

#Hàm lấy chuỗi con từ bên phải chuỗi, lấy từ cách bên phải 5 và lấy 5 kí tự
Select substring('Stanford - Day lap trinh', -5, 5);

#Hàm lấy chuỗi con dựa trên ký tự phân cách (lấy từ bên trái qua phải), hàm này sẽ tìm kí tự ' ' đầu tiên từ trái qua phải, và trả về phần đứng trước dấu ' '
Select substring_index('Hồng Hái Dòn', ' ', 1); #Kết quả trả về 'Hồng'

#Hàm lấy chuỗi con dựa trên ký tự phân cách (lấy từ bên phải qua bên trái), hàm này sẽ tìm kí tự ' ' đầu tiên từ phải qua trái, và trả về phần đứng sau dấu ' '
Select substring_index('Hồng Hái Dòn', ' ', -1); #Kết quả trả về 'Dòn'

#Hàm sắp xếp thứ tự theo chữ cái đầu tiên của chuỗi
Select * from sinhvien order by HoTen ASC;

#Hàm lấy độ lớn của chuỗi
Select length('Stanford');

#Lấy vị trí của kí tự trong chuỗi
Select instr('Stanford - Day lap trinh', 't');

#Chèn kí tự bên trái cho đủ số lượng
Select lpad('Stanford', 20, '*');

#Chèn kí tự bên phải cho đủ số lượng
Select rpad('Stanford', 20, '*');

#Lấy ngày tháng hiện thời
Select now();

Select sysdate();

Select curdate();

#Lấy ngày tháng năm
Select day(sysdate()) as Ngay, month(sysdate()) as Thang,
year(sysdate()) as Nam;

#Thêm 5 ngày vào ngày hiện thời
Select date_Add(sysdate(), interval 5 day);

#So sánh trả về số ngày
Select datediff('2024-10-10', now());

#Lấy ngày của ngày hiện thời
Select Extract(day from sysdate());

#Lấy tháng của ngày hiện thời
Select Extract(month from sysdate());

#Hàm chuyển từ chuỗi về ngày tháng
Select convert('2024-10-2', unsigned);

#Thống kê số lượng sinh viên theo từng khoa
Select MaKhoa, count(*) as SoLuong from SinhVien
group by MaKhoa;

#Thống kê các khoa có sinh viên từ 2 người trở lên
Select MaKhoa, count(*) as SoLuong from SinhVien
group by MaKhoa
having count(*) >= 2;

Select count(*) from nhanvien;

#Thống kê số lượng nhân viên theo từng phòng ban
Select MaPhong, count(*) as SoLuong from nhanvien
group by MaPhong;

#Thống kê các phòng có từ 5 nhân viên
Select MaPhong, count(*) as SoLuong from nhanvien
group by MaPhong
having count(*) >= 5;

#Lấy thông tin từ 2 bảng
Select MaNV, HoTen, nv.DienThoai, Email, nv.MaPhong, TenPhong
 from NhanVien nv inner join PhongBan pb on nv.MaPhong = pb.MaPhong
 order by MaNV asc;
 
 #Lấy thông tin từ 3 bảng
Select MaNV, HoTen, nv.DienThoai, Email, nv.MaPhong, TenPhong, TenChucVu 
 from NhanVien nv inner join PhongBan pb on nv.MaPhong = pb.MaPhong
 inner join ChucVu cv on nv.MaChucVu = cv.MaChucVu;
 
 #Left join: Lấy tất cả thông tin bảng bên trái
 insert into NhanVien(MaNV, HoTen, DienThoai, Email, DiaChi)
 values('SF053', 'Lê Thu Hà', '0988323568', 'thuha@gmail.com', 'Hà Nam');
 Select MaNV, HoTen, nv.DienThoai, Email, nv.MaPhong, TenPhong
 from NhanVien nv left join PhongBan pb on nv.MaPhong = pb.MaPhong;
 
 #Right join: Lấy tất cả thông tin bên phải
  Select MaNV, HoTen, nv.DienThoai, Email, nv.MaPhong, TenPhong
 from NhanVien nv right join PhongBan pb on nv.MaPhong = pb.MaPhong
 order by MaNV asc;
 
 #Lấy tất thông tin bảng trái, phải
  Select MaNV, HoTen, nv.DienThoai, Email, nv.MaPhong, TenPhong
 from NhanVien nv left join PhongBan pb on nv.MaPhong = pb.MaPhong
 union
 Select MaNV, HoTen, nv.DienThoai, Email, nv.MaPhong, TenPhong
 from NhanVien nv right join PhongBan pb on nv.MaPhong = pb.MaPhong;
 
 #Lấy trung bình lương của toàn nhân viên
 Select round(avg(hs.HeSo*3500000 + hs.PhuCap),2) as LuongTB 
 from NhanVien nv inner join HeSoLuong hs on nv.HeSoId = hs.Id;
 
 #Lấy tất cả nhân viên có lương lớn hơn lương trung bình
 Select MaNV, Hoten, DienThoai, Email, DiaChi, nv.MaPhong, 
 (hs.HeSo*3500000 + hs.PhuCap) as TongLuong 
  from NhanVien nv inner join HeSoLuong hs on nv.HeSoId = hs.Id
  where (hs.HeSo*3500000 + hs.PhuCap) > 
  (
  Select round(avg(hs.HeSo*3500000 + hs.PhuCap),2) as LuongTB 
 from NhanVien nv inner join HeSoLuong hs on nv.HeSoId = hs.Id
 );
 
 #Câu lệnh sắp xếp sinh viên theo mã sinh viên (lấy phần số để sắp xếp, như SF001, SF005, SF100)
 Select MaSV from sinhvien order by cast(substring(MaSV, 3) as unsigned);
 
 #Câu lệnh sắp xếp mã sách theo thứ tự chữ cái (cả trước và sau khi tìm kiếm), hàm ASC để sắp xếp theo thứ tự alphabet, lấy kí tự đầu tiên của MaSach để sắp xếp, nếu chuỗi đồng nhất về định dạng và kiểu, order by ... asc sẽ so sánh từng kí tự để cho ra kết quả so sánh
-- Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from Sach where 1=1;

-- if(!tuKhoa.isEmpty())
-- {
--  strSQL += " and (MaSach = '" + tuKhoa + "' OR TenSach like '%" + tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%')";
-- }

-- if(!maCD.isEmpty())
-- {
--  strSQL+= " and MaChuDe = '" + maCD + "'";
-- }

-- strSQL += " order by MaSach ASC";
 
 
 

