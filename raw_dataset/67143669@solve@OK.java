public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    long[] debt = new long[n + 1];
    for (int i = 0; i < m; i++) {
        int u = in.scanInt();
        int v = in.scanInt();
        int d = in.scanInt();
        debt[u] += d;
        debt[v] -= d;
    }
    ArrayList<pair> arrayList = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        arrayList.add(new pair(i, debt[i]));
    }
    Collections.sort(arrayList, new Comparator<pair>() {

        public int compare(pair o1, pair o2) {
            return Long.compare(o1.debt, o2.debt);
        }
    });
    int p1 = 0;
    int p2 = arrayList.size() - 1;
    ArrayList<edge> ans = new ArrayList<>();
    while (p1 < p2) {
        if (arrayList.get(p1).debt == 0)
            break;
        if (arrayList.get(p2).debt == 0)
            break;
        if (-arrayList.get(p1).debt > arrayList.get(p2).debt) {
            ans.add(new edge(arrayList.get(p2).index, arrayList.get(p1).index, arrayList.get(p2).debt));
            arrayList.get(p1).debt += arrayList.get(p2).debt;
            arrayList.get(p2).debt = 0;
            p2--;
        } else if (-arrayList.get(p1).debt < arrayList.get(p2).debt) {
            ans.add(new edge(arrayList.get(p2).index, arrayList.get(p1).index, -arrayList.get(p1).debt));
            arrayList.get(p2).debt += arrayList.get(p1).debt;
            arrayList.get(p1).debt = 0;
            p1++;
        } else {
            ans.add(new edge(arrayList.get(p2).index, arrayList.get(p1).index, -arrayList.get(p1).debt));
            arrayList.get(p2).debt = 0;
            arrayList.get(p1).debt = 0;
            p1++;
            p2--;
        }
    }
    out.println(ans.size());
    for (edge e : ans) {
        out.println((e.a) + " " + (e.b) + " " + e.cost);
    }
}