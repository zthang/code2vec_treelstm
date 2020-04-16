int search(int n, int s, int e, int k) {
    if (s == e) {
        return s;
    }
    if (t[2 * n] > k) {
        return search(2 * n, s, (s + e) / 2, k);
    } else {
        return search(2 * n + 1, (s + e) / 2 + 1, e, k - t[2 * n]);
    }
}