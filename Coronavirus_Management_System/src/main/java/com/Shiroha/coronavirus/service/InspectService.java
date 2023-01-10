package com.Shiroha.coronavirus.service;

import com.Shiroha.coronavirus.entity.Inspect;

import java.util.List;

public interface InspectService {
    public List<Inspect> find(int baseId);
    public void add(Inspect inspect);
}
