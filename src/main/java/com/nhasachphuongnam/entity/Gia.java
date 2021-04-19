package com.nhasachphuongnam.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GIA database table.
 * 
 */
@Entity
@Table(name="GIA")
public class Gia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiaPK id;

	@Column(name="GIA")
	private BigDecimal gia;

	//bi-directional many-to-one association to Mathang
	@ManyToOne
	@JoinColumn(name="MAMH")
	private Mathang mathang;

	public Gia() {
	}

	public GiaPK getId() {
		return this.id;
	}

	public void setId(GiaPK id) {
		this.id = id;
	}

	public BigDecimal getGia() {
		return this.gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Mathang getMathang() {
		return this.mathang;
	}

	public void setMathang(Mathang mathang) {
		this.mathang = mathang;
	}

}