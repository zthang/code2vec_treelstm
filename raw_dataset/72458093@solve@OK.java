public void solve(int testNumber, InputReader in, OutputWriter out) {
    N = in.nextInt();
    a = new Cell[N][N];
    List<Cell> blocked = new ArrayList<>();
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int x = in.nextInt() - 1, y = in.nextInt() - 1;
            a[i][j] = new Cell(i, j, x, y);
            if (x == i && y == j) {
                blocked.add(a[i][j]);
                a[i][j].direction = 'X';
            }
        }
    }
    for (Cell c : blocked) {
        dfs(c);
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (a[i][j].endy == -2 && a[i][j].endx == -2) {
                cycle(a[i][j]);
            }
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (a[i][j].direction == ' ') {
                out.printLine("INVALID");
                return;
            }
        }
    }
    out.printLine("VALID");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            out.print(a[i][j].direction);
        }
        out.printLine();
    }
}