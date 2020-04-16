public static void solve(FastScanner fs) {
    int n = fs.nextInt();
    int m = fs.nextInt();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) nodes[i] = new Node(i);
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int a = fs.nextInt() - 1, b = fs.nextInt() - 1, c = fs.nextInt();
        edges.add(new Edge(a, b, c));
        nodes[a].finalDelta -= c;
        nodes[b].finalDelta += c;
    }
    ArrayList<Edge> used = new ArrayList<>();
    ArrayList<Node> needMoney = new ArrayList<>();
    ArrayList<Node> needDebt = new ArrayList<>();
    for (Node nn : nodes) {
        if (nn.finalDelta > 0) {
            needMoney.add(nn);
        } else if (nn.finalDelta < 0) {
            needDebt.add(nn);
        }
    }
    int needMoneyIndex = 0, needDebtIndex = 0;
    while (needMoneyIndex < needMoney.size()) {
        Node mon = needMoney.get(needMoneyIndex);
        Node deb = needDebt.get(needDebtIndex);
        long toGive = Math.min(mon.finalDelta, -deb.finalDelta);
        used.add(new Edge(deb.index, mon.index, toGive));
        mon.finalDelta -= toGive;
        deb.finalDelta += toGive;
        if (mon.finalDelta == 0)
            needMoneyIndex++;
        if (deb.finalDelta == 0)
            needDebtIndex++;
    }
    System.out.println(used.size());
    for (Edge e : used) {
        System.out.println((e.from + 1) + " " + (1 + e.to) + " " + e.value);
    }
}