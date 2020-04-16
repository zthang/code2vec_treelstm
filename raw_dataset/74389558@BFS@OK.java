int BFS(int src) {
    queue = new LinkedList<>();
    queue.add(src);
    visited[src] = 1;
    int lycan = 1;
    int vampire = 0;
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int i = 0; i < adjlist.get(u).size(); i++) {
            if (visited[adjlist.get(u).get(i)] == 0) {
                if (visited[u] == 2) {
                    visited[adjlist.get(u).get(i)] = 1;
                    lycan++;
                } else {
                    vampire++;
                    visited[adjlist.get(u).get(i)] = 2;
                }
                queue.add(adjlist.get(u).get(i));
            }
        }
    }
    return Math.max(vampire, lycan);
}