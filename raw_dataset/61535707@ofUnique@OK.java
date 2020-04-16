public static <T extends Comparable<T>> Pair<T, T> ofUnique(T first, T second) {
    if (first == null)
        return of(null, second);
    else if (second == null)
        return of(null, first);
    else
        return first.compareTo(second) < 0 ? of(first, second) : of(second, first);
}