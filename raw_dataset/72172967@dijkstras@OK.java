static int[] dijkstras(ArrayList<Integer>[] adj, int s) {
    int[] res = new int[n];
    Arrays.fill(res, 987654321);
    res[s] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    pq.add(new int[] { s, 0 });
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        if (curr[1] > res[curr[0]])
            continue;
        for (int e : adj[curr[0]]) {
            if (1 + curr[1] < res[e]) {
                res[e] = 1 + curr[1];
                pq.add(new int[] { e, res[e] });
            }
        }
    }
    return res;
}