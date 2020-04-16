        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            Map<Integer, List<Integer>> g = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1;
                int w = in.nextInt() - 1;
                if (u < w)
                    g.computeIfAbsent(w, k -> new LinkedList<>()).add(u);
                else
                    g.computeIfAbsent(u, k -> new LinkedList<>()).add(w);

            }

            DSUSizeAware dsu = new DSUSizeAware(n);
            Set<Integer> components = new HashSet<>();

            for (int u = 0; u < n; u++) {
                dsu.put(u);
                List<Integer> edges = g.getOrDefault(u, new LinkedList<>());
                Map<Integer, Integer> compCnt = new HashMap<>();

                for (Integer w : edges) {
                    int c = dsu.get(w);
                    if (c < u) {
                        Integer cnt = compCnt.getOrDefault(c, 0);
                        compCnt.put(c, cnt + 1);
                    }
                }

                Set<Integer> deleted = new HashSet<>();

                for (Integer c : components) {
                    Integer cnt = compCnt.getOrDefault(c, 0);
                    int compSize = dsu.size(c);

                    if (compSize > cnt) {
                        dsu.make(c, u);
                        deleted.add(c);
                        components.remove(c);
                    }
                }

                components.removeAll(deleted);
                components.add(dsu.get(u));
            }

            out.println(components.size() - 1);
        }