public static void bfs(int num, int size) {
    boolean[] visited = new boolean[size + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(num);
    ans[num] = 1;
    visited[num] = true;
    while (!q.isEmpty()) {
        int x = q.poll();
        ArrayList<Integer> al = graph.get(x);
        for (int i = 0; i < al.size(); i++) {
            int y = al.get(i);
            if (visited[y] == false) {
                q.add(y);
                ans[y] = ans[x] + 1;
                visited[y] = true;
            }
        }
    }
}