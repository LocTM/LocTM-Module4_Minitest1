package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.dto.TotalAmount;

import java.util.List;


public interface ICategoryService extends IGenerateService<Category> {
    Iterable<TotalAmount> getTotalAmount();
}