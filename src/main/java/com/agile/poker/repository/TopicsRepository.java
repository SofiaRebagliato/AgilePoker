package com.agile.poker.repository;

import com.agile.poker.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TopicsRepository extends JpaRepository<Topics, UUID> {
}
