void run() throws FileNotFoundException {
    // sc = new Scanner(new File("D.txt"));
    sc = new InputReader(System.in);
    pw = new PrintWriter(System.out);
    Vector<Coords> seeds = new Vector<>();
    int n = sc.nextInt();
    Coords[][] dsts = new Coords[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dsts[i][j] = new Coords(sc.nextInt() - 1, sc.nextInt() - 1);
            if ((dsts[i][j].r == i) && (dsts[i][j].c == j)) {
                seeds.add(dsts[i][j]);
            }
        }
    }
    int U = 0, D = 1, L = 2, R = 3, X = 4;
    int[] dr = { -1, 1, 0, 0, 0 };
    int[] dc = { 0, 0, -1, 1, 0 };
    int[] rev = { 1, 0, 3, 2, 0 };
    char[] chars = { 'U', 'D', 'L', 'R', 'X' };
    int[][] map = new int[n][n];
    boolean[][] filled = new boolean[n][n];
    for (Coords seed : seeds) {
        int r0 = seed.r;
        int c0 = seed.c;
        map[r0][c0] = X;
        filled[r0][c0] = true;
        Queue<Coords> q = new LinkedList<>();
        q.add(seed);
        while (!q.isEmpty()) {
            Coords node = q.peek();
            q.poll();
            int r = node.r;
            int c = node.c;
            for (int dir = 0; dir < 4; dir++) {
                int r1 = r + dr[dir];
                int c1 = c + dc[dir];
                if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < n) {
                    if (dsts[r1][c1].r == r0 && dsts[r1][c1].c == c0 && !filled[r1][c1]) {
                        map[r1][c1] = rev[dir];
                        filled[r1][c1] = true;
                        q.add(new Coords(r1, c1));
                    }
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (dsts[i][j].r >= 0) {
                if (!filled[i][j]) {
                    // System.out.println(i + " " + j);
                    pw.println("INVALID");
                    pw.close();
                    return;
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (dsts[i][j].r < 0 && !filled[i][j]) {
                Queue<Coords> q = new LinkedList<>();
                for (int dir = 0; dir < 4; dir++) {
                    int r1 = i + dr[dir];
                    int c1 = j + dc[dir];
                    if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < n) {
                        if (dsts[r1][c1].r < 0) {
                            map[i][j] = dir;
                            filled[i][j] = true;
                            map[r1][c1] = rev[dir];
                            filled[r1][c1] = true;
                            q.add(new Coords(i, j));
                            q.add(new Coords(r1, c1));
                            break;
                        }
                    }
                }
                if (q.isEmpty()) {
                    pw.println("INVALID");
                    pw.close();
                    return;
                }
                while (!q.isEmpty()) {
                    Coords node = q.peek();
                    q.poll();
                    int r = node.r;
                    int c = node.c;
                    for (int dir = 0; dir < 4; dir++) {
                        int r1 = r + dr[dir];
                        int c1 = c + dc[dir];
                        if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < n) {
                            if (dsts[r1][c1].r < 0 && !filled[r1][c1]) {
                                map[r1][c1] = rev[dir];
                                filled[r1][c1] = true;
                                q.add(new Coords(r1, c1));
                            }
                        }
                    }
                }
            }
        }
    }
    pw.println("VALID");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            pw.print(chars[map[i][j]]);
        }
        pw.println();
    }
    pw.close();
}