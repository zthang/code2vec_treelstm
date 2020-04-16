public void bfs(int cur, int prev) {
    // set the parent
    arr[cur][1] = prev;
    time++;
    arr[cur][2] = time;
    for (int nbrs : vtces.get(cur).nbrs.keySet()) {
        if (prev != nbrs)
            bfs(nbrs, cur);
    }
    time++;
    arr[cur][3] = time;
// System.out.println(time);
}