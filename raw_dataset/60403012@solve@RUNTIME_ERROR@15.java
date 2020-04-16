        public void solve(int x, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<String, Boolean> colMp = new LinkedHashMap<>();
            Map<Integer, List<Integer>> mp = new HashMap<>();
            Map<Integer, Integer> col = new HashMap<>();
            for (int i = 1; i <= m; i++) {
                col.put(i, 0);
                mp.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                colMp.put(u+"-"+v, Boolean.FALSE);
                mp.get(u).add(v);
            }

            int cyc = 1;
            for (int i : mp.keySet()) {
                if (col.get(i) == 0) {
                    if (dfs(i, mp, col, colMp)) {
                        cyc = 2;
                    }
                }
            }
            out.println(cyc);
            for (String s : colMp.keySet()) {
                out.print((colMp.get(s) ? 2 : 1) + " ");
            }

        }