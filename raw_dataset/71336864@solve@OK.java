public void solve(int testNumber, InputReader in, PrintWriter out) {
    N = in.nextInt();
    long M = in.nextInt();
    int K = in.nextInt();
    ArrayList<Integer> special = new ArrayList<Integer>();
    for (int i = 0; i < K; i++) {
        special.add(in.nextInt() - 1);
    }
    adj = new ArrayList[N];
    for (int i = 0; i < N; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    int[] distToEnd = dijk(N - 1);
    int[] distFromStart = dijk(0);
    Collections.sort(special, new Comparator<Integer>() {

        public int compare(Integer integer, Integer t1) {
            return -Integer.compare(distFromStart[t1] - distToEnd[t1], distFromStart[integer] - distToEnd[integer]);
        }
    });
    int curMX = distFromStart[special.get(0)];
    int curRes = 0;
    for (int i = 1; i < K; i++) {
        curRes = Math.max(curRes, curMX + distToEnd[special.get(i)]);
        curMX = Math.max(distFromStart[special.get(i)], curMX);
    }
    out.println(Math.min(curRes + 1, distToEnd[0]));
}