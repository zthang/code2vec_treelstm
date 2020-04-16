public void primSolution() {
    int n = in.nextInt();
    Coord[] coords = new Coord[n + 1];
    for (int i = 1; i <= n; i++) {
        long x = in.nextInt();
        long y = in.nextInt();
        Coord c = new Coord(x, y);
        coords[i] = c;
    }
    long[] costs = new long[n + 1];
    long[] k = new long[n + 1];
    for (int i = 1; i <= n; i++) costs[i] = in.nextInt();
    for (int i = 1; i <= n; i++) k[i] = in.nextInt();
    int[] parents = new int[n + 1];
    for (int i = 1; i <= n; i++) parents[i] = i;
    PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> (int) (a[0] - b[0]));
    boolean[] seen = new boolean[n + 1];
    long[] tmp = new long[n + 1];
    for (int i = 1; i <= n; i++) {
        pq.offer(new long[] { costs[i], 0, i });
        tmp[i] = costs[i];
    }
    List<String> posts = new ArrayList();
    List<long[]> wires = new ArrayList();
    while (!pq.isEmpty()) {
        long[] cur = pq.poll();
        if (seen[(int) cur[2]])
            continue;
        seen[(int) cur[2]] = true;
        if (cur[1] == 0) {
            posts.add(String.valueOf(cur[2]));
        } else {
            wires.add(new long[] { cur[1], cur[2] });
        }
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                long cost = (Math.abs(coords[i].x - coords[(int) cur[2]].x) + Math.abs(coords[i].y - coords[(int) cur[2]].y)) * (k[i] + k[(int) cur[2]]);
                if (cost < tmp[i]) {
                    tmp[i] = cost;
                    pq.offer(new long[] { cost, cur[2], i });
                }
            }
        }
    }
    long mincost = 0;
    for (int i = 1; i <= n; i++) {
        mincost += tmp[i];
    }
    out.println(mincost);
    out.println(posts.size());
    out.println(String.join(" ", posts));
    out.println(wires.size());
    for (int i = 0; i < wires.size(); i++) {
        long[] d = wires.get(i);
        out.println(d[0] + " " + d[1]);
    }
    out.flush();
}