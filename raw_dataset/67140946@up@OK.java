private void up(int k) {
    while (k > 1 && less(k, k / 2)) {
        exch(k, k / 2);
        k /= 2;
    }
}