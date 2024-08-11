package com.bertram.pgr2dbc.repository;

import com.bertram.pgr2dbc.model.Album;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

public interface AlbumRepository extends R2dbcRepository<Album, Integer> {
    Flux<Album> findByTitleContaining(String title);
}
