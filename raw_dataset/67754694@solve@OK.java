static void solve() {
    n = in.nextInt();
    ps = new HashMap<>();
    g = new HashSet[n];
    Arrays.setAll(g, i -> new HashSet<>());
    for (int i = 0; i < n - 2; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        int c = in.nextInt() - 1;
        ps.put(new Trio(a, b, c), i);
        g[a].add(b);
        g[a].add(c);
        g[b].add(a);
        g[b].add(c);
        g[c].add(a);
        g[c].add(b);
    }
    pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.k, o2.k));
    for (int i = 0; i < n; i++) {
        pq.add(new Pair1(i, g[i].size()));
    }
    vis = new boolean[n];
    cant = new HashSet<>();
    can = new ArrayList[n];
    Arrays.setAll(can, i -> new ArrayList<>());
    q = new ArrayList<>();
    for (int i = 0; i < n - 2; i++) {
        int a = pq.poll().a;
        if (vis[a]) {
            i--;
            continue;
        }
        vis[a] = true;
        Iterator<Integer> it = g[a].iterator();
        int b = it.next();
        int c = it.next();
        if (!cant.contains(new Pair(a, b))) {
            unite(a, b);
        }
        if (!cant.contains(new Pair(a, c))) {
            unite(a, c);
        }
        q.add(ps.get(new Trio(a, b, c)));
        cant.add(new Pair(b, c));
        g[b].remove(a);
        g[c].remove(a);
        pq.add(new Pair1(b, g[b].size()));
        pq.add(new Pair1(c, g[c].size()));
    }
    p = new LinkedList<>();
    int a = 0;
    Arrays.fill(vis, false);
    vis[a] = true;
    p.addLast(a);
    while (true) {
        boolean br = false;
        for (int b : can[a]) {
            if (!vis[b]) {
                a = b;
                vis[a] = true;
                p.addLast(a);
                br = true;
                break;
            }
        }
        if (!br)
            break;
    }
    a = 0;
    while (true) {
        boolean br = false;
        for (int b : can[a]) {
            if (!vis[b]) {
                a = b;
                vis[a] = true;
                p.addFirst(a);
                br = true;
                break;
            }
        }
        if (!br)
            break;
    }
    for (int b : p) {
        out.print((b + 1) + " ");
    }
    out.println();
    for (int b : q) {
        out.print((b + 1) + " ");
    }
    out.println();
}