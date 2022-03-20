package org.william.parachuteman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.william.parachuteman.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
