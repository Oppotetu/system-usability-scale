package com.sus.app.systemUsabilityScale.models;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sum")
    private int sum;

    @Column(name = "score")
    private int score;

    public Score() {

    }

    public Score(int sum, int score) {
        this.sum = sum;
        this.score = score;
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

    public String toString() {
        return "Scale [id=" + id + ", sum=" + sum + ", score=" + score + "]";
    }
}

