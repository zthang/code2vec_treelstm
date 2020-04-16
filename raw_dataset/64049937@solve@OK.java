public void solve(int testNumber, Scanner sc, PrintWriter pw) {
    int n = sc.nextInt() + 1;
    DShichikujiAndPowerGrid.pair[] arr = new DShichikujiAndPowerGrid.pair[n];
    for (int i = 1; i < n; i++) arr[i] = new DShichikujiAndPowerGrid.pair(sc.nextInt(), sc.nextInt());
    ArrayList<DShichikujiAndPowerGrid.Edge> list = new ArrayList<>();
    int[] c = new int[n], k = new int[n];
    for (int i = 1; i < n; i++) c[i] = sc.nextInt();
    for (int i = 1; i < n; i++) k[i] = sc.nextInt();
    for (int i = 1; i < n; i++) for (int j = i + 1; j < n; j++) {
        list.add(new DShichikujiAndPowerGrid.Edge(i, j, 1l * (k[i] + k[j]) * (Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y))));
    }
    for (int i = 1; i < n; i++) list.add(new DShichikujiAndPowerGrid.Edge(0, i, c[i]));
    edgeList = new DShichikujiAndPowerGrid.Edge[list.size()];
    for (int i = 0; i < edgeList.length; i++) edgeList[i] = list.get(i);
    V = n;
    build = new ArrayList<>();
    connect = new ArrayList<>();
    pw.println(kruskal());
    pw.println(build.size());
    Collections.sort(build);
    for (int x : build) pw.print(x + " ");
    pw.println();
    pw.println(connect.size());
    for (DShichikujiAndPowerGrid.pair p : connect) pw.println(p.x + " " + p.y);
}