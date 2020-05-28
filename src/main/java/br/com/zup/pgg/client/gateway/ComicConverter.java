package br.com.zup.pgg.client.gateway;

import br.com.zup.pgg.client.entity.Comic;

public class ComicConverter {

	public static Comic toComic(ComicResultsGeteway comicResultsGateway) {
		Comic comic = new Comic();
		
		comic.setIdOrigin(comicResultsGateway.getId());
		comic.setTitle(comicResultsGateway.getTitle());
		comic.setDescription(comicResultsGateway.getDescription());
		comic.setEan(comicResultsGateway.getEan());
		comic.setIsbn(comicResultsGateway.getIsbn());
		
		return comic;
	}
}
