void solve() {
    n = in.nextInt();
    e = in.nextInt();
    visit = new Boolean[n + 1];
    adj = IntStream.range(0, n + 1).boxed().map(x -> new ArrayList<Integer>()).collect(Collectors.toList());
    for (int i = 0; i < e; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    int answer = 0;
    for (int i = 1; i <= n; i++) {
        if (visit[i] == null) {
            answer += dfs(i) - 1;
        }
    }
    out.println(e - answer);
}