private long overlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
    if (x1 > x3)
        return overlap(x3, y3, x4, y4, x1, y1, x2, y2);
    if (x3 > x2 || y4 < y1 || y3 > y2)
        return 0L;
    // (x3, ?, x2, ?)
    int yL = Math.max(y1, y3);
    int yH = Math.min(y2, y4);
    int xH = Math.min(x2, x4);
    return f(x3, yL, xH, yH);
}