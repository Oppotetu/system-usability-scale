package com.sus.app.systemUsabilityScale.services;

import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.models.Score;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScaleService {

    @Autowired
    ScaleRepository scaleRepository;

    public void saveScale(Scale scale) {
        scaleRepository.save(scale);
    }

}
