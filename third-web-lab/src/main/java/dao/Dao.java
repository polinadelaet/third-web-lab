package dao;

import java.util.List;

public interface Dao<T> {

    public void save(T t);

    public List<T> getAll();

}
