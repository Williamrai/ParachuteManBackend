package org.william.parachuteman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.william.parachuteman.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
