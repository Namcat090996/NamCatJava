function xuLyThemMoi() {
    //Lấy thông tin trên giao diện
    var ma = $("#hVanBanId").val();

    var urlPost = '/api/vanban/themmoi';
    var methodType = "POST";
    //TH sửa
    if (ma.length > 0) {
        urlPost = '/api/vanban/capnhat/' + ma;
        methodType = "PUT";
    }

    let formData = new FormData();

    // Thêm thông tin vào FormData
    formData.append("maVanBan", $("#maVanBan").val());
    formData.append("tieuDe", $("#tieuDe").val());
    formData.append("ngayTao", $("#demoDate").val());
    formData.append("loaiVanBan", $("#loaiVanBan").val());
    formData.append("donVi", $("#donVi").val());

    // Thêm file nếu người dùng chọn
    const file = $("#fUpload")[0].files[0];
    if (file) {
        formData.append("fUpload", file);
    }

    console.log(formData);

    $.ajax({
        url: urlPost,
        type: methodType,
        data: formData,
        processData: false, // Không xử lý dữ liệu
        contentType: false, // Không đặt loại nội dung
        success: function (data) {
            console.log(data)
            if (data.maVanBan != null) {
                console.log()
                $("#modalVanBan").modal("hide")
                //Reload lại trang
                window.location.reload();
            } else {
                $('#tile-body').nextAll(".spanError").remove();
                $('#tile-body').after('<div class="alert alert-dismissible alert-danger spanError">' + data.name + '</div>')

            }
        },
        error: function (error) {
            alert("Có lỗi xảy ra rồi " + error.responseJSON[0].message);
        }
    });
}

/*
        * Hàm hiển thị thông tin chi tiết chủ đề bằng jquery ajax
*/
function thongTinChiTiet(maVB) {
    $.ajax({
        type: "GET",
        url: "/api/vanban/" + maVB,
        data: {
            id: maVB
        },
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {
            //Hiển thị lên giao diện
            $("#modalTitle").text("Sửa thông tin văn bản");
            $("#hVanBanId").val(data.maVanBan);
            $("#maVanBan").val(data.maVanBan);
            $("#tieuDe").val(data.tieuDe);
            $("#loaiVanBan").val(data.loaiVanBan);
            $("#donVi").val(data.donVi);
            $("#demoDate").val(data.ngayTao);
        }
    });
}

function thucHienXoa() {
    var maCD = $("#hVanBanId").val();

    $.ajax({
        url: '/api/vanban/xoa/' + maCD,
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        type: "DELETE",
        success: function (data) {
            if (data[0].name != null) {
                $("#modalXoa").modal("hide")
                //Reload lại trang
                window.location.reload();
            } else {
                $('#title-delete').nextAll(".spanError").remove();
                $('#title-delete').after('<div class="alert alert-dismissible alert-danger spanError">' + data[0].name + '</div>')

            }
        },
        error: function (error) {
            alert("Có lỗi xảy ra rồi " + error.responseJSON[0].message);
            console.log(error.responseJSON[0].message)
        }
    });
}
