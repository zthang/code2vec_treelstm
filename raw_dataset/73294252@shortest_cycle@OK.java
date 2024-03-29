int shortest_cycle(int n) {
    // To store length of the shortest cycle
    int ans = Integer.MAX_VALUE;
    // For all vertices
    for (int i = 0; i < n; i++) {
        if (rev.get(i) <= 1000) {
            // Make distance maximum
            int[] dist = new int[n];
            Arrays.fill(dist, (int) 1e9);
            // Take a imaginary parent
            int[] par = new int[n];
            Arrays.fill(par, -1);
            // Distance of source to source is 0
            dist[i] = 0;
            Queue<Integer> q = new ArrayDeque<>();
            // Push the source element
            q.add(i);
            // Continue until queue is not empty
            while (!q.isEmpty()) {
                // Take the first element
                int x = q.poll();
                // Traverse for all it's childs
                for (Edge c : graph[x]) {
                    int child = c.a;
                    // If it is not visited yet
                    if (dist[child] == (int) (1e9)) {
                        // Increase distance by 1
                        dist[child] = 1 + dist[x];
                        // Change parent
                        par[child] = x;
                        // Push into the queue
                        q.add(child);
                    } else if (par[x] != child && par[child] != x)
                        ans = Math.min(ans, dist[x] + dist[child] + 1);
                }
            }
        }
    }
    // If graph contains no cycle
    if (ans == Integer.MAX_VALUE)
        return -1;
    else
        return ans;
}