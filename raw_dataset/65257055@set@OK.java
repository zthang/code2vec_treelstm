public T set(int index, T val) {
    T oldValue = get(index);
    java.lang.reflect.Array.set(arr, index, val);
    return oldValue;
}