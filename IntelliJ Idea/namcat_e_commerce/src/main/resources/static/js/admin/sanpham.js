function xuLyThemMoi() {
    //Lấy thông tin trên giao diện
    var maSP = $("#hSanPhamId").val();

    var urlPost = '/api/sanpham/themmoi';
    var methodType = "POST";
    //TH sửa
    if (maSP != null && maSP.length > 0) {
        urlPost = '/api/sanpham/capnhat/' + maSP;
        methodType = "PUT";
    }

    let formData = new FormData();

    // Thêm thông tin vào FormData
    formData.append("maSanPham", $("#maSanPham").val());
    formData.append("tenSanPham", $("#tenSanPham").val());
    formData.append("giaSanPham", $("#giaSanPham").val());
    formData.append("tonKho", $("#tonKho").val());
    formData.append("loaiSanPham", $("#loaiSanPham").val());
    formData.append("mauSac", $("#mauSac").val());
    formData.append("moTa", $("#moTa").val());
    formData.append("noiDung", $("#noiDung").val());
    formData.append("ngayTao", $("#demoDate").val());

    // Thêm file nếu người dùng chọn
    const files = $("#fUpload")[0]?.files;
    if (files && files.length > 0) {
        // Lặp qua từng file và thêm vào formData
        for (let i = 0; i < files.length; i++) {
            formData.append("fUpload", files[i]);
        }
    }

    $.ajax({
        url: urlPost,
        type: methodType,
        data: formData,
        processData: false, // Không xử lý dữ liệu
        contentType: false, // Không đặt loại nội dung
        success: function (data) {
            if (data != null && data.maSanPham != null) {
                $("#modalSanPham").modal("hide")
                //Reload lại trang
                window.location.reload();
            }
        },
        error: function (error) {
            // Xóa lỗi cũ
            $("#er_maSanPham").text("");
            $("#er_giaSanPham").text("");
            $("#er_moTa").text("");
            $("#er_tonKho").text("");
            $("#er_image").text("");
            $("#er_sanPham").text("");

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
function thongTinChiTiet(maSP) {
    $.ajax({
        type: "GET",
        url: "/api/sanpham/" + maSP,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {
            //Hiển thị lên giao diện
            $("#maSanPham").prop("disabled", true);
            $("#modalTitle").text("Sửa thông tin sản phẩm");
            $("#hSanPhamId").val(data.maSanPham);
            $("#maSanPham").val(data.maSanPham);
            $("#tenSanPham").val(data.tenSanPham);
            $("#giaSanPham").val(data.giaSanPham);
            $("#tonKho").val(data.tonKho);
            $("#loaiSanPham").val(data.loaiSanPham);
            $("#moTa").val(data.moTa);
            $("#noiDung").val(data.noiDung);
            $("#demoDate").val(data.ngayTao);
            $("#mauSac").val(data.mauSac);
        }
    });
}

function thucHienXoa() {
    var maSP = $("#hSanPhamId").val();

    $.ajax({
        url: '/api/sanpham/xoa/' + maSP,
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

// function thucHienDuyet() {
//     var maSP = $("#hSanPhamId").val();
//
//     $.ajax({
//         url: '/api/sanpham/duyet/' + maSP,
//         contentType: "application/json; charset=utf-8;",
//         dataType: "json",
//         type: "PUT",
//         success: function (data) {
//             if (data.name != null) {
//                 $("#modalDuyet").modal("hide")
//                 //Reload lại trang
//                 window.location.reload();
//             } else {
//                 $(`#${data.name}`).text(data.message);
//             }
//         },
//         error: function (error) {
//             alert(error.responseJSON.message);
//         }
//     });
// }

// Hàm duyệt/bỏ duyệt sản phẩm
function duyetSanPham() {
    //Lấy tất cả id được chọn qua checkbox
    var sanPhamChon = [];
    $('input[name="chonSanPham"]:checked').each(function () {
        sanPhamChon.push($(this).val());//Lấy giá trị của input checkbox và thêm lần lượt các phần tử vào mảng
    });

    if(sanPhamChon.length === 0)//Nếu người dùng không chọn sản phẩm nào
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
function xacNhanDuyetSP(thaoTac) {
    //Lấy tất cả id được chọn qua checkbox
    var sanPhamChon1 = [];
    $('input[name="chonSanPham"]:checked').each(function () {
        sanPhamChon1.push($(this).val()); //Lấy giá trị của input checkbox và thêm lần lượt các phần tử vào mảng
    });

    //Xử lý duyệt/bỏ duyệt
    $.ajax({
        url: '/api/sanpham/duyet',
        type: "POST",
        data: {
            sanPhamChon: sanPhamChon1.join(';'),  //Gửi danh sách mã sản phẩm theo định dạng '1;2;3'
            thaoTac: thaoTac,  // Hành động duyệt hoặc bỏ duyệt
        },

        success: function (data) {
            //Xử lý thành công
            window.location.reload();
        },
        error: function (xhr, status, error) {
            console.log("Error details: ", xhr, status, error);
            alert("Có lỗi xảy ra khi duyệt sản phẩm");
        }
    });
}
