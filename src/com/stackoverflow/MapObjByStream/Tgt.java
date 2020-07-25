package com.stackoverflow.MapObjByStream;

public class Tgt {
    int id;
    int true_count;
    int false_count;

    public Tgt(int id, int true_count, int false_count) {
        this.id = id;
        this.true_count = true_count;
        this.false_count = false_count;
    }

    public Tgt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrue_count() {
        return true_count;
    }

    public void setTrue_count(int true_count) {
        this.true_count = true_count;
    }

    public int getFalse_count() {
        return false_count;
    }

    public void setFalse_count(int false_count) {
        this.false_count = false_count;
    }
}
