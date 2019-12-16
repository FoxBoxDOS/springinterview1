package ru.kazarin.springexam.springinterview.service;

import ru.kazarin.springexam.springinterview.entity.Human;

import java.util.List;

public interface HumanService {
    Human getHumanById(Integer id);
    void saveHuman(Human human);
    void updateHuman(Integer id,String firstname, String lastname);
    List<Human> findAllByOrderByLastnameAsc();
    List<Human> findAllByOrderByLastnameDesc();
    List<Human> findByFirstnameAndLastnameLike(String firstname, String lastname);
}
