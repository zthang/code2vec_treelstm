public void solve(int testNumber, InputReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    ArrayList<Integer>[] dsu = new ArrayList[n];
    int[] color = new int[n];
    for (int i = 0; i < n; i++) {
        dsu[i] = new ArrayList<>();
        dsu[i].add(i);
        color[i] = i;
    }
    for (int i = 0; i < m; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        int small = color[u], big = color[v];
        if (small == big)
            continue;
        if (dsu[small].size() > dsu[big].size()) {
            int temp = small;
            small = big;
            big = temp;
        }
        for (int j : dsu[small]) {
            dsu[big].add(j);
            color[j] = big;
        }
        dsu[small].clear();
    }
    // System.out.println("///");
    int[] l = new int[n];
    Arrays.fill(l, -1);
    int[] r = new int[n];
    for (int i = 0; i < n; i++) {
        if (l[color[i]] == -1)
            l[color[i]] = i;
        r[color[i]] = i;
    }
    int ans = 0;
    int left = 0;
    while (left < n) {
        int i = left;
        while (i <= r[color[left]]) {
            // w.println(i + " " + color[left] + " " + r[color[left]]);
            if (color[i] == color[left]) {
                i++;
                continue;
            }
            ans++;
            int small = color[left], big = color[i];
            if (dsu[small].size() > dsu[big].size()) {
                int temp = small;
                small = big;
                big = temp;
            }
            r[big] = Math.max(r[small], r[big]);
            for (int j : dsu[small]) {
                dsu[big].add(j);
                color[j] = big;
            }
            dsu[small].clear();
            i++;
        }
        left = i;
    }
    w.println(ans);
}