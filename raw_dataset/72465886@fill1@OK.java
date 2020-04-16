static void fill1(int x, int y, char t) {
    if (x > -1 && x < n && y > -1 && y < n && a[x][y] == '0') {
        a[x][y] = t;
        fill1(x - 1, y, 'D');
        fill1(x + 1, y, 'U');
        fill1(x, y - 1, 'R');
        fill1(x, y + 1, 'L');
    }
}