public void solve() throws Exception {
    int n = ni();
    int m = ni();
    int[] arr = new int[n + 1];
    ArrayList<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        arr[i] = ni();
        graph[i] = new ArrayList<Integer>();
    }
    if (n <= 2 || m != n) {
        out.println(-1);
        return;
    }
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    for (int i = 1; i <= n; i++) {
        pq.add(new Node(i, 0, arr[i]));
    }
    Node temp = pq.poll();
    long res = 0l;
    int x = temp.x;
    StringBuilder sb = new StringBuilder("");
    while (pq.size() > 0) {
        Node curr = pq.poll();
        res += (temp.wt + curr.wt);
        sb.append(temp.x + " " + curr.x + "\n");
        temp = curr;
    }
    sb.append(x + " " + temp.x + "\n");
    res += arr[x] + arr[temp.x];
    out.println(res);
    out.print(new String(sb));
}