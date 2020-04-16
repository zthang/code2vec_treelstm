public static long solve(int N, int M, int A, int B, Scanner in) {
    // create an empty graph (array of lists)
    List<Integer>[] graph = new List[N];
    for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
    }
    // make the double connections
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        graph[u].add(v);
        graph[v].add(u);
    }
    Queue<Integer> queue = new LinkedList<>();
    // store the visits
    boolean[] visited = new boolean[N];
    // assume B is gone and start from A
    ((LinkedList<Integer>) queue).add(A);
    visited[A] = true;
    int count = 1;
    // do bfs, count all the nodes that go through A
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
    return X * Y;
}