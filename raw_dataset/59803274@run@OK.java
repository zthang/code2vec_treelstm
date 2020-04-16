public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.ni();
        int m = in.ni();
        PriorityQueue<triplet> pq = new PriorityQueue<>();
        par = new int[n + 1];
        size = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int u = in.ni();
            int v = in.ni();
            int x = in.ni();
            pq.add(new triplet(u, v, x));
        }
        for (int i = 1; i <= n; i++) makeset(i);
        HashMap<Integer, Long> hm = new HashMap<>();
        for (int i = 1; i <= 200000; i++) {
            while (!pq.isEmpty()) {
                triplet t = pq.peek();
                if (t.t > i)
                    break;
                t = pq.remove();
                union(t.f, t.s);
            }
            hm.put(i, ans);
        }
        while (m-- != 0) {
            int x = in.ni();
            out.print(hm.get(x) + " ");
        }
        out.close();
    } catch (Exception e) {
        return;
    }
}