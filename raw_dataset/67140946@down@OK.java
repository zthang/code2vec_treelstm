private void down(int k) {
    while (2 * k <= n) {
        int j = 2 * k;
        if (j < n && less(j + 1, j))
            j++;
        if (less(k, j))
            break;
        exch(k, j);
        k = j;
    }
}