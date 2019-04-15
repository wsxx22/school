package com.example.school.service;

import com.example.school.entity.Profession;
import com.example.school.exception.ProfessionNotFoundException;
import com.example.school.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService {

    private ProfessionRepository professionRepository;

    @Autowired
    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public Profession findById (Long id) {

        return professionRepository.findById(id).orElseThrow(() -> new ProfessionNotFoundException("Invalid profession. Correct it."));

    }
}
