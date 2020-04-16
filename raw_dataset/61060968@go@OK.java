void go(int pos) {
    if (pos == n) {
        check();
        return;
    }
    for (int i = 1; i <= 6; i++) {
        p[pos] = i;
        go(pos + 1);
    }
}