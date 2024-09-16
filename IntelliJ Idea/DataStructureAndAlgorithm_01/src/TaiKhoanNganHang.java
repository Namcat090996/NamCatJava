public class TaiKhoanNganHang {
    public double soDu;

    public void napTien(double soTien) {
        if (soTien <= 0) {
            return;
        }
        soDu = soDu - soTien;
    }
}
