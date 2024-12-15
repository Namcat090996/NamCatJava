function xuLyThemMoi() {
    //Lấy thông tin trên giao diện
    var ma = $("#hSanPhamId").val();

    var urlPost = '/api/sanpham/themmoi';
    var methodType = "POST";
    //TH sửa
    if (ma.length > 0) {
        urlPost = '/api/sanpham/capnhat/' + ma;
        methodType = "PUT";
    }

    let formData = new FormData();

    // Thêm thông tin vào FormData
    formData.append("maSanPham", $("#maSanPham").val());
    formData.append("tenSanPham", $("#tenSanPham").val());

    // Thêm file nếu người dùng chọn
    const file = $("#fUpload")[0]?.files[0];
    if (file) {
        formData.append("fUpload", file);
    }

    $.ajax({
        url: urlPost,
        type: methodType,
        data: formData,
        processData: false, // Không xử lý dữ liệu
        contentType: false, // Không đặt loại nội dung
        success: function (data) {
            if (data.maVanBan != null) {
                $("#modalSanPham").modal("hide")
                //Reload lại trang
                window.location.reload();
            }
        },
        error: function (error) {
            // Xóa lỗi cũ
            $("#er_maSanPham").text("");
            $("#er_tenSanPham").text("");

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
function thongTinChiTiet(maVB) {
    $.ajax({
        type: "GET",
        url: "/api/sanpham/" + maVB,
        data: {
            id: maVB
        },
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {

            //Hiển thị lên giao diện
            $("#maSanPham").prop("disabled", true);
            $("#modalTitle").text("Sửa thông tin văn bản");
            $("#hSanPhamId").val(data.maSanPham);
            $("#maSanPham").val(data.maSanPham);
            $("#tenSanPham").val(data.tenSanPham);
        }
    });
}

function thucHienXoa() {
    var maCD = $("#hSanPhamId").val();

    $.ajax({
        url: '/api/sanpham/xoa/' + maCD,
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        type: "DELETE",
        success: function (data) {
            if (data[0].name != null) {
                $("#modalXoa").modal("hide")
                //Reload lại trang
                window.location.reload();
            } else {
                $("#title-delete").nextAll(".spanError").remove();
                $("#title-delete").after('<div class="alert alert-dismissible alert-danger spanError">' + data[0].message + '</div>')

            }
        },
        error: function (error) {
            alert("Không thể xóa văn bản: " + error.responseJSON[0].message);
        }
    });
}
