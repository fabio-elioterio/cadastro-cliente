package br.com.zup.pgg.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.pgg.client.entity.Comic;

@Repository
public interface ComicRepository  extends JpaRepository<Comic, Long>{

}
