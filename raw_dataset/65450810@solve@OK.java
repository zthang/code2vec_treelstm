public void solve(int testNumber, InputReader in, PrintWriter out) {
    int t = in.nextInt();
    while (t-- > 0) {
        int nodes = in.nextInt();
        int edges = in.nextInt();
        int[][] a = new int[nodes][2];
        for (int i = 0; i < nodes; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = i + 1;
        }
        if (nodes == 2 || edges < nodes) {
            out.println(-1);
        } else {
            Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
            long ans = 0L;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                list.add(a[i][1]);
                list.add(a[(i + 1) % nodes][1]);
                ans += a[i][0] + a[(i + 1) % nodes][0];
                edges--;
            }
            while (edges-- > 0) {
                list.add(a[0][1]);
                list.add(a[1][1]);
                ans += a[0][0] + a[1][0];
            }
            out.println(ans);
            for (int i = 0; i < list.size(); i += 2) {
                int u = list.get(i);
                int v = list.get(i + 1);
                out.println(u + " " + v);
            }
        }
    }
}