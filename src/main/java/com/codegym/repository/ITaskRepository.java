package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {
    Iterable<Task> findAllByCategory(Category category);
}