private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        int[][] seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            seg[i][0] = in.nextInt();
            seg[i][1] = in.nextInt();
        }
        Arrays.sort(seg, Comparator.comparingInt(a -> a[0]));
        // n vertices, there must be exact n - 1 edges and no two vertices have more than 1 edge connecting them
        int edges = 0;
        boolean tree = true;
        UnionFind uf = new UnionFind(n);
        TreeSet<int[]> ts = new TreeSet<>(Comparator.comparingInt(a -> a[2]));
        // Set<Integer> intersectVertices = new HashSet<>();
        // PriorityQueue<int[]> minPq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // intersectVertices.add(0);
        // minPq.add(new int[]{0, seg[0][0], seg[0][1]});
        ts.add(new int[] { 0, seg[0][0], seg[0][1] });
        int i = 1;
        while (i < n) {
            // remove all previous segments that is completely to the left of the current segment
            while (ts.size() > 0 && seg[i][0] > ts.first()[2]) {
                ts.pollFirst();
            // int[] removed = minPq.poll();
            // intersectVertices.remove(removed[0]);
            }
            // if it completely contains the current segment
            for (int[] pseg : ts) {
                if (pseg[2] > seg[i][1]) {
                    break;
                }
                // them with a new edge; if they are already connected or there are n - 1 edges already, return NO;
                if (uf.connected(i, pseg[0]) || edges == n - 1) {
                    tree = false;
                    break;
                }
                uf.union(i, pseg[0]);
                edges++;
            // if(seg[i][1] > seg[v][1]) {
            // if(uf.connected(i ,v) || edges == n - 1) {
            // tree = false;
            // break;
            // }
            // uf.union(i, v);
            // edges++;
            // }
            }
            // if can not be tree, exit
            if (!tree) {
                break;
            }
            // otherwise add the current vertex and segment
            // intersectVertices.add(i);
            // minPq.add(new int[]{i, seg[i][0], seg[i][1]});
            ts.add(new int[] { i, seg[i][0], seg[i][1] });
            i++;
        }
        if (tree && edges != n - 1) {
            tree = false;
        }
        out.println(tree ? "YES" : "NO");
    }
    out.close();
}