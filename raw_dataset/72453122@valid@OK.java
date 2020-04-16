boolean valid(int x, int y, int stx, int sty) {
    if (s[x][y] != '\0') {
        return false;
    }
    if (to[x][y][0] != stx || to[x][y][1] != sty) {
        return false;
    }
    return true;
}