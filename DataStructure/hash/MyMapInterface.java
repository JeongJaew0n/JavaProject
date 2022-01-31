package hash;

public interface MyMapInterface<E> {
    void put(String key, E value);
    E get(String key);
    int size();
    void replace(String key, E value);
    boolean containsKey(String Key);
    boolean containsValue(E value);
    void clear();
    boolean isEmpty();
    void remove(String key);
}
