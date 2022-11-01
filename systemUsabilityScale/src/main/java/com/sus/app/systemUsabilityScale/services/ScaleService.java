package com.sus.app.systemUsabilityScale.services;

import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.models.Scale2;
import com.sus.app.systemUsabilityScale.models.Score;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScaleService {

    public double computeScore (Scale2 scale) {
        double result =
                    scale.getQ1() +
                        scale.getQ2() +
                        scale.getQ3() +
                        scale.getQ4() +
                        scale.getQ5() +
                        scale.getQ6() +
                        scale.getQ7() +
                        scale.getQ8() +
                        scale.getQ9() +
                        scale.getQ10();
        return result * 2.5;
    }

}
