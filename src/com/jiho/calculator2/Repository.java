package com.jiho.calculator2;

import java.util.ArrayList;
import java.util.List;

//저장소
public class Repository {
    private final List<String> tokens = new ArrayList<>();

    //토큰 저장
    public void save(String result) {
        tokens.add(result);
    }

    //리스트 반환
    public List<String> getTokens() {
        return new ArrayList<>(tokens);
    }

    public void clear() {
        tokens.clear();
    }
}
