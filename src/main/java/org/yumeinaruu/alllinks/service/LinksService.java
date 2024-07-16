package org.yumeinaruu.alllinks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yumeinaruu.alllinks.exception.custom.NoSuchDataInDbException;
import org.yumeinaruu.alllinks.model.Link;
import org.yumeinaruu.alllinks.model.dto.LinkCreateDto;
import org.yumeinaruu.alllinks.model.dto.LinkUpdateDto;
import org.yumeinaruu.alllinks.repository.LinkRepository;
import org.yumeinaruu.alllinks.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LinksService {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    @Autowired
    public LinksService(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public List<Link> getAllLLinks() {
        return linkRepository.findAll();
    }

    public Optional<Link> getLinkById(Long id) {
        return linkRepository.findById(id);
    }

    public Boolean createLink(LinkCreateDto linkCreateDto) {
        Link link = new Link();
        link.setService(linkCreateDto.getService());
        link.setLink(linkCreateDto.getLink());
        if(userRepository.findByUsername(linkCreateDto.getUsername()).isPresent()) {
            link.setUserId(userRepository.findByUsername(linkCreateDto.getUsername()).get());
        } else {
            throw new NoSuchDataInDbException(linkCreateDto.getUsername());
        }
        Link savedLink = linkRepository.save(link);
        return getLinkById(savedLink.getId()).isPresent();
    }

    public Boolean updateLink(LinkUpdateDto linkUpdateDto) {
        Optional<Link> optionalLink = linkRepository.findById(linkUpdateDto.getId());
        if(optionalLink.isPresent()) {
            Link link = optionalLink.get();
            link.setService(linkUpdateDto.getService());
            link.setLink(linkUpdateDto.getLink());
            if(userRepository.findByUsername(linkUpdateDto.getUsername()).isPresent()) {
                link.setUserId(userRepository.findByUsername(linkUpdateDto.getUsername()).get());
            } else {
                throw new NoSuchDataInDbException(linkUpdateDto.getUsername());
            }
            Link savedLink = linkRepository.saveAndFlush(link);
            return savedLink.equals(link);
        }
        return false;
    }

    public Boolean deleteLinkById(Long id) {
        Optional<Link> optionalLink = linkRepository.findById(id);
        if(optionalLink.isEmpty()) {
            return false;
        }
        linkRepository.delete(optionalLink.get());
        return true;
    }
}
