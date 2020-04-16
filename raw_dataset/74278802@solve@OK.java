static String solve(int[][] g) {
    int n = g.length;
    boolean[] daughters = new boolean[n];
    boolean[] princes = new boolean[n];
    for (int i = 0; i < g.length; ++i) {
        for (int p : g[i]) {
            if (!princes[p - 1]) {
                daughters[i] = true;
                princes[p - 1] = true;
                break;
            }
        }
    }
    OptionalInt unmatchedDaughter = IntStream.range(0, n).filter(i -> !daughters[i]).findAny();
    if (!unmatchedDaughter.isPresent()) {
        return "OPTIMAL";
    }
    int unmatchedPrince = IntStream.range(0, n).filter(i -> !princes[i]).findAny().getAsInt();
    return String.format("IMPROVE\n%d %d", unmatchedDaughter.getAsInt() + 1, unmatchedPrince + 1);
}