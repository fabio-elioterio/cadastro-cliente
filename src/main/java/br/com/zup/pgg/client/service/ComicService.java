package br.com.zup.pgg.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.pgg.client.gateway.ComicConverter;
import br.com.zup.pgg.client.gateway.ComicRestTemplate;
import br.com.zup.pgg.client.gateway.ComicResultsGeteway;
import br.com.zup.pgg.client.gateway.ComicRootGateway;
import br.com.zup.pgg.client.repository.ComicRepository;

@Service
public class ComicService {
	
	ComicRestTemplate restTemplate = new ComicRestTemplate();
	
	@Autowired
	ComicRepository repository;
	
	public List<ComicResultsGeteway> salveComic() {
		
		ComicRootGateway comicRootGateway = restTemplate.getDataMavelApi();
		List<ComicResultsGeteway> comicResultsGatewayList = comicRootGateway.getDataGateway().getResultGateways();
		
		for (ComicResultsGeteway comicResultGateway : comicResultsGatewayList) {
			repository.save(ComicConverter.toComic(comicResultGateway));
		}
		
		return comicResultsGatewayList;
	}
	
}
