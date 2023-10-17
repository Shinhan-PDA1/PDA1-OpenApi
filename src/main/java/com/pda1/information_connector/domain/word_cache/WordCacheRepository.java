package com.pda1.information_connector.domain.word_cache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordCacheRepository extends JpaRepository<WordCache, Long> {
    Optional<WordCache> findByWord(String question);
}
