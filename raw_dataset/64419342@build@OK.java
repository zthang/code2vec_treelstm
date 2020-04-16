void build(int[] v) {
    for (int i = 0; i < 2 * N; i++) {
        dat.add(d1);
    }
    for (int i = 0; i < v.length; i++) {
        dat.set(N + i - 1, v[i]);
    }
    for (int i = N - 2; i >= 0; i--) {
        dat.set(i, dat.get(i * 2 + 1) + dat.get(i * 2 + 2));
    }
}