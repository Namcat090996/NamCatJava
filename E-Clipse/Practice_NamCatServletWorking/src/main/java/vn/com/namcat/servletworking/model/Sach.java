package vn.com.namcat.servletworking.model;

import java.sql.Date;

public class Sach {

	private int id;	
	private String tenSach;	
	private String anhSach;
	private String moTa;
	private int giaSach;
	private String tacGia;
	private int soLuong;
	private Date ngayTao;
	private String chuDe;
	
	/**
	 * Constructor without parameter
	 */
	public Sach()
	{
		
	}
	
	/**
	 * Constructor with 05 parameters
	 * @param id
	 * @param tenSach
	 * @param anhSach
	 * @param moTa
	 * @param tacGia
	 * @param giaSach
	 */
	public Sach(int id, String tenSach, String anhSach, String moTa, String tacGia, int giaSach)
	{
		this.id = id;
		this.tenSach = tenSach;
		this.anhSach = anhSach;
		this.moTa = moTa;
		this.tacGia = tacGia;
		this.giaSach = giaSach;
	}
	
	/**
	 * Constructor with 01 parameter
	 * @param tenSach
	 */
	public Sach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getAnhSach() {
		return anhSach;
	}
	public void setAnhSach(String anhSach) {
		this.anhSach = anhSach;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getGiaSach() {
		return giaSach;
	}
	public void setGiaSach(int giaSach) {
		this.giaSach = giaSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}		
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public String getChuDe() {
		return chuDe;
	}
	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}	
}
