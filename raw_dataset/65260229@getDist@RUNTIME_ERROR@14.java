    int[] getDist() {
        int b = 0;
        int e = 0;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long N = n;
        for (int i = 0; i < k; i++) {
            queue.add((long) i);
        }
        while (!queue.isEmpty()) {
            Long key = queue.poll();
            int node = (int) (key % N);
            if (res[node] >= 0) continue;
            int dist = (int) (key / N);
            res[node] = dist;
            int[] neighbors = g.neighbors[node];
            int[] pathWeight = g.pathWeights[node];
            for (int i = 0; i < neighbors.length; i++) {
                int neighbor = neighbors[i];
                if (res[neighbor] >= 0) continue;
                queue.add((dist + pathWeight[i]) * N + neighbor);
            }
        }
        return res;
    }