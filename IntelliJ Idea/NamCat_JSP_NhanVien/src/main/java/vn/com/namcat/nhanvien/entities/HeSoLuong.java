package vn.com.namcat.nhanvien.entities;

public class HeSoLuong {

    //Declare variables
    private int id;
    private float heSo;
    private int phuCap;
    private String moTa;

    //Call the getter and setter functions
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHeSo() {
        return heSo;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }

    public int getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
