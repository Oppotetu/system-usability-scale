package com.sus.app.systemUsabilityScale.models;

import javax.persistence.*;

@Entity
@Table(name = "scales")
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "q1")
    private int q1;

    @Column(name = "q2")
    private int q2;

    @Column(name = "sum")
    private int sum;

    @Column(name = "score")
    private int score;

    public Scale() {

    }

    public Scale(int q1, int q2, int sum, int score) {
        this.q1 = q1;
        this.q2 = q2;
        this.sum = sum;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
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
