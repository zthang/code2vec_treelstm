public ArrayList<Integer> bfs(int begin, int n, ArrayList<Integer>[] edge) {
    boolean[] vis = new boolean[n + 1];
    Queue<Node> que = new LinkedList<Node>();
    que.offer(new Node(begin, null));
    Node o = null;
    while (!que.isEmpty()) {
        Node temp = que.poll();
        if (vis[temp.index])
            continue;
        o = temp;
        vis[temp.index] = true;
        int u = temp.index;
        for (int v : edge[u]) {
            if (!vis[v]) {
                que.offer(new Node(v, temp));
            }
        }
    }
    ArrayList<Integer> buf = new ArrayList<Integer>();
    buf.add(o.index);
    while (o.pre != null) {
        o = o.pre;
        buf.add(o.index);
    }
    return buf;
}