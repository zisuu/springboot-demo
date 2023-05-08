package ch.finecloud.demo.json;

import java.util.List;

public record AstroResult(String message, int number, List<Assignment> people) {
    @Override
    public String message() {
        return message;
    }

    @Override
    public int number() {
        return number;
    }

    @Override
    public List<Assignment> people() {
        return people;
    }
}
