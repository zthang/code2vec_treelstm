static void solve() {
    int n = in.nextInt();
    Seg[] segs = new Seg[n];
    for (int i = 0; i < n; i++) {
        int l = in.nextInt();
        int r = in.nextInt();
        segs[i] = new Seg(l, r, i);
    }
    Arrays.sort(segs, (o1, o2) -> Integer.compare(o1.l, o2.l));
    DSU dsu = new DSU(n);
    PriorityQueue<Seg> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.r, o2.r));
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        Seg s = segs[i];
        while (!q.isEmpty() && q.peek().r < s.l) {
            q.poll();
        }
        Stack<Seg> temp = new Stack<>();
        while (!q.isEmpty() && q.peek().r < s.r) {
            Seg s1 = q.poll();
            dsu.uniteSets(s1.i, s.i);
            cnt++;
            temp.add(s1);
        }
        while (!temp.empty()) {
            q.add(temp.pop());
        }
        if (cnt > n - 1)
            break;
        q.add(s);
    }
    if (cnt == n - 1) {
        for (int i = 0; i < n; i++) {
            if (dsu.size[dsu.findSet(i)] != n) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    } else {
        out.println("NO");
    }
}