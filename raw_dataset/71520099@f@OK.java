// return #black cells in rectangle
private long f(int x1, int y1, int x2, int y2) {
    long dx = 1L + x2 - x1;
    long dy = 1L + y2 - y1;
    if (dx % 2 == 0 || dy % 2 == 0 || (x1 + y1) % 2 == 0)
        return 1L * dx * dy / 2;
    return 1L * dx * dy / 2 + 1;
}