package ru.kazarin.springexam.springinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kazarin.springexam.springinterview.entity.Human;
import java.util.List;

public interface HumanRepository extends JpaRepository<Human, Integer>{
    List<Human> findAllByOrderByLastnameAsc();
    List<Human> findAllByOrderByLastnameDesc();
    List<Human> findByFirstnameAndLastnameLike(String firstname, String name);
}

