    public static void doTask(){
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] g = new int[n][n];
        for (int i=0; i<m; i++) {
            int u = sc.nextInt()-1, v = sc.nextInt()-1;
            g[u][v] = g[v][u] = 1;
        }

        int[] cnt = new int[n];
        int total = 21;
        int res = 0;

        int[] bfs = new int[n];
        int[] level = new int[n];
        int[] number = new int[n];


        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                cnt[i] += g[i][j];
            }
        }

        SortedMap<Integer, Integer> a = new TreeMap<>();
        a.put(5, 1);
        a.put(4, 1);
        a.put(3, 1);
        a.put(2, 1);
        a.put(1, 7);

        Arrays.sort(cnt);
        for (int i=n-1; i>=0 && a.keySet().size() > 0; i--) {
            Integer maxKey = a.lastKey();
            int maxValue = a.get(maxKey);

            int add =  Math.min(cnt[i], maxKey);
            res += add;
            if (maxValue - 1 == 0) {
                a.remove(maxKey);
            }

            int diff = maxKey - add;
            if (diff > 0) {
                int v = a.get(diff);
                a.put(diff, v+1);
            }
        }
        out.println(res);
    }