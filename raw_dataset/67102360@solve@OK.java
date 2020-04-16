public void solve(int testNumber, InputReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    long[] net = new long[n];
    for (int i = 0; i < m; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        long d = s.nextLong();
        net[u] -= d;
        net[v] += d;
    }
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (net[i] > 0)
            pos.add(i);
        if (net[i] < 0)
            neg.add(i);
    }
    int P = 0, N = 0;
    ArrayList<Integer> resU = new ArrayList<>();
    ArrayList<Integer> resV = new ArrayList<>();
    ArrayList<Long> resD = new ArrayList<>();
    while (N < neg.size() && P < pos.size()) {
        int u = neg.get(N);
        int v = pos.get(P);
        resU.add(u);
        resV.add(v);
        long val = Math.min(Math.abs(net[u]), Math.abs(net[v]));
        resD.add(val);
        net[u] += val;
        net[v] -= val;
        if (net[u] == 0)
            N++;
        if (net[v] == 0)
            P++;
    }
    w.println(resD.size());
    for (int i = 0; i < resD.size(); i++) {
        w.println((resU.get(i) + 1) + " " + (resV.get(i) + 1) + " " + resD.get(i));
    }
}