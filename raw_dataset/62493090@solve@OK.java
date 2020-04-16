public void solve() throws IOException {
    int n = readInt();
    int[] a = new int[n + 1];
    int[] b = new int[n + 1];
    int[] c = new int[n + 1];
    for (int i = 0; i < n; i++) a[i + 1] = readInt();
    for (int i = 0; i < n; i++) b[i + 1] = readInt();
    for (int i = 0; i < n; i++) c[i + 1] = readInt();
    int start = -1;
    ArrayList<Integer>[] arr = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) arr[i] = new ArrayList<Integer>();
    for (int i = 0; i < n - 1; i++) {
        int u = readInt();
        int v = readInt();
        arr[u].add(v);
        arr[v].add(u);
    }
    for (int i = 1; i <= n; i++) {
        if (arr[i].size() == 1) {
            start = i;
            break;
        }
    }
    if (check(start, arr, -1) != n)
        out.println(-1);
    else {
        long cost1 = eval(start, arr, -1, a, b, c, 0);
        long cost2 = eval(start, arr, -1, a, c, b, 0);
        long cost3 = eval(start, arr, -1, b, a, c, 0);
        long cost4 = eval(start, arr, -1, b, c, a, 0);
        long cost5 = eval(start, arr, -1, c, a, b, 0);
        long cost6 = eval(start, arr, -1, c, b, a, 0);
        long min = cost1;
        int trav = 1;
        if (cost2 < min) {
            min = cost2;
            trav = 2;
        }
        if (cost3 < min) {
            min = cost3;
            trav = 3;
        }
        if (cost4 < min) {
            min = cost4;
            trav = 4;
        }
        if (cost5 < min) {
            min = cost5;
            trav = 5;
        }
        if (cost6 < min) {
            min = cost6;
            trav = 6;
        }
        int[] color = new int[n + 1];
        int prev = -1;
        int count = 0;
        int next = 0;
        while (start != prev) {
            color[start] = count % 3;
            next = start;
            for (int k = 0; k < arr[start].size(); k++) {
                if (arr[start].get(k) != prev) {
                    next = arr[start].get(k);
                    break;
                }
            }
            prev = start;
            start = next;
            count++;
        }
        int[][] lp = new int[7][3];
        lp[1][0] = 1;
        lp[1][1] = 2;
        lp[1][2] = 3;
        lp[2][0] = 1;
        lp[2][1] = 3;
        lp[2][2] = 2;
        lp[3][0] = 2;
        lp[3][1] = 1;
        lp[3][2] = 3;
        lp[4][0] = 2;
        lp[4][1] = 3;
        lp[4][2] = 1;
        lp[5][0] = 3;
        lp[5][1] = 1;
        lp[5][2] = 2;
        lp[6][0] = 3;
        lp[6][1] = 2;
        lp[6][2] = 1;
        out.println(min);
        for (int i = 1; i <= n; i++) {
            out.print(lp[trav][color[i]] + " ");
        }
    }
}