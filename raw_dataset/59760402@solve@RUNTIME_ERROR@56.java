        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 1) {
                for (int i = 0; i < m; i++) {
                    out.print(0 + " ");
                }
                return;
            }
            subsets = new GPathQueries.Subset[n];
            for (int i = 0; i < n; i++) {
                subsets[i] = new GPathQueries.Subset();
                subsets[i].parent = i;
                subsets[i].size = 1;
            }
            GPathQueries.Edge[] edges = new GPathQueries.Edge[n - 1];
            for (int i = 0; i < n - 1; i++) {
                edges[i] = new GPathQueries.Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
            }
            Arrays.sort(edges, Comparator.comparingInt(a -> a.w));
            int start = 0;
            int end = 0;
            long act = 0;
            ArrayList<GPathQueries.Pair> ans = new ArrayList<>();
            while (end < n - 1) {
                while (end < n - 1 && edges[start].w == edges[end].w) {
                    end++;
                }
                end--;
                for (int i = start; i <= end; i++) {
                    int a = find(edges[i].u);
                    int b = find(edges[i].v);
                    act -= ((long) subsets[a].size * (subsets[a].size - 1)) / 2;
                    act -= ((long) subsets[b].size * (subsets[b].size - 1)) / 2;
                    union(edges[i].u, edges[i].v);
                    int l = find(edges[i].u);
                    act += ((long) subsets[l].size * (subsets[l].size - 1)) / 2;
                }
                ans.add(new GPathQueries.Pair(edges[start].w, act));
                start = end + 1;
                end = end + 1;
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int a = Collections.binarySearch(ans, new GPathQueries.Pair(x, Long.MAX_VALUE), new Comparator<GPathQueries.Pair>() {

                    public int compare(GPathQueries.Pair a, GPathQueries.Pair b) {
                        return Integer.compare(a.x, b.x);
                    }
                });
                if (a < 0) {
                    a++;
                    a *= -1;
                    a--;
                }
                out.print(ans.get(a).y + " ");
            }
        }