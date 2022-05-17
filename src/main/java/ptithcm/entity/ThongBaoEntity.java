package ptithcm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "THONGBAO")

public class ThongBaoEntity {
	@Id
	@GeneratedValue
	@Column(name = "MaTB")
	private Long matb;
	@Column(name = "ThoiGian")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date thoigian;
	@Column(name = "NoiDung")
	private String noidung;
	
	@ManyToOne
	@JoinColumn(name = "MaND")
	private NguoiDungEntity nguoidung;

	public Long getMatb() {
		return matb;
	}

	public void setMatb(Long matb) {
		this.matb = matb;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public NguoiDungEntity getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDungEntity nguoidung) {
		this.nguoidung = nguoidung;
	}
	
}
