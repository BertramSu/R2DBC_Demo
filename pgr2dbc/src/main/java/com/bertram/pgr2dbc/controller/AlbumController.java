package com.bertram.pgr2dbc.controller;

import com.bertram.pgr2dbc.model.Album;
import com.bertram.pgr2dbc.service.AlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @GetMapping("/albums")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Album> getAllAlbums(@RequestParam(required = false) String title){
        if (title == null)
            return albumService.findAll();
        else
            return albumService.findByTitleContaining(title);
    }

    @GetMapping("/album/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Album> getTutorialById(@PathVariable("id") int id) {
        return albumService.findById(id);
    }

    @PostMapping("/album")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Album> createAlbum(@RequestBody Album album) {
        return albumService.save(new Album(album.getTitle(), album.getArtist(), album.getPrice()));
    }

    @PutMapping("/album/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Album> updateAlbum(@PathVariable("id") int id, @RequestBody Album album){
        return albumService.update(id, album);
    }

    @DeleteMapping("/album/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTutorial(@PathVariable("id") int id){
        return albumService.deleteById(id);
    }
}
