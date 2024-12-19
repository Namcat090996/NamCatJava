function themHangVaoGio(maSanPham) {
    $.ajax({
        type: "POST",
        url: "/api/giohang/them/" + maSanPham,
        dataType: 'json',
        async: true,
        contentType: "application/json; charset=utf-8;",
        success: function (data) {
            if(data.name === "GH_success") {
                // Hiển thị thông báo trong vài giây
                $("#GH_TBThanhCong").modal("show").fadeIn().delay(2000).fadeOut();

                //Cập nhật số lượng giỏ hàng được thêm trên trang chủ
                let currentCount = parseInt($("#soLuongGioHang").text()) || 0;
                $("#soLuongGioHang").text(currentCount + 1);
            }
        },
        error: function (error) {
            if(error.responseJSON && error.responseJSON.name === "GH_login") {
                // Hiển thị modal yêu cầu đăng nhập
                $("#GH_TBDangNhap").modal("show");
            } else if(error.responseJSON.name && error.responseJSON.name === "GH_fail") {
                // Hiển thị thông báo lỗi cụ thể
                alert(error.responseJSON.message);
            } else {
                // Lỗi không xác định
                alert("Đã xảy ra lỗi không xác định! Vui lòng thử lại");
            }
        }
    });
}