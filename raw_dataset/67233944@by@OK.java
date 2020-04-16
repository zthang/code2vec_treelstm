private static Comparator<int[]> by(int j, int... J) {
    Comparator<int[]> res = (x, y) -> x[j] - y[j];
    for (int i : J) res = res.thenComparing((x, y) -> x[i] - y[i]);
    return res;
}