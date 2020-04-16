        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            dist = new long[n][n];
            a = new int[m];
            b = new int[m];
            c = new int[m];
            AUtils.deepFill(dist, 1L << 40);
            for (int i = 0; i < n; i++) dist[i][i] = 0;
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt() - 1;
                b[i] = in.nextInt() - 1;
                c[i] = in.nextInt();
                dist[a[i]][b[i]] = c[i];
            }
            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

            List<MaxFlowLong.Edge>[] graph = LUtils.genArrayList(n);
            long[] g = new long[n];
            for (int i = 0; i < m; i++) {
                g[i] = dist[0][a[i]] + c[i] + dist[b[i]][n - 1];
                MaxFlowLong.addEdge(graph, a[i], b[i], (1L << 40) + g[i]);
            }
            Set<Integer> x = MaxFlowLong.minCut(graph, 0, n - 1);

            long[] times = new long[n];
            int idx = 0;
            for (int i = 0; i < m; i++) {
                if (x.contains(a[i]) && !x.contains(b[i])) {
                    times[idx++] = g[i];
                }
            }
            times[idx++] = 1L << 60;
            Arrays.sort(times, 0, idx);
            int q = in.nextInt();
            while (q-- > 0) {
                int cap = in.nextInt();
                double ans = times[0];
                for (int i = 1; i < idx; i++) {
                    long need = i * (times[i] - times[i - 1]);
                    if (cap >= need) {
                        cap -= need;
                        ans = times[i];
                    } else {
                        ans += 1.0 * cap / i;
                        break;
                    }
                }
                out.printf("%.10f\n", ans);
            }
        }