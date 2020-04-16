public static <F extends Comparable<F>, S extends Comparable<S>> Pair<F, S> of(F first, S second) {
    return new Pair<>(first, second);
}