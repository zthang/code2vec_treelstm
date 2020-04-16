public void solve(int testNumber, ScanReader in, PrintWriter out) {
    n = in.scanInt();
    int m = in.scanInt();
    inititalise();
    int[][] edges = new int[n - 1][3];
    for (int i = 0; i < n - 1; i++) {
        edges[i][0] = in.scanInt();
        edges[i][1] = in.scanInt();
        edges[i][2] = in.scanInt();
    }
    CodeHash.shuffle(edges);
    Arrays.sort(edges, new Comparator<int[]>() {

        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
        }
    });
    int[][] q = new int[m][2];
    for (int i = 0; i < m; i++) {
        q[i][0] = in.scanInt();
        q[i][1] = i;
    }
    CodeHash.shuffle(q);
    Arrays.sort(q, new Comparator<int[]>() {

        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        }
    });
    long[] anss = new long[m];
    int ptr = 0;
    for (int i = 0; i < m; i++) {
        while (ptr < n - 1 && edges[ptr][2] <= q[i][0]) {
            union(edges[ptr][0], edges[ptr][1]);
            ptr++;
        }
        anss[q[i][1]] = ans;
    }
    for (long i : anss) out.print(i + " ");
}