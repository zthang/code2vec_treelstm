private T merge(T a, T b) {
    return merger.apply(a, b);
}