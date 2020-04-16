private static int[] cost(List<List<Integer>> neighbors, int st) {
    int[] out = new int[N];
    Arrays.fill(out, Integer.MAX_VALUE);
    List<Integer> front = new ArrayList<>();
    front.add(st);
    out[st] = 0;
    while (front.size() > 0) {
        List<Integer> nf = new ArrayList<>();
        for (int v : front) {
            for (int nv : neighbors.get(v)) {
                int nc = out[v] + 1;
                if (nc < out[nv]) {
                    out[nv] = nc;
                    nf.add(nv);
                }
            }
        }
        front = nf;
    }
    return out;
}