package br.com.zup.pgg.client.dto;

public class MensagemDto {

	private String mensage;
	
	public MensagemDto(String mensage) {
		this.mensage = mensage;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
}
