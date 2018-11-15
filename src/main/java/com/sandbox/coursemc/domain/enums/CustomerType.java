package com.sandbox.coursemc.domain.enums;

public enum CustomerType {

	NATURALPERSON(1, "Natural Person"),
	LEGALPERSON(2, "Legal Person");
	
	private int cod;
	private String desc;
	
	private CustomerType(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
	
	public static CustomerType toEnum(Integer cod) {
		if (cod == null) 
			return null;
		
		for (CustomerType x : CustomerType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id");
	}
	
}
