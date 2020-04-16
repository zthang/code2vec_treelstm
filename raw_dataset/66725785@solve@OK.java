public void solve() throws FileNotFoundException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        adj[i] = new ArrayList<Integer>();
    }
    Arrays.fill(ans, -1);
    PriorityQueue<pair> pq1 = new PriorityQueue<>();
    PriorityQueue<pair> pq2 = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        if (i + a[i] < n) {
            if (a[i + a[i]] % 2 == a[i] % 2) {
                adj[i + a[i]].add(i);
            } else {
                if (a[i + a[i]] % 2 == 0) {
                    pq1.add(new pair(1, i));
                } else
                    pq2.add(new pair(1, i));
                visited[i] = true;
                ans[i] = 1;
            }
        }
        if (i - a[i] >= 0) {
            if (a[i - a[i]] % 2 == a[i] % 2) {
                adj[i - a[i]].add(i);
            } else {
                if (a[i - a[i]] % 2 == 0) {
                    pq1.add(new pair(1, i));
                } else
                    pq2.add(new pair(1, i));
                visited[i] = true;
                ans[i] = 1;
            }
        }
    }
    bfs(pq1);
    bfs(pq2);
    for (int i = 0; i < n; i++) {
        pw.print(ans[i] + " ");
    }
    pw.flush();
    pw.close();
}