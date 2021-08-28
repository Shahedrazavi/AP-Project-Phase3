package db;

import model.ID;

import java.io.File;
import java.util.LinkedList;

public interface DBSet<T> {
    ID getLastID();
    void increaseLastID();
    T get(ID ID);
    LinkedList<T> getAll();
    void add(T t);
    void remove(T t);
    void update(T t);
    void writeList(LinkedList<T> list , File file);
}
