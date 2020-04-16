static void bfs(int s, ArrayList<Integer>[] e, Set<Integer> k, int[] a, boolean bb) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] b = new boolean[a.length];
    q.add(s);
    b[s] = true;
    while (!q.isEmpty()) {
        int c = q.poll();
        for (int v : e[c]) {
            if (b[v]) {
                continue;
            }
            a[v] = a[c] + 1;
            q.add(v);
            b[v] = true;
        }
    }
}