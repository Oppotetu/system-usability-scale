package com.sus.app.systemUsabilityScale.models;

import jdk.jfr.DataAmount;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;


/*@SqlResultSetMapping(
        name = "AllScoresResult",
        columns = {@ColumnResult(name="scores")}
)
@NamedNativeQuery(
        name = "AllScores",
        query = "SELECT score FROM scales",
        resultSetMapping = "AllScoresResult"
)*/
@Entity
public class AllScores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Double scores;

    public AllScores() {

    }

    public AllScores(Double scores) {
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }
}
