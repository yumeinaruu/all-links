package org.yumeinaruu.alllinks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity(name = "links")
@Component
@Data
public class Link {
    @Id
    @SequenceGenerator(name = "linksIdSeqGen", sequenceName = "links_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "linksIdSeqGen")
    private Long id;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name = "link", nullable = false)
    private String link;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;
}
