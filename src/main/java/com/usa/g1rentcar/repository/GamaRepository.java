package com.usa.g1rentcar.repository;

import com.usa.g1rentcar.model.Gama;
import com.usa.g1rentcar.repository.crud.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {
    @Autowired
    private GamaCrudRepository gamaCrudRepository;
    public List<Gama> getAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }

    public Gama save(Gama gama){
        return gamaCrudRepository.save(gama);
    }
    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }

}
