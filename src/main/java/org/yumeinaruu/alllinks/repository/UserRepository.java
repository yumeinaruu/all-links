package org.yumeinaruu.alllinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yumeinaruu.alllinks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
