static void init(int n) {
    V = n;
    color = new int[n];
    dp = new int[n];
    ans = new int[n];
    graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
}