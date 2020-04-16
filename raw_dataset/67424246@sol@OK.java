void sol() throws IOException {
    int n = sc.ni();
    int[] a = new int[n];
    List<Integer> even = new ArrayList<>();
    List<Integer> odd = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        a[i] = sc.ni();
        if (a[i] % 2 == 0)
            even.add(i);
        else
            odd.add(i);
    }
    int[] ans = new int[n];
    Arrays.fill(ans, Integer.MAX_VALUE);
    list = new ArrayList[n];
    for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
    v = new boolean[n];
    for (int i = 0; i < n; i++) {
        int lf = i - a[i];
        int nx = i + a[i];
        if (lf >= 0)
            list[lf].add(i);
        if (nx < n)
            list[nx].add(i);
    }
    Arrays.fill(ans, -1);
    bfs(ans, odd, even);
    bfs(ans, even, odd);
    for (int h : ans) out.print(h + " ");
    out.println();
}