package com.sus.app.systemUsabilityScale.models;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sum")
    /*@OneToMany(mappedBy = "mapsum")*/
    private int sum;

    @Column(name = "score")
    private int score;

    @Column(name = "aboveAverage")
    private boolean aboveAverage;

    public Score() {

    }

    public Score(int sum, int score, boolean aboveAverage) {
        this.sum = sum;
        this.score = score;
        this.aboveAverage = aboveAverage;
    }

    public long getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isAboveAverage() {
        return aboveAverage;
    }

    public void setAboveAverage(boolean aboveAverage) {
        this.aboveAverage = aboveAverage;
    }

    public String toString() {
        return "Evaluation with id: " + id + " has sum: " + sum + ", and a score of: " + score + ".";
    }
}

