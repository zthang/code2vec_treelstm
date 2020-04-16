        public void solve(int testNumber, InputReader in, PrintWriter out) {
            ArrayList<Integer> primes = new ArrayList<>();
            MathUtils.getPrimes(primes, 1000);
            int cnt = 0;
            for (int j : primes) {
                map.put(j, cnt++);
            }
            int N = in.nextInt();
            int[][] edge = new int[N][2];
            for (int i = 0; i < N; i++) {
                int a = in.nextInt();
                if (seen.contains(a)) {
                    two = true;
                } else {
                    seen.add(a);
                }
                ArrayList<Integer> div = new ArrayList<>();
                for (int j : primes) {
                    if (a == 1) {
                        break;
                    }
                    if (a % j == 0) {
                        int tot = 0;
                        while (a % j == 0) {
                            a /= j;
                            tot++;
                        }
                        if (tot % 2 == 1) {
                            div.add(j);
                        }
                    }
                }
                if (a > 1) {
                    div.add(a);
                    map.put(a, cnt++);
                }
                if (div.size() == 0) {
                    out.println(1);
                    return;
                }
                if (div.size() > 1) {
                    edge[i] = new int[]{div.get(0), div.get(1)};
                } else {
                    edge[i] = new int[]{-1, -1};
                }
            }
            if (two) {
                out.println(2);
                return;
            }
            graph = new ArrayList[cnt];
            for (int i = 0; i < cnt; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                graph[edge[i][0]].add(new Edge(edge[i][1], i));
                graph[edge[i][1]].add(new Edge(edge[i][0], i));
            }
            out.println(shortest_cycle(cnt));
        }