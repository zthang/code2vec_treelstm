public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    int[] arr = in.readIntArrayAndDecrementOne(k);
    graph = LUtils.genArrayList(n);
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1, b = in.nextInt() - 1;
        graph[a].add(b);
        graph[b].add(a);
    }
    int[] dist0 = getDist(0);
    int[] dist1 = getDist(n - 1);
    int ans = dist0[n - 1];
    DCowAndFields.State[] ds = new DCowAndFields.State[k];
    for (int i = 0; i < k; i++) {
        ds[i] = new DCowAndFields.State(dist0[arr[i]], dist1[arr[i]], i);
    }
    Arrays.sort(ds, Comparator.comparingInt(x -> x.a));
    int mx = 0;
    for (int i = 0; i + 1 < k; i++) {
        mx = Math.max(mx, Math.min(ds[i].a + ds[i + 1].b, ds[i].b + ds[i + 1].a) + 1);
    }
    out.println(Math.min(ans, mx));
}