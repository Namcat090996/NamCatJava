function xuLyThemMoi_ND() {
    //Lấy thông tin trên giao diện
    var maND = $("#hNguoiDungId").val();

    var urlPost = '/api/nguoidung/themmoi';
    var methodType = "POST";
    //TH sửa
    if (maND != null && maND.length > 0) {
        urlPost = '/api/nguoidung/capnhat/' + maND;
        methodType = "PUT";
    }

    let data = {
        tenNguoiDung: $("#tenNguoiDung").val(),
        matKhau: $("#matKhau").val(),
        email: $("#email").val(),
        hoTen: $("#hoTen").val(),
        dienThoai: $("#dienThoai").val(),
        vaiTro: $("#vaiTro").val(),
        diaChi: $("#diaChi").val()
    };

    $.ajax({
        url: urlPost,
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        data: JSON.stringify(data),
        type: methodType,
        success: function (response) {
            if (response != null && response.tenNguoiDung != null) {
                $("#modalNguoiDung").modal("hide")
                //Reload lại trang
                window.location.reload();
            }
        },
        error: function (error) {
            // Xóa lỗi cũ
            $("#er_tenNguoiDung").text("");
            $("#er_email").text("");
            $("#er_hoTen").text("");
            $("#er_dienThoai").text("");
            $("#er_nguoiDung").text("");

            const errors = error.responseJSON;
            errors.forEach(err => {
                const name = err.name;
                const message = err.message;

                $(`#${name}`).text(message);// Chèn lỗi vào đúng trường
            });
        }
    });
}

/*
        * Hàm hiển thị thông tin chi tiết chủ đề bằng jquery ajax
*/
function thongTinChiTiet_ND(maND) {
    $.ajax({
        type: "GET",
        url: "/api/nguoidung/" + maND,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {
            //Hiển thị lên giao diện
            $("#tenNguoiDung").prop("disabled", true);
            $("#modalTitle").text("Sửa thông tin người dùng");
            $("#hNguoiDungId").val(data.tenNguoiDung);
            $("#tenNguoiDung").val(data.tenNguoiDung);
            $("#matKhau").val(data.matKhau);
            $("#email").val(data.email);
            $("#hoTen").val(data.hoTen);
            $("#dienThoai").val(data.dienThoai);
            $("#diaChi").val(data.diaChi);
            $("#vaiTro").val(data.vaiTro);
        }
    });
}

function thucHienXoa_ND() {
    var maND = $("#hNguoiDungId").val();

    $.ajax({
        url: '/api/nguoidung/xoa/' + maND,
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

