    static void solve() {
        int n = in.nextInt();

        ps = new TreeMap<>((o1, o2) -> {
            if (o1.a == o2.a) {
                if (o1.b == o2.b) {
                    return Integer.compare(o1.c, o2.c);
                }
                return Integer.compare(o1.b, o2.b);
            }
            return Integer.compare(o1.a, o2.a);
        });
        g = new TreeMap[n];
        Arrays.setAll(g, i -> new TreeMap<>());
        vis = new boolean[n];
        for (int i = 0; i < n - 2; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt() - 1;
            ps.put(new Piece(a, b, c), i);
            g[a].putIfAbsent(b, 0);
            g[a].put(b, g[a].get(b) + 1);
            g[a].putIfAbsent(c, 0);
            g[a].put(c, g[a].get(c) + 1);
            g[b].putIfAbsent(a, 0);
            g[b].put(a, g[b].get(a) + 1);
            g[b].putIfAbsent(c, 0);
            g[b].put(c, g[b].get(c) + 1);
            g[c].putIfAbsent(a, 0);
            g[c].put(a, g[c].get(a) + 1);
            g[c].putIfAbsent(b, 0);
            g[c].put(b, g[c].get(b) + 1);
        }

        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(g[o1].size(), g[o2].size()));
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }

        pFalse = new TreeSet[n];
        Arrays.setAll(pFalse, i -> new TreeSet<>());
        pTrue = new TreeSet[n];
        Arrays.setAll(pTrue, i -> new TreeSet<>());
        p = new LinkedList<>();
        q = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int a = pq.poll();
            if (vis[a]) {
                i--;
                continue;
            }
            vis[a] = true;

            int[] bc = new int[2];
            int ind = 0;
            for (Map.Entry<Integer, Integer> e : g[a].entrySet()) {
                bc[ind++] = e.getKey();
            }
            int b = bc[0];
            int c = bc[1];
            if (!pFalse[a].contains(b)) {
                pTrue[a].add(b);
                pTrue[b].add(a);
            }
            if (!pFalse[a].contains(c)) {
                pTrue[a].add(c);
                pTrue[c].add(a);
            }
            pFalse[b].add(c);
            pFalse[c].add(b);
            q.add(ps.get(new Piece(a, b, c)));
            g[b].remove(a);
            g[b].put(c, g[b].get(c) - 1);
            if (g[b].get(c) == 0) g[b].remove(c);
            g[c].remove(a);
            g[c].put(b, g[c].get(b) - 1);
            if (g[c].get(b) == 0) g[c].remove(b);
            pq.add(b);
            pq.add(c);
        }

        Arrays.fill(vis, false);
        int a = 0;
        vis[a] = true;
        p.addLast(a);
        while (true) {
            boolean br = false;
            for (int b : pTrue[a]) {
                if (!vis[b]) {
                    vis[b] = true;
                    p.addLast(b);
                    a = b;
                    br = true;
                    break;
                }
            }
            if (!br) break;
        }
        a = 0;
        while (true) {
            boolean br = false;
            for (int b : pTrue[a]) {
                if (!vis[b]) {
                    vis[b] = true;
                    p.addFirst(b);
                    a = b;
                    br = true;
                    break;
                }
            }
            if (!br) break;
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