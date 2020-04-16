void solve() throws IOException {
    scanner = new FastScanner(System.in);
    writer = new PrintWriter(System.out);
    int tests = scanner.nextInt();
    for (int t = 0; t < tests; t++) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = scanner.nextInt() - 1;
        b = scanner.nextInt() - 1;
        edges = new List[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            if (v != a && v != b)
                edges[u].add(v);
            if (u != a && u != b)
                edges[v].add(u);
        }
        colors = new int[n];
        maxColor = 0;
        List<Integer> clusterSizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != a && i != b && colors[i] == 0) {
                int size = color(i, ++maxColor);
                clusterSizes.add(size);
            }
        }
        BitSet aNbrs = getNeighborhood(a);
        BitSet bNbrs = getNeighborhood(b);
        BitSet xoredNbrs = (BitSet) aNbrs.clone();
        xoredNbrs.xor(bNbrs);
        aNbrs.and(xoredNbrs);
        bNbrs.and(xoredNbrs);
        int aSize = 0;
        int bSize = 0;
        for (int i = 0; i < maxColor; i++) {
            int clusterSize = clusterSizes.get(i);
            if (aNbrs.get(i)) {
                aSize += clusterSize;
            } else if (bNbrs.get(i))
                bSize += clusterSize;
        }
        writer.println((long) aSize * bSize);
    }
    writer.close();
}