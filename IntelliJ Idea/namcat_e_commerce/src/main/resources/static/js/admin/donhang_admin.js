function thucHienXoa() {
    var maSP = $("#hSanPhamId").val();

    $.ajax({
        url: '/api/donhang/xoa/' + maSP,
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        type: "DELETE",
        success: function (data) {
            if (data.name != null) {
                $("#modalXoa").modal("hide")
                //Reload lại trang
                window.location.reload();
            } else {
                $(`#${data.name}`).text(data.message);
            }
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}

// Hàm duyệt/bỏ duyệt đơn hàng
function duyetDonHang() {
    //Lấy tất cả id được chọn qua checkbox
    var donHangChon = [];
    $('input[name="chonDonHang"]:checked').each(function () {
        donHangChon.push($(this).val());//Lấy giá trị của input checkbox và thêm lần lượt các phần tử vào mảng
    });

    if(donHangChon.length === 0)//Nếu người dùng không chọn đơn hàng nào
    {
        $("#CB_ThongBao").modal("show");
        setTimeout(function () {
            $("#CB_ThongBao").modal("hide");
        }, 1000);
        return;
    }

    var luuDuyet = $("#luuDuyet").val();

    if(luuDuyet === "1")
    {
        $("#modalDuyet").modal("show");
    }

    if(luuDuyet === "0")
    {
        $("#modalBoDuyet").modal("show");
    }
}

// Hàm xác nhận duyệt/bỏ duyệt sản phẩm
function xacNhanDuyetDH(thaoTac) {
    //Lấy tất cả id được chọn qua checkbox
    var donHangChon1 = [];
    $('input[name="chonDonHang"]:checked').each(function () {
        donHangChon1.push($(this).val()); //Lấy giá trị của input checkbox và thêm lần lượt các phần tử vào mảng
    });

    //Xử lý duyệt/bỏ duyệt
    $.ajax({
        url: '/api/donhang/duyet',
        type: "POST",
        data: {
            donHangChon: donHangChon1.join(';'),  //Gửi danh sách mã đơn hàng theo định dạng '1;2;3'
            thaoTac: thaoTac,  // Hành động duyệt hoặc bỏ duyệt
        },

        success: function (data) {
            //Xử lý thành công
            window.location.reload();
        },
        error: function (xhr, status, error) {
            console.log("Error details: ", xhr, status, error);
            alert("Có lỗi xảy ra khi duyệt đơn hàng");
        }
    });
}
