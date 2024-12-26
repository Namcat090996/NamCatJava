
function thongTinChiTiet_DH(maDH) {
    $.ajax({
        type: "GET",
        url: "/api/donhang/xemnhanh/" + maDH,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {
            // Kiểm tra dữ liệu trả về có mảng không
            if (data && Array.isArray(data) && data.length > 0) {
                // Tạo HTML cho table để hiển thị chi tiết đơn hàng
                var content = '';
                data.forEach(function(s) {
                    content += `<tr>
                        <td>${s.maSanPham}</td>
                        <td>${s.soLuong}</td>
                        <td>${s.giaSanPham}</td>
                        <td>${s.tenSanPham}</td>
                        <td>${s.tenSanPham}</td>
                    </tr>`;
                });

                // Thêm các row vào table trong modal
                $('#noiDungChen').html(content);  // 'noiDungChen' là ID của tbody trong modal
                $('#DH_ChiTiet').modal('show');  // Hiển thị modal
            }
            else {
                alert("Xảy ra lỗi khi hiển thị chi tiết đơn hàng! Vui lòng thử lại")
            }
        },
        error: function (xhr, status, error) {
            alert("Xảy ra lỗi khi lấy thông tin chi tiết đơn hàng! Vui lòng thử lại")
        }
    });
}


