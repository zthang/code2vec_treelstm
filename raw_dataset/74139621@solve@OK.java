void solve() throws IOException {
    int T = readInt();
    boolean flag = false;
    for (int Ti = 0; Ti < T; Ti++) {
        int n = readInt();
        int[] p = readIntLine();
        for (int i = 0; i < p.length; i++) p[i]--;
        int[] c = readIntLine();
        List<List<Integer>> cycles = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int src = 0; src < n; src++) {
            if (!visited[src]) {
                List<Integer> cycle = new ArrayList<>();
                visited[src] = true;
                cycle.add(c[src]);
                int j = p[src];
                while (j != src) {
                    visited[j] = true;
                    cycle.add(c[j]);
                    j = p[j];
                }
                cycles.add(cycle);
            }
        }
        int best = Integer.MAX_VALUE;
        for (List<Integer> cycle : cycles) {
            List<Integer> factors = factors(cycle.size());
            Collections.sort(factors);
            for (int f : factors) {
                boolean good = false;
                for (int i = 0; i < f; i++) {
                    good = true;
                    for (int j = i; good && j < cycle.size(); j += f) {
                        if (!cycle.get(j).equals(cycle.get(i)))
                            good = false;
                    }
                    if (good) {
                        best = Math.min(best, f);
                        break;
                    }
                }
                if (good)
                    break;
            }
        }
        pw.println(best);
    }
}