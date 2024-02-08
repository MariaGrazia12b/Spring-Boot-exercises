package com.example.Live08.features.squadra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SquadraService {
    @Autowired
    private SquadraRepository squadraRepository;
    public Squadra saveSquadra(Squadra squadra){
       return squadraRepository.saveAndFlush(squadra);
    }
    public Optional<Squadra> findById(long id){
        return squadraRepository.findById(id);
    }
    public void deleteById(long id){
        squadraRepository.deleteById(id);
    }
}
