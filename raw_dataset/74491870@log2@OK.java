public int log2(int i) {
    int cnt = -1;
    while (i > 0) {
        i >>= 1;
        cnt++;
    }
    return cnt;
}