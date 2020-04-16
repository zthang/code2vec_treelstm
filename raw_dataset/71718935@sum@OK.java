public int sum(int l, int r) {
    if (l > r) {
        return 0;
    }
    return sum(r) - sum(l - 1);
}