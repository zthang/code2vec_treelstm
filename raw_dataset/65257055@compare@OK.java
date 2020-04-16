public static <T extends Comparable<? super T>> int compare(T a, T b) {
    return Objects.compare(a, b, Comparator.naturalOrder());
}