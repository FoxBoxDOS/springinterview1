package ru.kazarin.springexam.springinterview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.kazarin.springexam.springinterview.entity.*;
import ru.kazarin.springexam.springinterview.repository.HumanRepository;
import org.hibernate.SessionFactory;

import java.util.List;

@Service
public class HumanServiceImpl implements HumanService {
    private HumanRepository repository;

    private SessionFactory sessionFactory;

    @Autowired
    public void setProductRepository(HumanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Human getHumanById(Integer id) {
        //return repository.findOne(id);
        return repository.getOne(id);
    }

    @Override
    public void saveHuman(Human human) {
        repository.save(human);
    }

    @Override
    public void updateHuman(Integer id, String firstname, String lastname) {
        Human updated = repository.getOne(id);
        updated.setFirstname(firstname);
        updated.setLastname(lastname);
        repository.save(updated);
    }


    @Override
    public List<Human> findAllByOrderByLastnameAsc() {
        return repository.findAllByOrderByLastnameAsc();
    }

    @Override
    public List<Human> findAllByOrderByLastnameDesc() {
        return repository.findAllByOrderByLastnameDesc();
    }

    @Override
    public List<Human> findByFirstnameAndLastnameLike(String firstname, String lastname){
        return repository.findByFirstnameAndLastnameLike(firstname, lastname);
    }

}
