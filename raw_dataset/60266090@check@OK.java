public boolean check(int i, int j) {
    if (i == j) {
        return true;
    }
    int r1 = levels[log2].rootOf(i);
    int r2 = levels[log2].rootOf(j);
    return r1 == r2;
}