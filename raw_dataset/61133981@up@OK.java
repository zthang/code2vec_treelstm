private boolean up(int[] c) {
    int i = 0;
    while (i < c.length && c[i] == 6) {
        c[i] = 1;
        i++;
    }
    if (i == c.length)
        return false;
    c[i]++;
    return true;
}