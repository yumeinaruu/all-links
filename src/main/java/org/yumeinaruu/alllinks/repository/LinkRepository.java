package org.yumeinaruu.alllinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yumeinaruu.alllinks.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
}
