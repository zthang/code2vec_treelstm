void solve() throws IOException {
    n = ni();
    X = new int[n + 1][n + 1];
    Y = new int[n + 1][n + 1];
    A = new int[n + 1][n + 1];
    for (int x = 1; x <= n; x++) {
        for (int y = 1; y <= n; y++) {
            X[x][y] = ni();
            Y[x][y] = ni();
            if (X[x][y] == x && Y[x][y] == y)
                A[x][y] = 1;
        }
    }
    for (int x = 1; x <= n; x++) {
        for (int y = 1; y <= n; y++) {
            if (A[x][y] != 1)
                continue;
            fr(x, y, x, y);
        }
    }
    boolean f = true;
    outer: for (int x = 1; x <= n; x++) {
        for (int y = 1; y <= n; y++) {
            if (A[x][y] > 0)
                continue;
            if (X[x][y] > -1 || Y[x][y] > -1) {
                f = false;
                break outer;
            }
            if (!fr2(x, y)) {
                f = false;
                break outer;
            }
        }
    }
    if (!f)
        out.println("INVALID");
    else {
        out.println("VALID");
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (A[x][y] == 1)
                    out.print("X");
                if (A[x][y] == 2)
                    out.print("D");
                if (A[x][y] == 3)
                    out.print("U");
                if (A[x][y] == 4)
                    out.print("R");
                if (A[x][y] == 5)
                    out.print("L");
            }
            out.println();
        }
    }
    out.flush();
}