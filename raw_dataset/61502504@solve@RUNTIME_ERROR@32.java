        public void solve(int testNumber, ScanReader in, PrintWriter out) {

            int n = in.scanInt();
            int m = in.scanInt();

            g = new HashSet[n + 1];

            int ee[][] = new int[m][2];
            for (int i = 1; i <= n; i++) g[i] = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int a = in.scanInt();
                int b = in.scanInt();
                g[a].add(b);
                g[b].add(a);
                ee[i] = new int[]{a, b};
            }


            int ans[] = new int[n + 1];
            Arrays.fill(ans, -1);
            for (int k : g[1]) ans[k] = 4;
            for (int i = 1; i <= n; i++) if (ans[i] == -1) ans[i] = 1;
            int index = -1;
            for (int i = 1; i <= n; i++) {
                if (ans[i] == 4) {
                    ans[i] = 2;
                    index = i;
                    break;
                }
            }

            for (int k : g[index]) if (ans[k] == 4) ans[k] = 3;
            for (int i = 1; i <= n; i++) if (ans[i] == 4) ans[i] = 2;


            boolean check = true;
            for (int i = 1; i <= n; i++) {
                if (ans[i] == -1) check = false;
                if (ans[i] == 4) check = false;


                if (ans[i] == 1 || ans[i] == 2 || ans[i] == 3) {

                } else {
                    check = false;
                }
            }


            int o1 = 0;
            int o2 = 0;
            int o3 = 0;

            for (int i = 1; i <= n; i++) {
                if (ans[i] == 1) o1++;
                else if (ans[i] == 2) o2++;
                else if (ans[i] == 3) o3++;
            }

            if (o1 == 0 || o2 == 0 || o3 == 0) check = false;

            for (int i = 0; i < m; i++) if (ans[ee[i][0]] == ans[ee[i][1]]) check = false;


            if (check) {
                for (int i = 1; i <= n; i++) {
                    out.print(ans[i] + " ");
                }
            } else {
                out.println(-1);
            }


        }