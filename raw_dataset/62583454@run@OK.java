public void run() {
    InputReader sc = new InputReader(System.in);
    // Scanner sc=new Scanner(System.in);
    // Random sc=new Random();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    cost = new long[3][n];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            cost[i][j] = sc.nextInt();
        }
    }
    l = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        l[i] = new ArrayList<>();
    }
    int m = n - 1;
    while (m-- > 0) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        l[u].add(v);
        l[v].add(u);
    }
    int ind = -1;
    for (int i = 0; i < n; i++) {
        if (l[i].size() > 2) {
            out.println(-1);
            out.close();
            return;
        }
        if (l[i].size() < 2) {
            ind = i;
        }
    }
    array = new ArrayList<>();
    dfs(ind, -1);
    if (n == 1) {
        out.println(Math.min(cost[0][array.get(0)], Math.min(cost[1][array.get(0)], cost[2][array.get(0)])));
    } else {
        long min = Long.MAX_VALUE;
        String[] s = new String[] { "012", "021", "102", "120", "210", "201" };
        TreeMap<Integer, Integer> h = new TreeMap<>();
        for (int i = 0; i < s.length; i++) {
            long temp = 0;
            for (int j = 0; j < array.size(); j++) {
                temp += cost[s[i].charAt(j % 3) - '0'][array.get(j)];
            }
            if (min > temp) {
                min = temp;
                h = new TreeMap<>();
                for (int j = 0; j < array.size(); j++) {
                    h.put(array.get(j), s[i].charAt(j % 3) - '0' + 1);
                }
            }
        }
        out.println(min);
        for (int key : h.keySet()) {
            out.print(h.get(key) + " ");
        }
    }
    out.close();
}