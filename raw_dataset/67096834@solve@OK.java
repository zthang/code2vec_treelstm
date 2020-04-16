public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    Pair[] p = new Pair[n];
    for (int i = 0; i < n; ++i) p[i] = new Pair(i + 1);
    for (int i = 0; i < m; ++i) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        long val = sc.nextLong();
        p[u - 1].val += val;
        p[v - 1].val -= val;
    }
    PriorityQueue<Pair> outQueue = new PriorityQueue<>(new Comparator<Pair>() {

        public int compare(Pair o1, Pair o2) {
            if (o1.val < o2.val)
                return 1;
            if (o1.val > o2.val)
                return -1;
            return 0;
        }
    });
    PriorityQueue<Pair> inQueue = new PriorityQueue<>(new Comparator<Pair>() {

        public int compare(Pair o1, Pair o2) {
            if (o1.val < o2.val)
                return 1;
            if (o1.val > o2.val)
                return -1;
            return 0;
        }
    });
    for (int i = 0; i < n; ++i) {
        if (p[i].val < 0) {
            p[i].val *= -1;
            inQueue.add(p[i]);
        } else if (p[i].val > 0)
            outQueue.add(p[i]);
    }
    ArrayList<Edge> list = new ArrayList<Edge>();
    while (!inQueue.isEmpty()) {
        Pair curPO = outQueue.poll();
        Pair curPI = inQueue.poll();
        if (curPO.val == curPI.val) {
            list.add(new Edge(curPO.ind, curPI.ind, curPO.val));
        } else if (curPO.val > curPI.val) {
            list.add(new Edge(curPO.ind, curPI.ind, curPI.val));
            curPO.val -= curPI.val;
            outQueue.add(curPO);
        } else {
            list.add(new Edge(curPO.ind, curPI.ind, curPO.val));
            curPI.val -= curPO.val;
            inQueue.add(curPI);
        }
    }
    out.println(list.size());
    for (Edge curE : list) {
        out.println(curE.u + " " + curE.v + " " + curE.d);
    }
}