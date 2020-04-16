public int diff(int x, int y) {
    if (!same(x, y)) {
        return Integer.MAX_VALUE;
    }
    return calcWeight(y) - calcWeight(x);
}