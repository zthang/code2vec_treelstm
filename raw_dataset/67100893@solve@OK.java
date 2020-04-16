static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    long[] bal = new long[n + 1];
    for (int i = 1; i <= m; ++i) {
        int u = ni(), v = ni(), w = ni();
        bal[u] -= w;
        bal[v] += w;
    }
    TreeSet<Pair> pos = new TreeSet<>();
    TreeSet<Pair> neg = new TreeSet<>();
    for (int i = 1; i <= n; ++i) {
        if (bal[i] > 0) {
            pos.add(new Pair(bal[i], i));
        } else if (bal[i] < 0) {
            neg.add(new Pair(-bal[i], i));
        }
    }
    ArrayList<Integer> listx = new ArrayList<>();
    ArrayList<Integer> listy = new ArrayList<>();
    ArrayList<Long> listw = new ArrayList<>();
    while (!pos.isEmpty() || !neg.isEmpty()) {
        Pair p = pos.pollLast();
        Pair ne = neg.pollLast();
        listx.add(ne.y);
        listy.add(p.y);
        listw.add(min(ne.x, p.x));
        if (p.x > ne.x) {
            pos.add(new Pair(p.x - ne.x, p.y));
        } else if (ne.x > p.x) {
            neg.add(new Pair(ne.x - p.x, ne.y));
        }
    }
    pl(listx.size());
    for (int i = 0; i < listx.size(); ++i) {
        sb.append(listx.get(i));
        sb.append(" ");
        sb.append(listy.get(i));
        sb.append(" ");
        sb.append(listw.get(i));
        sb.append("\n");
    }
    psb(sb);
    pw.flush();
    pw.close();
}