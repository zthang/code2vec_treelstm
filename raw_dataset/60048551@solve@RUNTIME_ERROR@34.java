    void solve() throws Exception {
        int i, j, k;

        N = hp.nextInt();
        int[][] ar = new int[N][];
        for (i = 1; i <= N; ++i) ar[i - 1] = new int[] {i * 2 - 1, i * 2, hp.nextInt()};
        Arrays.sort(ar, (a, b) -> -Integer.compare(a[2], b[2]));

        N <<= 1;
        ArrayList<Integer>[] longList = new ArrayList[N + 7];
        for (i = 0; i < longList.length; ++i) longList[i] =  new ArrayList<>();

        graph = new HashSet[N + 1];
        for (i = 1; i <= N; ++i) graph[i] = new HashSet<>();


        k = 1;
        for (int[] edge : ar) {
            longList[k].add(edge[0]);
            if (edge[2] > 1) {
                longList[k + edge[2]].add(edge[1]);
            }
            else {
                graph[edge[1]].add(edge[0]);
                graph[edge[0]].add(edge[1]);
            }
            ++k;
        }

        System.err.println(Arrays.toString(longList));

        for (i = 1; i <= N; ++i) if (!longList[i].isEmpty()) {
            for (int itr : longList[i]) {
                int node = itr % 2 == 1 ? longList[i + 1].get(0) : longList[i - 1].get(0);
                graph[itr].add(node);
                graph[node].add(itr);
            }
        }

        System.err.println(Arrays.toString(graph));

        for (i = 1; i <= N; ++i) for (int itr : graph[i]) if (i < itr) {
            hp.println(i + " " + itr);
        }

        hp.flush();
    }