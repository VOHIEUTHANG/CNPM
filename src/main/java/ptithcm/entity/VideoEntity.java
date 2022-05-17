package ptithcm.entity;

import javax.persistence.*;

@Entity
@Table(name = "VIDEO")
public class VideoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaVideo")
	private Long mavideo;
	@Column(name = "LinkVideo")
	private String linkvideo;
	
	@ManyToOne
	@JoinColumn(name = "MaBaiViet",referencedColumnName = "MaBaiViet")
	private BaiVietEntity baiviet;

	public Long getMavideo() {
		return mavideo;
	}

	public void setMavideo(Long mavideo) {
		this.mavideo = mavideo;
	}

	public String getLinkvideo() {
		return linkvideo;
	}

	public void setLinkvideo(String linkvideo) {
		this.linkvideo = linkvideo;
	}

	public BaiVietEntity getBaiviet() {
		return baiviet;
	}

	public void setBaiviet(BaiVietEntity baiviet) {
		this.baiviet = baiviet;
	}
	
	
	
}
