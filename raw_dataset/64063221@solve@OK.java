void solve() {
    int n = ni();
    int[][] p = na(n, 2);
    int[] cost = na(n);
    int[] k = na(n);
    boolean[] visited = new boolean[n];
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

        public int compare(int[] arg0, int[] arg1) {
            return arg0[0] - arg1[0];
        }
    });
    for (int i = 0; i < n; i++) pq.add(new int[] { cost[i], i, -1 });
    List<Integer> l1 = new ArrayList<Integer>();
    List<int[]> l2 = new ArrayList<int[]>();
    long ans = 0;
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        if (!visited[cur[1]]) {
            visited[cur[1]] = true;
            ans += cur[0];
            if (cur[2] == -1)
                l1.add(cur[1]);
            else
                l2.add(new int[] { cur[2], cur[3] });
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    long nc = (long) (k[cur[1]] + k[i]) * (Math.abs(p[cur[1]][0] - p[i][0]) + Math.abs(p[cur[1]][1] - p[i][1]));
                    if (nc < cost[i]) {
                        cost[i] = (int) nc;
                        pq.add(new int[] { cost[i], i, cur[1], i });
                    }
                }
            }
        }
    }
    StringBuffer sb = new StringBuffer();
    sb.append(ans).append(System.lineSeparator());
    sb.append(l1.size()).append(System.lineSeparator());
    for (int i : l1) sb.append(i + 1).append(' ');
    sb.append(System.lineSeparator()).append(l2.size()).append(System.lineSeparator());
    for (int[] i : l2) sb.append(i[0] + 1).append(' ').append(i[1] + 1).append(System.lineSeparator());
    out.println(sb.toString());
}