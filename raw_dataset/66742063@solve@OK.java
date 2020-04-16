static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int n = ni();
    int[] arr = new int[n];
    ArrayList<Integer>[] odd_edges = new ArrayList[n];
    ArrayList<Integer>[] even_edges = new ArrayList[n];
    HashSet<Integer> even_sources = new HashSet<>();
    HashSet<Integer> odd_sources = new HashSet<>();
    for (int i = 0; i < n; ++i) {
        arr[i] = ni();
        odd_edges[i] = new ArrayList<>();
        even_edges[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; ++i) {
        if (i - arr[i] >= 0 && (arr[i] + arr[i - arr[i]]) % 2 == 0) {
            if (arr[i] % 2 == 0) {
                even_edges[i - arr[i]].add(i);
            } else {
                odd_edges[i - arr[i]].add(i);
            }
        } else if (i - arr[i] >= 0) {
            if (arr[i] % 2 == 0) {
                even_sources.add(i);
            } else {
                odd_sources.add(i);
            }
        }
        if (i + arr[i] < n && (arr[i] + arr[i + arr[i]]) % 2 == 0) {
            if (arr[i] % 2 == 0) {
                even_edges[i + arr[i]].add(i);
            } else {
                odd_edges[i + arr[i]].add(i);
            }
        } else if (i + arr[i] < n) {
            if (arr[i] % 2 == 0) {
                even_sources.add(i);
            } else {
                odd_sources.add(i);
            }
        }
    }
    // pl("Even sources");
    // for(int e : even_sources) {
    // p(e);
    // }
    // pl();
    // pl("Odd sources");
    // for(int e : odd_sources) {
    // p(e);
    // }
    // pl();
    int[] ans = new int[n];
    int[] even_min_dis = BFS(n, even_sources, even_edges);
    int[] odd_min_dis = BFS(n, odd_sources, odd_edges);
    for (int i = 0; i < n; ++i) {
        if (arr[i] % 2 == 1) {
            ans[i] = odd_min_dis[i];
        } else {
            ans[i] = even_min_dis[i];
        }
    }
    for (int e : ans) {
        p(e);
    }
    pl();
    pw.flush();
    pw.close();
}