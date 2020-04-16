void doIt() {
    int n = sc.nextInt();
    link = new ArrayList[n];
    for (int i = 0; i < n; i++) link[i] = new ArrayList<>();
    int[][] c = new int[n][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            c[j][i] = sc.nextInt();
        }
    }
    for (int i = 1; i < n; i++) {
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        link[a].add(b);
        link[b].add(a);
    }
    int par = -1, cur = 0;
    for (int i = 0; i < n; i++) {
        if (link[i].size() > 2) {
            System.out.println(-1);
            return;
        } else if (link[i].size() == 1) {
            cur = i;
        }
    }
    Map<Integer, Integer> color = new HashMap<Integer, Integer>();
    int cc = 0;
    do {
        color.put(cur, cc);
        int befPar = par;
        for (int i : link[cur]) {
            if (i != befPar) {
                par = cur;
                cur = i;
            }
        }
        cc = (cc + 1) % 3;
    } while (link[cur].size() > 1);
    color.put(cur, cc);
    /*for(int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(color[i].toArray()));
		}*/
    long[][] cost = new long[3][3];
    for (int i = 0; i < 3; i++) Arrays.fill(cost[i], 0);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
            cost[color.get(i)][j] += c[i][j];
        }
    }
    Map<Integer, Integer> colorMap = minCost(cost);
    for (int i = 0; i < n; i++) {
        System.out.print(colorMap.get(color.get(i)) + 1 + " ");
    }
    System.out.println();
}