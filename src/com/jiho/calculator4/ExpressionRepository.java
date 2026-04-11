package com.jiho.calculator4;

import java.util.ArrayList;
import java.util.List;

public class ExpressionRepository {
    private final List<String> tokens = new ArrayList<>();

    public void addToken(String token) {
        tokens.add(token);
    }

    public List<String> getTokens(){
        return new ArrayList<>(tokens);
    }

    public void clear() {
        tokens.clear();
    }
}
