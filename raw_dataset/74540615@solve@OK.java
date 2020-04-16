public void solve() throws IOException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = in.nextInt();
    int q = in.nextInt();
    for (int i = 0; i <= n; i++) {
        a[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < n - 1; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        a[x].add(y);
        a[y].add(x);
    }
    parent[1] = 1;
    dfs(1, 0);
    outer: for (int i = 0; i < q; i++) {
        int x = in.nextInt();
        Vector<pair> v = new Vector<>();
        for (int j = 0; j < x; j++) {
            int val = in.nextInt();
            v.add(new pair(level[val], val));
        }
        Collections.sort(v, new Comparator<pair>() {

            public int compare(pair p1, pair p2) {
                if (p1.x < p2.x)
                    return -1;
                if (p1.x > p2.x)
                    return 1;
                return 0;
            }
        });
        int time = n + 5;
        int time1 = -1;
        for (int j = 0; j < x; j++) {
            pair p = v.get(j);
            int st = start[p.y];
            if (st > time || st < time1) {
                pw.println("NO");
                continue outer;
            }
            time = end[parent[p.y]];
            time1 = start[parent[p.y]];
        }
        pw.println("YES");
    }
    pw.flush();
    pw.close();
}