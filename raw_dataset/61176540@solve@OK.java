public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Integer>[] larger = new List[n];
    for (int i = 0; i < n; i++) {
        larger[i] = new ArrayList<>();
    }
    int[] total = new int[n];
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        if (a > b) {
            larger[b].add(a);
        } else {
            larger[a].add(b);
        }
        ++total[a];
        ++total[b];
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
        ans += (long) (total[i] - larger[i].size()) * larger[i].size();
    }
    int numQueries = in.nextInt();
    out.println(ans);
    for (int queryId = 0; queryId < numQueries; queryId++) {
        int i = in.nextInt() - 1;
        ans -= (long) (total[i] - larger[i].size()) * larger[i].size();
        for (int j : larger[i]) {
            ans -= (long) (total[j] - larger[j].size()) * larger[j].size();
            larger[j].add(i);
            ans += (long) (total[j] - larger[j].size()) * larger[j].size();
        }
        larger[i].clear();
        out.println(ans);
    }
}