int init(int n, int s, int e) {
    if (s == e) {
        return t[n] = 1;
    } else {
        return t[n] = init(2 * n, s, (s + e) / 2) + init(2 * n + 1, (s + e) / 2 + 1, e);
    }
}