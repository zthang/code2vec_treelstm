void solve() {
    int n = scn.nextInt();
    int[][] arr = scn.next2DInt(n, 2);
    int[] cost = scn.nextIntArray(n);
    int[] per = scn.nextIntArray(n);
    ArrayList<edge> E = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long w = (Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])) * 1L * (per[i] + per[j]);
            E.add(new edge(i, j, w));
        }
        E.add(new edge(i, n, cost[i]));
    }
    Collections.sort(E, (o1, o2) -> Long.compare(o1.w, o2.w));
    long ans = 0;
    int stn = 0;
    DisJointSet dj = new DisJointSet(n + 1);
    for (edge e : E) {
        if (!dj.isSame(e.u, e.v)) {
            ans += e.w;
            dj.union(e.u, e.v);
            e.taken = true;
            if (e.v == n) {
                stn++;
            }
        }
    }
    out.println(ans);
    out.println(stn);
    for (edge e : E) {
        if (e.taken && e.v == n) {
            out.print(e.u + 1 + " ");
        }
    }
    out.println();
    out.println(n - stn);
    for (edge e : E) {
        if (e.taken && e.v != n) {
            out.println((e.u + 1) + " " + (e.v + 1));
        }
    }
}