    static void solve() {
        int n = in.nextInt();

        ps = new HashMap<>();
        g = new HashSet[n];
        Arrays.setAll(g, i -> new HashSet<>());
        vis = new boolean[n];
        for (int i = 0; i < n - 2; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt() - 1;
            ps.put(new Piece(a + 1, b + 1, c + 1), i);
            g[a].add(b);
            g[a].add(c);
            g[b].add(a);
            g[b].add(c);
            g[c].add(a);
            g[c].add(b);
        }

        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(g[o1].size(), g[o2].size()));
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }

        pFalse = new HashSet[n];
        Arrays.setAll(pFalse, i -> new HashSet<>());
        pTrue = new HashSet[n];
        Arrays.setAll(pTrue, i -> new HashSet<>());
        p = new LinkedList<>();
        q = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int a = pq.poll();
            if (vis[a]) {
                i--;
                continue;
            }
            vis[a] = true;

            Iterator<Integer> it = g[a].iterator();
            int b = it.next();
            int c = it.next();
//            out.println(a + " " + b + " " + c);
//            out.flush();
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
            q.add(ps.get(new Piece(a + 1, b + 1, c + 1)));
            g[b].remove(a);
            g[b].add(c);
            g[c].remove(a);
            g[c].add(b);
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