public void solve(InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] debts = new long[n + 1];
    for (int i = 0; i < m; i++) {
        int f = sc.nextInt();
        int s = sc.nextInt();
        long debt = sc.nextLong();
        debts[f] -= debt;
        debts[s] += debt;
    }
    PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {

        public int compare(Node n1, Node n2) {
            return Long.compare(n1.debt, n2.debt);
        }
    });
    for (int i = 1; i <= n; i++) {
        if (debts[i] < 0)
            pq.add(new Node(i, debts[i]));
    }
    // for(Node nd : pq) out.println(nd);
    ArrayList<Tuples> ans = new ArrayList();
    for (int i = 1; i <= n; i++) {
        if (debts[i] > 0) {
            while (debts[i] > 0) {
                Node top = pq.poll();
                long tmp = Math.min(debts[i], Math.abs(top.debt));
                debts[i] -= tmp;
                top.debt += tmp;
                if (top.debt < 0)
                    pq.add(top);
                ans.add(new Tuples(top.p, i, tmp));
            }
        }
    }
    out.println(ans.size());
    for (Tuples tup : ans) out.println(tup);
}