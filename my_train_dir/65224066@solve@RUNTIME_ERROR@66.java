        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt(), k = in.nextInt(), q = in.nextInt();
            List<TaskF.Edge>[] edges = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
            queries = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
            descendants = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
            size = new int[n];
            node = new int[n];
            for (int i = 0; i < n; i++) {
                descendants[i].add(i);
                node[i] = i;
            }
            Arrays.fill(size, 1);
            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1, w = in.nextInt();
                edges[u].add(new TaskF.Edge(v, w));
                edges[v].add(new TaskF.Edge(u, w));
            }
            int[] a = new int[q], b = new int[q];
            answers = new long[q];
            for (int i = 0; i < q; i++) {
                a[i] = in.nextInt() - 1;
                b[i] = in.nextInt() - 1;
                queries[a[i]].add(new TaskF.Edge(b[i], i));
                queries[b[i]].add(new TaskF.Edge(a[i], i));
            }

            long[] dist = new long[n];
            int[] pred = new int[n];
            Arrays.fill(pred, -1);
            Arrays.fill(dist, Long.MAX_VALUE);
            long[] t = new long[edges.length * 2];
            Arrays.fill(t, Long.MAX_VALUE);
            boolean[] over = new boolean[n];
            for (int i = 0; i < k; i++) {
                dist[i] = 0;
                set(t, i, 0);
                pred[i] = i;
                over[i] = true;
            }

            ArrayList<Pair> E = new ArrayList<>();
            while (true) {
                int cur = minIndex(t);
                assert (!over[cur]);
                over[cur] = true;
                if (t[cur + t.length / 2] == Long.MAX_VALUE) {
                    break;
                }
                set(t, cur, Long.MAX_VALUE);
                for (TaskF.Edge e : edges[cur]) {
                    int v = e.t;
                    long ndist = dist[cur] + e.cost;
                    if (dist[v] > ndist) {
                        dist[v] = ndist;
                        pred[v] = pred[cur];
                        set(t, v, ndist);
                    } else if (over[v]) {
                        int x = pred[v], y = pred[cur];
                        long key = ((long) x << 32) + y;
                        long d = dist[v] + dist[cur] + e.cost;

                        E.add(new Pair(d, key));
                    }
                }
            }
            Collections.sort(E, new TaskF.PairComparator());
            for (Pair P : E) {
                long val = P.a, key = P.b;
                int x = (int) (key >>> 32);
                int y = (int) key;
                unite(x, y, val);
            }
            for (int i = 0; i < q; i++) out.println(answers[i]);
        }