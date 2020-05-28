package br.com.zup.pgg.client.gateway;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class ComicRootGateway {

	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;

	@JsonProperty(value = "data")
	private ComicDataGateway dataGateway;

	public ComicRootGateway() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	public ComicDataGateway getDataGateway() {
		return dataGateway;
	}

	public void setDataGateway(ComicDataGateway dataGateway) {
		this.dataGateway = dataGateway;
	}
}
