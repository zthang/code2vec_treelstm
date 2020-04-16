public static <E, T extends Collection<E>> T mergeHeuristically(T a, T b) {
    if (a.size() >= b.size()) {
        a.addAll(b);
        return a;
    } else {
        b.addAll(a);
        return b;
    }
}