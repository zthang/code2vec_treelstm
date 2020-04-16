public static <T, U extends Comparable<? super U>> Queue<T> createPriority(Function<? super T, ? extends U> keyExtractor) {
    return createPriority(Comparator.comparing(keyExtractor));
}