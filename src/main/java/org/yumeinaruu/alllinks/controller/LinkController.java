package org.yumeinaruu.alllinks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yumeinaruu.alllinks.exception.custom.CustomValidationException;
import org.yumeinaruu.alllinks.model.Link;
import org.yumeinaruu.alllinks.model.dto.LinkCreateDto;
import org.yumeinaruu.alllinks.model.dto.LinkUpdateDto;
import org.yumeinaruu.alllinks.service.LinksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/link")
public class LinkController {
    private final LinksService linksService;

    @Autowired
    public LinkController(LinksService linksService) {
        this.linksService = linksService;
    }

    @GetMapping
    public ResponseEntity<List<Link>> getAllLinks() {
        List<Link> links = linksService.getAllLLinks();
        if (links.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Link> getLinkById(@PathVariable Long id) {
        Optional<Link> link = linksService.getLinkById(id);
        if (link.isPresent()) {
            return new ResponseEntity<>(link.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createLink(@RequestBody LinkCreateDto linkCreateDto,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult.getAllErrors().toString());
        }
        return new ResponseEntity<>(linksService.createLink(linkCreateDto) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateLink(@RequestBody LinkUpdateDto linkUpdateDto,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult.getAllErrors().toString());
        }
        return new ResponseEntity<>(linksService.updateLink(linkUpdateDto) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLink(@PathVariable Long id) {
        return new ResponseEntity<>(linksService.deleteLinkById(id) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }
}
