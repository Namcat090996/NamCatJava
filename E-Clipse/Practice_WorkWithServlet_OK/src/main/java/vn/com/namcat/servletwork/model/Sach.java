package vn.com.namcat.servletwork.model;

import java.util.Date;

public class Sach {
	
	/**
	 * Constructor without parameter
	 */
	public Sach() {
		
	}
	
	/**
	 * Constructor with 01 parameter
	 * @param tenSach
	 */
	public Sach(String tenSach)
	{
		this.tenSach = tenSach;
	}
	
	/**
	 * Constructor with 06 parameters
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
	
	private int id;
	private String tenSach;
	private String moTa;
	private String anhSach;
	private String tacGia;
	private int giaSach;
	private Date ngayTao;
	private String maChuDe;
	
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
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getAnhSach() {
		return anhSach;
	}
	public void setAnhSach(String anhSach) {
		this.anhSach = anhSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getGiaSach() {
		return giaSach;
	}
	public void setGiaSach(int giaSach) {
		this.giaSach = giaSach;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public String getMaChuDe() {
		return maChuDe;
	}
	public void setMaChuDe(String maChuDe) {
		this.maChuDe = maChuDe;
	}

}
