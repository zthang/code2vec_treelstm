        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextLine().toCharArray();
            }

            long Q = longRandomPrime();
            long base = 251;
            long[] val = new long[30];
            val[0] = 1;
            for (int i = 1; i < 30; i++) {
                val[i] = (val[i - 1] * base) % Q;
            }

            long ans = 0;
            for (int col1 = 0; col1 < m; col1++) {
                long[] hash = new long[n];
                boolean[] ok = new boolean[n];
                int[][] cnt = new int[n][30];
                int[] odds = new int[n];
                for (int col2 = col1; col2 < m; col2++) {
                    Arrays.fill(ok, true);
                    for (int row = 0; row < n; row++) {
                        int c = map[row][col2] - 'a';
                        hash[row] = (hash[row] + val[c]) % Q;
                        cnt[row][c]++;
                        if (cnt[row][c] % 2 == 1) odds[row]++;
                        else odds[row]--;
                        if (odds[row] > 1)
                            ok[row] = false;
                    }
                    int[] d1 = manacher(hash, ok, false);
                    int[] d2 = manacher(hash, ok, true);

                    for (int i = 0; i < n; i++) {
                        if (ok[i] == true) {
                            ans += d1[i];
                            ans += d2[i];
                        }
                    }
                }
            }
            out.println(ans);
        }