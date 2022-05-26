package carsharing.service.dao;

import carsharing.model.Company;

import java.util.List;

public interface Dao<T> {
    void create(T entity);
    List<T> list();
}
