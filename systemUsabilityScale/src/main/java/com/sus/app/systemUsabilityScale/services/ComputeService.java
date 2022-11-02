package com.sus.app.systemUsabilityScale.services;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.stereotype.Service;

@Service
public class ComputeService {

    public float computeScore (Scale scale) {
        float result =
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
        return (float) (result * 2.5);
    }
}
