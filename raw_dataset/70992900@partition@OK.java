long partition(long x, long y) {
    long fans = y * (y + 1) / 2;
    fans = fans * x;
    return fans;
}