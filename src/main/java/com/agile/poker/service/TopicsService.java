package com.agile.poker.service;

import com.agile.poker.entity.Topics;

import java.util.List;
import java.util.UUID;

public interface TopicsService {

    public List<Topics> findAll();
    public Topics findById(UUID uuid);
    public Topics addTopic(Topics topic);
    public void deleteTopic(UUID uuid);
    public Topics updateTopic(Topics topic, Topics existTopic);
    public boolean existByTopic(UUID uuid);
}
