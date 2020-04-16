public void set(T ob, int i) {
    if (i < 0 || n <= i) {
        throw new IndexOutOfBoundsException(String.valueOf(i) + "isOutFromLength " + String.valueOf(n));
    }
    int j = m / 2 + i;
    a[j] = ob;
    while (true) {
        if (j == 0) {
            break;
        }
        j = prt(j);
        a[j] = op.apply(a[lch(j)], a[rch(j)]);
    }
}