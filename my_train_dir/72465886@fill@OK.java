static void fill(int x, int y, int c, int d, char t) {
    if (x > -1 && x < n && y > -1 && y < n && b[x][y].x == c && b[x][y].y == d && a[x][y] == '0') {
        a[x][y] = t;
        fill(x - 1, y, c, d, 'D');
        fill(x + 1, y, c, d, 'U');
        fill(x, y - 1, c, d, 'R');
        fill(x, y + 1, c, d, 'L');
    }
}