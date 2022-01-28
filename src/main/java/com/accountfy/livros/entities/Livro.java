package com.accountfy.livros.entities;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Livro {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private int numeroDePaginas;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
	private Date publicadoEm;
	
	private BigDecimal precoDeVenda;
	
	
	public Livro(){
		
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public Date getPublicadoEm() {
		return publicadoEm;
	}

	public void setPublicadoEm(Date publicadoEm) {
		this.publicadoEm = publicadoEm;
	}

	public BigDecimal getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(BigDecimal precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public Livro(Long id, String titulo, int numeroDePaginas, Date publicadoEm, BigDecimal precoDeVenda) {
		this.id = id;
		this.titulo = titulo;
		this.numeroDePaginas = numeroDePaginas;
		this.publicadoEm = publicadoEm;
		this.precoDeVenda = precoDeVenda;
	}

	public Livro(String titulo, int numeroDePaginas, Date publicadoEm, BigDecimal precoDeVenda) {
		this.titulo = titulo;
		this.numeroDePaginas = numeroDePaginas;
		this.publicadoEm = publicadoEm;
		this.precoDeVenda = precoDeVenda;
	}
	
	public AnoMes getAnoMesDePublicacao() {
        String dataFormatada = sdf.format(publicadoEm);
        
        AnoMes anoMes = new AnoMes(dataFormatada.substring(6, 10), dataFormatada.substring(3, 5));

        return anoMes;

    }
}
