private static void solve() throws IOException {
    int n = sc.nextInt(), m = sc.nextInt();
    list = new TreeSet[n + 1];
    visited = new boolean[n + 1];
    rec = new boolean[n + 1];
    ArrayList<pp> pps = new ArrayList<>();
    path = new int[n + 1][n + 1];
    for (int i = 1; i <= n; ++i) list[i] = new TreeSet<>();
    for (int i = 1; i <= m; ++i) {
        int a = sc.nextInt(), b = sc.nextInt();
        pps.add(new pp(a, b));
        list[a].add(b);
    }
    // pr.println(2);
    for (int i = 1; i <= n; ++i) {
        if (!visited[i])
            dfss(i, -1);
    }
    boolean check = false;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (path[i][j] == 2) {
                check = true;
                break;
            }
        }
    }
    if (check)
        pr.println(2);
    else
        pr.println(1);
    /*for (pp pp:pps){
            pr.println(pp.h+" "+pp.t);
        }*/
    for (pp pp : pps) pr.print(path[pp.h][pp.t] + " ");
    pr.println();
// pr.println(Arrays.deepToString(path));
}