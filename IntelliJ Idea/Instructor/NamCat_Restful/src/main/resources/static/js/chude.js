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

    var maVB = $("#maVanBan").val();
    var tieuDe = $("#tieuDe").val();

    //Khai báo mảng
    var formData = {}
    formData["maVanBan"] = maVB;
    formData["tieuDe"] = tieuDe;

    $.ajax({
        url: urlPost,
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        data: JSON.stringify(formData),
        type: methodType,
        success: function (data) {
            if (data.maChuDe != null) {
                $("#modalChuDe").modal("hide")
                //Reload lại trang
                window.location.reload();
            } else {
                $('#tile-body').nextAll(".spanError").remove();
                $('#tile-body').after('<div class="alert alert-dismissible alert-danger spanError">' + data.name + '</div>')

            }
        },
        error: function (error) {
            alert("Có lỗi xảy ra " + error.name);
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
            console.log(data.ngayTao);
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
