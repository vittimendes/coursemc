package com.sandbox.coursemc.dto;

import java.io.Serializable;

import com.sandbox.coursemc.domain.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String nome;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO (Category obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
