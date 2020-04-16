public void run() throws Exception {
    Map<Integer, BitSet> df = new LinkedHashMap();
    List<Integer> pl = new ArrayList();
    next_t: for (int t = nextInt(); t > 0; t--) {
        int n = nextInt();
        boolean[] pu = new boolean[n];
        df.clear();
        next_d: for (int d = 0; d < n; d++) {
            int k = nextInt();
            pl.clear();
            for (int i = 0; i < k; pl.add(nextInt() - 1), i++) ;
            for (int i = 0; i < k; i++) {
                int p = pl.get(i);
                if (!pu[p]) {
                    pu[p] = true;
                    continue next_d;
                }
            }
            BitSet dp = new BitSet(k);
            for (int i = 0; i < k; dp.set(pl.get(i)), i++) ;
            df.put(d, dp);
        }
        BitSet ps = new BitSet(n);
        for (int i = 0; i < n; i++) {
            if (!pu[i]) {
                ps.set(i);
            }
        }
        for (Map.Entry<Integer, BitSet> me : df.entrySet()) {
            BitSet ds = me.getValue();
            ds.flip(0, n);
            ds.and(ps);
            int fp = ds.nextSetBit(0);
            if (fp >= 0) {
                println("IMPROVE\n" + (me.getKey() + 1) + " " + (fp + 1));
                continue next_t;
            }
        }
        println("OPTIMAL");
    }
}