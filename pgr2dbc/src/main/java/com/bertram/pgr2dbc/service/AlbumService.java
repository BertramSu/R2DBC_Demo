package com.bertram.pgr2dbc.service;

import java.util.Optional;

import com.bertram.pgr2dbc.model.Album;
import com.bertram.pgr2dbc.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    public Flux<Album> findAll() {
        return albumRepository.findAll();
    }

    public Flux<Album> findByTitleContaining(String title){
        return albumRepository.findByTitleContaining(title);
    }

    public Mono<Album> findById(int id){
        return albumRepository.findById(id);
    }

    public Mono<Album> save(Album album){
        return albumRepository.save(album);
    }

    public Mono<Album> update(int id, Album album){
        return albumRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalAlbum -> {
                    if(optionalAlbum.isPresent()){
                        album.setId(id);
                        return albumRepository.save(album);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(int id){
        return albumRepository.deleteById(id);
    }
}
