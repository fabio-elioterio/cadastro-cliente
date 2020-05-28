package br.com.zup.pgg.client.gateway;

import java.sql.Timestamp;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ComicRestTemplate {
	
	@Autowired
	RestTemplate restTemplate;

	public ComicRootGateway getDataMavelApi() {
		String comicResourceUrlString = "http://gateway.marvel.com/v1/public/comics?ts="+generateTimestamp()+"&apikey=e346d38f2462bffeb2bb8fcb168e9656&hash="
				+gerarHash();
		
		RestTemplate restTemplate = new RestTemplate();
		ComicRootGateway responseEntity = restTemplate.getForObject(comicResourceUrlString, ComicRootGateway.class);
		
		return responseEntity;
		
	}
	
	public String generateTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		return Long.toString(timestamp.getTime());
	}
	
	public String gerarHash() {
		
		String key = generateTimestamp()+"346015b1e8e1881054496b02fe028a75eb833eab"+"e346d38f2462bffeb2bb8fcb168e9656";
		
		String md5Hex = DigestUtils.md5Hex(key);

		return md5Hex;
	}
}
