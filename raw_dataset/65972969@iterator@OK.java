public static <T> Iterator<T> iterator(T... arr) {
    return asList(arr).iterator();
}