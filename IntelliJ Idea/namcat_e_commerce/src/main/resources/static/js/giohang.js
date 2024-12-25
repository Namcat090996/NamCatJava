function GH_them(maSanPham) {
    $.ajax({
        type: "POST",
        url: "/api/giohang/them/" + maSanPham,
        dataType: 'json',
        async: true,
        contentType: "application/json; charset=utf-8;",
        success: function (data) {
            if(data.name === "GH_add") { //Nếu thêm sản phẩm chưa tồn tại, thì tăng số lượng hiển thị trên trang
                //Hiển thị thông báo thêm vào giỏ thành công trong 1s
                $("#GH_TBThanhCong").modal("show");
                setTimeout(function () {
                    $("#GH_TBThanhCong").modal("hide");
                }, 700);

                //Cập nhật số lượng giỏ hàng được thêm trên trang chủ
                if($("#User_Online").val()) {
                    let GH_SoLuong = parseInt($("#GH_SoLuong").text()) || 0;//Nếu GH_SoLuong không phải số thì trả về 0
                    $("#GH_SoLuong").text(GH_SoLuong + 1);
                }
                else {
                    $("#GH_SoLuong").text(0);
                }

            }
            else if (data.name === "GH_update") {
                //Hiển thị thông báo thêm vào giỏ thành công trong 1s
                $("#GH_TBThanhCong").modal("show");
                setTimeout(function () {
                    $("#GH_TBThanhCong").modal("hide");
                }, 1000);

            }
        },
        error: function (error) {
            if(error.responseJSON && error.responseJSON.name === "GH_login") {
                // Hiển thị modal yêu cầu đăng nhập
                $("#GH_TBDangNhap").modal("show");
            } else if (error.responseJSON && error.responseJSON.name === "GH_out") {
                // Hiển thị modal thông báo hết hàng
                $("#GH_HetHang").modal("show");
            } else if(error.responseJSON && error.responseJSON.name === "GH_fail") {
                // Hiển thị thông báo lỗi cụ thể
                alert(error.responseJSON.message);
            } else {
                // Lỗi không xác định
                alert("Đã xảy ra lỗi không xác định! Vui lòng thử lại");
            }
        }
    });
}

