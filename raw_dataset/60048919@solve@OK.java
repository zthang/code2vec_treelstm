void solve() throws Exception {
    int i, j, k;
    N = hp.nextInt();
    int[][] ar = new int[N][];
    for (i = 1; i <= N; ++i) ar[i - 1] = new int[] { i * 2 - 1, i * 2, hp.nextInt() };
    Arrays.sort(ar, (a, b) -> -Integer.compare(a[2], b[2]));
    N <<= 1;
    ArrayList<Integer>[] longList = new ArrayList[N + 7];
    for (i = 0; i < longList.length; ++i) longList[i] = new ArrayList<>();
    graph = new HashSet[N + 1];
    for (i = 1; i <= N; ++i) graph[i] = new HashSet<>();
    k = 1;
    for (int[] edge : ar) {
        longList[k].add(edge[0]);
        if (edge[2] > 1) {
            longList[k + edge[2]].add(edge[1]);
        } else {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        ++k;
    }
    System.err.println(Arrays.toString(longList));
    for (i = 1; i <= N; ++i) {
        if (!longList[i].isEmpty() && (!longList[i - 1].isEmpty() || !longList[i + 1].isEmpty())) {
            for (int itr : longList[i]) {
                int node;
                if (longList[i - 1].isEmpty())
                    node = longList[i + 1].get(0);
                else if (longList[i + 1].isEmpty())
                    node = longList[i - 1].get(0);
                else if (itr % 2 == 1)
                    node = longList[i + 1].get(0);
                else
                    node = longList[i - 1].get(0);
                graph[itr].add(node);
                graph[node].add(itr);
            }
        }
    }
    for (i = 1; i <= N; ++i) if (!longList[i].isEmpty() && !longList[i + 1].isEmpty()) {
        graph[longList[i].get(0)].add(longList[i + 1].get(0));
        graph[longList[i + 1].get(0)].add(longList[i].get(0));
    }
    System.err.println(Arrays.toString(graph));
    int c = 0;
    for (i = 1; i <= N; ++i) for (int itr : graph[i]) if (i < itr) {
        hp.println(i + " " + itr);
        ++c;
    }
    if (c != N - 1)
        System.exit(7 / 0);
    hp.flush();
}