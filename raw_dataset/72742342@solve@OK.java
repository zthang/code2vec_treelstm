private static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long[] c = new long[n];
    st = new StringTokenizer(in.readLine());
    ArrayList<Integer>[] nei = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        c[i] = Long.parseLong(st.nextToken());
        nei[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        st = new StringTokenizer(in.readLine());
        int u = Integer.parseInt(st.nextToken()) - 1;
        int v = Integer.parseInt(st.nextToken()) - 1;
        nei[v].add(u);
    }
    Map<Long, Long> cSum = new HashMap<>();
    for (int i = 0; i < n; i++) {
        if (nei[i].isEmpty())
            continue;
        Collections.sort(nei[i]);
        long p = nei[i].size();
        for (int x : nei[i]) {
            p = mix((p << 16) | x);
        }
        cSum.put(p, c[i] + cSum.getOrDefault(p, 0L));
    }
    long ans = 0;
    for (long x : cSum.values()) {
        while (x > 0) {
            long t = ans % x;
            ans = x;
            x = t;
        }
    }
    out.println(ans);
}