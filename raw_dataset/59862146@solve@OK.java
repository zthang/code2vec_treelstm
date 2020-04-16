public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] mat = new int[n - 1][3];
    int i;
    for (i = 0; i < n - 1; i++) {
        mat[i][0] = in.nextInt();
        mat[i][1] = in.nextInt();
        mat[i][2] = in.nextInt();
    }
    Arrays.sort(mat, (int[] o1, int[] o2) -> {
        return o1[2] - o2[2];
    });
    TreeMap<Integer, Long> tm = new TreeMap<>();
    DisjointSet ds = new DisjointSet();
    for (i = 1; i <= n; i++) ds.makeSet(i);
    tm.put(0, 0l);
    for (i = 0; i < n - 1; i++) {
        Node a = ds.findSet(mat[i][0]);
        Node b = ds.findSet(mat[i][1]);
        long cur = 1l * a.size * b.size;
        tm.merge(mat[i][2], cur, (x, y) -> x + y);
        ds.union(mat[i][0], mat[i][1]);
    }
    // out.println(tm);
    long sum = 0;
    Iterator it = tm.keySet().iterator();
    while (it.hasNext()) {
        int key = (int) it.next();
        long val = tm.get(key);
        sum += val;
        tm.put(key, sum);
    }
    for (i = 0; i < m; i++) {
        int q = in.nextInt();
        long ans = tm.get(tm.floorKey(q));
        out.print(ans + " ");
    }
    out.println();
}