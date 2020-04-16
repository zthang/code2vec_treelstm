public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
    int n = sc.nextInt();
    long[][] p = new long[n + 1][2];
    long[] c = new long[n + 1];
    long[] k = new long[n + 1];
    int[] pre = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        pre[i] = i;
        p[i][0] = sc.nextInt();
        p[i][1] = sc.nextInt();
    }
    for (int i = 1; i <= n; i++) c[i] = sc.nextLong();
    for (int i = 1; i <= n; i++) k[i] = sc.nextLong();
    ArrayList<Node> edge = new ArrayList<Node>();
    for (int i = 1; i <= n; i++) edge.add(new Node(0, i, c[i]));
    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            long val = ((Math.abs(p[i][0] - p[j][0])) + Math.abs(p[i][1] - p[j][1])) * (k[i] + k[j]);
            edge.add(new Node(i, j, val));
        }
    }
    Collections.sort(edge);
    long ans = 0;
    int count = 0;
    ArrayList<Integer> buf1 = new ArrayList<Integer>();
    ArrayList<Node> buf2 = new ArrayList<Node>();
    for (Node temp : edge) {
        int u = temp.u;
        int v = temp.v;
        long w = temp.val;
        if (find(u, pre) != find(v, pre)) {
            count++;
            ans += w;
            if (u == 0)
                buf1.add(v);
            else
                buf2.add(new Node(u, v, -1));
            join(u, v, pre);
        }
        if (count == n)
            break;
    }
    out.println(ans);
    out.println(buf1.size());
    for (int v : buf1) out.print(v + " ");
    out.println();
    out.println(buf2.size());
    for (Node temp : buf2) out.println(temp.u + " " + temp.v);
}