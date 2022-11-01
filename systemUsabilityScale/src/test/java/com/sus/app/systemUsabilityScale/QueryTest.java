package com.sus.app.systemUsabilityScale;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QueryTest {

    private static EntityManager em;
    private static EntityManagerFactory emFactory;

    @BeforeAll
    public static void setup() {
        emFactory = Persistence.createEntityManagerFactory("java-jpa-scheduled-day");
        em = emFactory.createEntityManager();
    }

    @Test
    public void whenNamedQuery_thenColumnResult() {
        List<Long> AllScores = em.createNamedQuery("AllScores").getResultList();
        assertEquals(2, AllScores.size());
    }
}

