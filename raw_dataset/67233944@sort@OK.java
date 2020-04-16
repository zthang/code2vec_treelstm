private static <T> T[] sort(T[] A, Comparator<T> C) {
    Arrays.sort(A, C);
    return A;
}