package com.agile.poker.service.impl;

import com.agile.poker.entity.Topics;
import com.agile.poker.repository.TopicsRepository;
import com.agile.poker.service.TopicsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TopicsServiceImpl implements TopicsService {

    private final TopicsRepository topicRepository;

    public List<Topics> findAll() {
        return topicRepository.findAll();
    }

    public Topics findById(UUID uuid) {
        return topicRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    public Topics addTopic(Topics topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(UUID uuid) {
        topicRepository.deleteById(uuid);
    }

    public void notOwner(UUID uuid) {
        topicRepository.notify();
    }

    public Topics updateTopic(Topics topic, Topics existTopic) {
        existTopic.setTitle(topic.getTitle());
        existTopic.setDescription(topic.getDescription());
        return topicRepository.save(existTopic);
    }

    public boolean existByTopic(UUID uuid) {
        return topicRepository.existsById(uuid);
    }
}
