package com.codegym.service.impl;

import com.codegym.model.Task;
import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.repository.ITaskRepository;
import com.codegym.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository iTaskRepository;

    @Override
    public Iterable<Task> findAll() {
        return iTaskRepository.findAll();
    }

    @Override
    public void save(Task task) {
        iTaskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return iTaskRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iTaskRepository.deleteById(id);
    }

    @Override
    public Iterable<Task> findAllByCategory(Category category) {
        return iTaskRepository.findAllByCategory(category);
    }



}