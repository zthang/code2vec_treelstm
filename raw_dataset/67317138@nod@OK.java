public int nod(long x) {
    int i = 0;
    while (x != 0) {
        i++;
        x = x / 10;
    }
    return i;
}