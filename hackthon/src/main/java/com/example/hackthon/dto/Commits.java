package com.example.hackthon.dto;

import java.util.List;

public class Commits {

    private List<Commit> commits;

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    @Override
    public String toString() {
        return "Commits{" +
            "commits=" + commits +
            '}';
    }
}
