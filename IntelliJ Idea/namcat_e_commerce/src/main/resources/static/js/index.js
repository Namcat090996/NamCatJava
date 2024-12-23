
function thongTinChiTiet_QV(maSP) {
    $.ajax({
        type: "GET",
        url: "/api/sanpham/xemnhanh/" + maSP,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        async: true,
        success: function (data) {
            //Hiển thị lên giao diện
            $("#maSP").text(data.maSanPham);
            $(".tenSanPham_QV").text(data.tenSanPham);
            $(".moTa_QV").text(data.moTa);
            $(".giaSanPham_QV").text(data.giaTienFormat);
            $(".noiDung_QV").text(data.noiDung);

            if(data.lstASP.length > 0) {
                // Lấy tối đa 6 ảnh
                const danhSachAnh = data.lstASP.slice(0, 6);

                // Gán từng ảnh vào từng class
                danhSachAnh.forEach((anh, index) => {
                    const className = `.anhSanPham_QV${index + 1}`; // Tạo class tương ứng
                    const imgElement = $(className); // Tìm phần tử ảnh
                    if (imgElement.length) {
                        imgElement.attr("src", '/images/' + anh.anhSanPham); // Gán src
                    }
                });
            }
            else {
                $('#anh_large').empty();
                $('#anh_small').empty();
            }
        },
        error: function (xhr, status, error) {
            console.error("Lỗi khi lấy thông tin sản phẩm:", error);
        }
    });
}


