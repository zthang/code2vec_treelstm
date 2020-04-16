public void solve(int testNumber, FastReader s, PrintWriter out) {
    int n = s.nextInt();
    int q = s.nextInt();
    GPathQueries.triplet[] arr = new GPathQueries.triplet[n - 1];
    for (int i = 0; i < n - 1; i++) {
        arr[i] = new GPathQueries.triplet(s.nextInt() - 1, s.nextInt() - 1, s.nextLong());
    }
    GPathQueries.UnionFindDisjointSet ufs = new GPathQueries.UnionFindDisjointSet(n);
    Arrays.sort(arr);
    TreeMap<Long, Long> solution = new TreeMap<>();
    long ans = 0;
    int i = 0;
    while (i < n - 1) {
        int j = i;
        while (j < n - 1 && arr[j].wt == arr[i].wt) {
            int src = arr[j].src;
            int dest = arr[j].dest;
            long s1 = ufs.size[ufs.root(src)];
            long s2 = ufs.size[ufs.root(dest)];
            ufs.union(arr[j].src, arr[j].dest);
            long a = (s1 * (s1 - 1)) / 2;
            long b = (s2 * (s2 - 1)) / 2;
            long c = ((s1 + s2) * (s1 + s2 - 1)) / 2;
            ans = ans - a - b + c;
            j++;
        }
        solution.put(arr[i].wt, ans);
        i = j;
    }
    // out.println(ans);
    while (q-- > 0) {
        long query = s.nextLong();
        if (solution.floorEntry(query) == null) {
            out.println(0);
        } else {
            out.println(solution.floorEntry(query).getValue());
        }
    }
}