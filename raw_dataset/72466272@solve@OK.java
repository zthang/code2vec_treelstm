void solve(PrintWriter out, Reader in) throws IOException {
    n = in.nextInt();
    arr = new int[n + 1][n + 1][2];
    ans = new char[n + 1][n + 1];
    Queue<Node> q = new LinkedList<Node>();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            ans[i][j] = '0';
            arr[i][j][x] = in.nextInt();
            arr[i][j][y] = in.nextInt();
            if (arr[i][j][x] == i && arr[i][j][y] == j) {
                ans[i][j] = 'X';
                q.add(new Node(i, j));
            }
        }
    }
    Node elm;
    while (q.size() != 0) {
        elm = q.remove();
        DFS(elm);
    }
    boolean flag = false;
    Node s = new Node(0, 0);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (ans[i][j] == '0') {
                if (arr[i][j][x] != -1 || arr[i][j][y] != -1) {
                    out.println("INVALID");
                    return;
                } else {
                    flag = false;
                    for (int z = 0; z < 4; z++) {
                        int xx = d[z][0] + i, yy = d[z][1] + j;
                        if (xx > 0 && xx <= n && yy > 0 && yy <= n && arr[xx][yy][x] == -1 && arr[xx][yy][y] == -1) {
                            if (z == 0)
                                ans[i][j] = 'D';
                            else if (z == 1)
                                ans[i][j] = 'U';
                            else if (z == 2)
                                ans[i][j] = 'R';
                            else
                                ans[i][j] = 'L';
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    out.println("INVALID");
                    return;
                }
            }
        }
    }
    out.println("VALID");
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            out.print(ans[i][j]);
        }
        out.println();
    }
}