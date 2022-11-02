package com.sus.app.systemUsabilityScale.services;

import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("ScaleService")
@Transactional
public class ScaleServiceImpl implements ScaleService {
    @Autowired
    private ScaleRepository scaleRepository;

    @Override
    public float findAverageScore() {
        return scaleRepository.findAverageScore();
    }

}
