int sum(int p) {
    int s = 0;
    while (p > 0) {
        s += arr[p];
        p -= p & (-p);
    }
    return s;
}