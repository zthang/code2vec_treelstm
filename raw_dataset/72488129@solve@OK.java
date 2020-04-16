static void solve() {
    int n = sc.nextInt();
    Set<Xy> bst = new HashSet<>();
    Xy[][] xys = new Xy[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            xys[i][j] = new Xy(x, y);
            if (xys[i][j].y == i && xys[i][j].x == j) {
                bst.add(xys[i][j]);
            }
        }
    }
    /*
for(int i=0;i<n;i++){
System.err.println(Arrays.toString(xys[i]));
}
*/
    char[][] ans = new char[n][n];
    for (Xy block : bst) {
        /*
System.err.println("block="+block);
*/
        Deque<Xy> dq = new ArrayDeque<>();
        ans[block.y][block.x] = 'X';
        dq.addFirst(block);
        while (!dq.isEmpty()) {
            Xy here = dq.pollFirst();
            /*
System.err.println("  here="+here);
*/
            for (int d = 0; d < 4; d++) {
                int nx = here.x + dx[d];
                int ny = here.y + dy[d];
                if (nx < 0 || n <= nx || ny < 0 || n <= ny) {
                    continue;
                }
                if (ans[ny][nx] == 0 && block.equals(xys[ny][nx])) {
                    /*
System.err.println("    d="+d+","+dd[d]);
System.err.println("    ["+nx+","+ny+"]");
*/
                    ans[ny][nx] = dd[d];
                    dq.add(new Xy(nx, ny));
                }
            }
        }
    }
    /*
for(int i=0;i<n;i++){
System.err.println(Arrays.toString(ans[i]));
}
*/
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (ans[i][j] == 0) {
                if (xys[i][j].equals(inf)) {
                    for (int d = 0; d < 4; d++) {
                        int nx = j + dx[d];
                        int ny = i + dy[d];
                        if (nx < 0 || n <= nx || ny < 0 || n <= ny) {
                            continue;
                        }
                        if (xys[ny][nx].equals(inf)) {
                            ans[i][j] = de[d];
                            break;
                        }
                    }
                    if (ans[i][j] == 0) {
                        out.println("INVALID");
                        return;
                    }
                } else {
                    out.println("INVALID");
                    return;
                }
            }
        }
    }
    /*
for(int i=0;i<n;i++){
System.err.println(Arrays.toString(ans[i]));
}
*/
    out.println("VALID");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            out.print(ans[i][j]);
        }
        out.println();
    }
}