public static <T> int hashAll(Iterator<T> iterator) {
    int hash = 1;
    while (iterator.hasNext()) {
        T obj = iterator.next();
        hash = hash * 31 + Objects.hashCode(obj);
    }
    return hash;
}