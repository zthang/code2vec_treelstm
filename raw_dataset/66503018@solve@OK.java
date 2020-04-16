// static final int N = 12;
public static void solve() throws IOException {
    int n = nextInt();
    Set<Integer>[] g = new Set[N];
    for (int i = 0; i < N; i++) {
        g[i] = new HashSet<>();
    }
    int[] used = new int[N];
    Arrays.fill(used, 0);
    for (int i = 0; i < n; i++) {
        for (char c : in.readLine().toCharArray()) {
            addEdge(g, i, n + (c - 'a'));
        }
    }
    // System.out.println(Arrays.toString(g));
    int count = 0;
    for (int i = n; i < n + 26; i++) {
        if (!g[i].isEmpty() && used[i] == 0) {
            dfs(g, used, i);
            count++;
        }
    }
    System.out.println(count);
}