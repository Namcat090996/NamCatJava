
function thongTinChiTiet_QV(maSP) {
    $.ajax({
        type: "GET",
        url: "/api/sanpham/xemnhanh/" + maSP,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {
            //Hiển thị lên giao diện
            $("#tenSanPham_QV").text(data.tenSanPham);
            $(".anhSanPham_QV1").attr("src", "/images/" + data.anhSanPham);
            $("#moTa_QV").text(data.moTa);
            $("#giaSanPham_QV").text(data.giaTienFormat);
            $("#noiDung_QV").text(data.noiDung);
        },
        error: function (xhr, status, error) {
            console.error("Lỗi khi lấy thông tin sản phẩm:", error);
        }
    });
}

