public boolean topSort(ArrayList<Integer>[] edge, int[] d) {
    int cnt = 0;
    Queue<Integer> que = new LinkedList<Integer>();
    for (int i = 1; i < d.length; i++) if (d[i] == 0)
        que.add(i);
    cnt = que.size();
    while (!que.isEmpty()) {
        int u = que.poll();
        for (int v : edge[u]) {
            if (--d[v] == 0) {
                que.offer(v);
                cnt++;
            }
        }
    }
    return cnt == edge.length - 1;
}