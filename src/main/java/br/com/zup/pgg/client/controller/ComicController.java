package br.com.zup.pgg.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.pgg.client.gateway.ComicResultsGeteway;
import br.com.zup.pgg.client.service.ComicService;

@RestController
@RequestMapping("/sincronizar/comic")
public class ComicController {
	
	@Autowired
	ComicService service;
	
	@GetMapping
	public List<ComicResultsGeteway> getComics() {
		return service.salveComic();
	}
	
}
