public int valueOf(long x) {
    x %= m;
    if (x < 0) {
        x += m;
    }
    return (int) x;
}