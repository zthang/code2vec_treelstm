void solve() {
    n = in.nextInt();
    graph = new ArrayList[n];
    used = new boolean[n];
    arr = new pair[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
    }
    long[] one = new long[n];
    long[] two = new long[n];
    long[] three = new long[n];
    for (int i = 0; i < n; i++) one[i] = in.nextInt();
    for (int i = 0; i < n; i++) two[i] = in.nextInt();
    for (int i = 0; i < n; i++) three[i] = in.nextInt();
    for (int i = 0; i < n; i++) {
        arr[i] = new pair(one[i], two[i], three[i]);
    }
    for (int i = 0; i < n - 1; i++) {
        int x = in.nextInt() - 1, y = in.nextInt() - 1;
        graph[x].add(y);
        graph[y].add(x);
    }
    for (int i = 0; i < n; i++) {
        if (graph[i].size() > 2) {
            System.out.println("-1");
            System.exit(0);
        } else if (graph[i].size() == 1) {
            start = i;
        }
    }
    dfs(start);
    long minans = INF, id = 0;
    long check1 = check(1, 2, 3);
    long check2 = check(1, 3, 2);
    long check3 = check(2, 1, 3);
    long check4 = check(2, 3, 1);
    long check5 = check(3, 1, 2);
    long check6 = check(3, 2, 1);
    TreeSet<Long> set = new TreeSet<>();
    set.add(check1);
    set.add(check2);
    set.add(check3);
    set.add(check4);
    set.add(check5);
    set.add(check6);
    long chhek = set.pollFirst();
    if (chhek == check1) {
        anss(1, 2, 3);
    } else if (chhek == check2) {
        anss(1, 3, 2);
    } else if (chhek == check3) {
        anss(2, 1, 3);
    } else if (chhek == check4) {
        anss(2, 3, 1);
    } else if (chhek == check5) {
        anss(3, 1, 2);
    } else if (chhek == check6) {
        anss(3, 2, 1);
    }
}