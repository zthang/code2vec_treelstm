boolean fr2(int x, int y) {
    if (x > 1) {
        if (X[x - 1][y] == -1) {
            if (A[x - 1][y] == 0)
                A[x - 1][y] = 2;
            A[x][y] = 3;
            return true;
        }
    }
    if (x < n) {
        if (X[x + 1][y] == -1) {
            if (A[x + 1][y] == 0)
                A[x + 1][y] = 3;
            A[x][y] = 2;
            return true;
        }
    }
    if (y > 1) {
        if (X[x][y - 1] == -1) {
            if (A[x][y - 1] == 0)
                A[x - 1][y] = 4;
            A[x][y] = 5;
            return true;
        }
    }
    if (y < n) {
        if (X[x][y + 1] == -1) {
            if (A[x][y + 1] == 0)
                A[x][y + 1] = 5;
            A[x][y] = 4;
            return true;
        }
    }
    return false;
}