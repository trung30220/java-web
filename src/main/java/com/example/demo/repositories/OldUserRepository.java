package com.example.demo.repositories;

import com.example.demo.models.OldUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldUserRepository extends JpaRepository<OldUser, Long> {
//    @Query("SELECT u FROM Book u WHERE u.date < now()")
//    List<Book> findAllActiveUsers();

//    @Query("SELECT u.id,u.name FROM User u WHERE u.date < now()")
//    List<Object> specific();
}
