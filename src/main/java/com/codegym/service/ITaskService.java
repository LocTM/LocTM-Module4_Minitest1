package com.codegym.service;

import com.codegym.model.Task;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ITaskService extends IGenerateService<Task>{
    Iterable<Task> findAllByCategory(Category category);
}