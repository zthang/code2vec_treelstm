static void solve() throws IOException {
    n = sc.nextInt();
    int m = sc.nextInt();
    gr = new ArrayList[n];
    for (int i = 0; i < n; i++) gr[i] = new ArrayList<>();
    killed = new boolean[n];
    sz = new int[n];
    pair_cnt = new long[200001];
    comp = new int[n];
    cnt = new int[n];
    max = new int[n];
    for (int i = 0; i < n - 1; i++) {
        int v1 = sc.nextInt() - 1;
        int v2 = sc.nextInt() - 1;
        int w = sc.nextInt();
        gr[v1].add(new edge(v2, w));
        gr[v2].add(new edge(v1, w));
    }
    centre(0);
    for (int i = 1; i <= 200000; i++) pair_cnt[i] += pair_cnt[i - 1];
    for (int i = 0; i < m; i++) {
        pw.print(pair_cnt[sc.nextInt()] + " ");
    }
}