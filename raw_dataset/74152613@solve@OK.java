void solve() {
    int Q = ni();
    for (int q = 1; q <= Q; q++) {
        int N = ni();
        Integer princess = null;
        Set<Integer> prince = new HashSet<Integer>();
        for (int i = 1; i <= N; i++) prince.add(i);
        inner: for (int i = 1; i <= N; i++) {
            int n = ni();
            int[] a = na(n);
            for (int j : a) {
                if (prince.remove(j))
                    continue inner;
            }
            princess = i;
        }
        if (princess == null)
            out.println("OPTIMAL");
        else {
            out.println("IMPROVE");
            out.println(princess + " " + prince.iterator().next());
        }
    }
}