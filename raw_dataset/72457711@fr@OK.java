void fr(int a, int b, int x, int y) {
    if (x > 1) {
        if (A[x - 1][y] == 0 && X[x - 1][y] == a && Y[x - 1][y] == b) {
            A[x - 1][y] = 2;
            fr(a, b, x - 1, y);
        }
    }
    if (x < n) {
        if (A[x + 1][y] == 0 && X[x + 1][y] == a && Y[x + 1][y] == b) {
            A[x + 1][y] = 3;
            fr(a, b, x + 1, y);
        }
    }
    if (y > 1) {
        if (A[x][y - 1] == 0 && X[x][y - 1] == a && Y[x][y - 1] == b) {
            A[x][y - 1] = 4;
            fr(a, b, x, y - 1);
        }
    }
    if (y < n) {
        if (A[x][y + 1] == 0 && X[x][y + 1] == a && Y[x][y + 1] == b) {
            A[x][y + 1] = 5;
            fr(a, b, x, y + 1);
        }
    }
}