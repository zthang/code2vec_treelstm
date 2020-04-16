static int[] bfs(int n, int[] arr) {
    int[] vis = new int[n + 1];
    Arrays.fill(vis, -1);
    Queue<Integer> queue = new ArrayDeque<>();
    ArrayDeque<Integer>[] g = genDQ(n + 1);
    for (int i = 1; i <= n; i++) {
        int prev = i - arr[i], next = i + arr[i];
        if (prev >= 1) {
            g[prev].addLast(i);
        }
        if (next <= n) {
            g[next].addLast(i);
        }
        if (prev >= 1 && arr[i] % 2 != arr[prev] % 2 && vis[i] == -1) {
            queue.add(i);
            vis[i] = 1;
        }
        if (next <= n && arr[i] % 2 != arr[next] % 2 && vis[i] == -1) {
            queue.add(i);
            vis[i] = 1;
        }
    }
    while (!queue.isEmpty()) {
        int top = queue.poll();
        for (int child : g[top]) {
            if (vis[child] == -1) {
                vis[child] = vis[top] + 1;
                queue.add(child);
            }
        }
    }
    return vis;
}