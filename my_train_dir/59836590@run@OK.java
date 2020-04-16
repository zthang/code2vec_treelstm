/*Global Variables*/
public void run() {
    c = new InputReader(System.in);
    w = new PrintWriter(System.out);
    HashMap<Integer, Integer> size = new HashMap<>();
    int n = c.nextInt(), m = c.nextInt();
    p3[] edge = new p3[n - 1];
    for (int i = 0; i < n - 1; i++) edge[i] = new p3(c.nextInt() - 1, c.nextInt() - 1, c.nextInt());
    for (int i = 0; i < n; i++) size.put(i, 1);
    Arrays.sort(edge);
    DJSet dsu = new DJSet(n);
    pair[] queries = new pair[m];
    for (int i = 0; i < m; i++) queries[i] = new pair(c.nextInt(), i);
    Arrays.sort(queries);
    int j = 0;
    long res = 0;
    long[] ans = new long[m];
    for (int i = 0; i < m; i++) {
        while (j < n - 1 && edge[j].w <= queries[i].x) {
            int xroot = dsu.root(edge[j].x), yroot = dsu.root(edge[j].y);
            dsu.union(edge[j].x, edge[j].y);
            int newroot = dsu.root(edge[j].x);
            if (size.get(xroot) != 1)
                res -= nc2(size.get(xroot));
            if (size.get(yroot) != 1)
                res -= nc2(size.get(yroot));
            if (newroot == xroot) {
                size.put(xroot, size.get(xroot) + size.get(yroot));
                size.remove(yroot);
            } else if (newroot == yroot) {
                size.put(yroot, size.get(xroot) + size.get(yroot));
                size.remove(xroot);
            } else {
                w.println("problem");
                w.flush();
            }
            res += nc2(size.get(newroot));
            // w.println(newroot+" "+xroot+" "+yroot+" "+res+" "+size.get(newroot)); w.flush();
            j++;
        }
        // w.println(i+" "+res);
        // w.flush();
        ans[i] = res;
    }
    long[] seq = new long[m];
    for (int i = 0; i < m; i++) {
        seq[queries[i].y] = ans[i];
    }
    printArray(seq);
    w.close();
}