public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), M = in.nextInt(), A = in.nextInt() - 1, B = in.nextInt() - 1;
    List<Integer>[] graph = new List[N];
    for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        graph[u].add(v);
        graph[v].add(u);
    }
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N];
    // assume B is gone and start from A
    ((LinkedList<Integer>) queue).add(A);
    visited[A] = true;
    int count = 1;
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int v : graph[u]) {
            if (!visited[v] && v != B) {
                visited[v] = true;
                ((LinkedList<Integer>) queue).add(v);
                count++;
            }
        }
    }
    long X = N - 1 - count;
    // assume A is gone and start from B
    queue.clear();
    Arrays.fill(visited, false);
    ((LinkedList<Integer>) queue).add(B);
    visited[B] = true;
    count = 1;
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int v : graph[u]) {
            if (!visited[v] && v != A) {
                visited[v] = true;
                ((LinkedList<Integer>) queue).add(v);
                count++;
            }
        }
    }
    long Y = N - 1 - count;
    out.printLine(X * Y);
}