int sum(int x) {
    return x < 0 ? 0 : (v[x] + sum((x & (x + 1)) - 1));
}