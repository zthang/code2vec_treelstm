public static <T> Iterable<T> reverseIterable(List<T> list) {
    return () -> reverseIterator(list);
}