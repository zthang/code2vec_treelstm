static void solve() throws IOException {
    int t = nextInt(), n, m, min, pair;
    long cost;
    Pair[] fridges, pairs;
    while (t-- > 0) {
        cost = 0;
        pair = 0;
        fridges = new Pair[nextInt()];
        m = nextInt();
        pairs = new Pair[m];
        if (fridges.length > pairs.length || fridges.length == 2) {
            out.println(-1);
            nextLine();
            continue;
        }
        for (int i = 0; i < fridges.length; i++) fridges[i] = new Pair(nextInt(), i + 1);
        Arrays.sort(fridges);
        int i;
        for (i = 0; i < fridges.length - 1; i++) {
            fridges[i].visited = fridges[i + 1].visited = true;
            pairs[i] = new Pair(fridges[i].num, fridges[i + 1].num);
            pair++;
            cost += fridges[i].cost + fridges[i + 1].cost;
        }
        pairs[i++] = new Pair(fridges[fridges.length - 1].num, fridges[0].num);
        cost += fridges[0].cost + fridges[fridges.length - 1].cost;
        pair++;
        while (pair < pairs.length) {
            pairs[pair++] = new Pair(fridges[0].num, fridges[1].num);
            cost += fridges[0].cost + fridges[1].cost;
        }
        out.println(cost);
        for (int x = 0; x < m; x++) {
            out.println(pairs[x]);
        }
    }
}