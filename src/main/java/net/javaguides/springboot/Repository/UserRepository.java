package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.Entites.Users;


@Repository
public interface  UserRepository extends JpaRepository<Users, Integer>{


	Users findByEmailId(String emailId);
	
}
