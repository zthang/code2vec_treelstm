static long choose2(long c) {
    if (c < 2) {
        return 0;
    }
    return ((c) * (c - 1)) / 2;
}