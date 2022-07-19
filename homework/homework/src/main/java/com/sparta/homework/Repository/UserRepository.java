package com.sparta.homework.Repository;

import com.sparta.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
