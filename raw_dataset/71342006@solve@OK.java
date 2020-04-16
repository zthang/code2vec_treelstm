private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        // Set<Integer> sfSet = new HashSet<>();
        int[] sf = new int[k];
        for (int i = 0; i < k; i++) {
            sf[i] = in.nextInt() - 1;
            sfSet.add(sf[i]);
        }
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        fromSourceSp = new int[n];
        toDestSp = new int[n];
        int originalSp = bfs(g, 0, n - 1);
        fromSourceBfs(g);
        toDestBfs(g);
        TreeMap<Integer, Integer> fromSourceMap = new TreeMap<>();
        TreeMap<Integer, Integer> toDestMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (sfSet.contains(i)) {
                fromSourceMap.put(fromSourceSp[i], fromSourceMap.getOrDefault(fromSourceSp[i], 0) + 1);
                toDestMap.put(toDestSp[i], toDestMap.getOrDefault(toDestSp[i], 0) + 1);
            }
        }
        int newSp = 0;
        for (int i = 0; i < n; i++) {
            if (sfSet.contains(i)) {
                fromSourceMap.put(fromSourceSp[i], fromSourceMap.get(fromSourceSp[i]) - 1);
                if (fromSourceMap.get(fromSourceSp[i]) == 0) {
                    fromSourceMap.remove(fromSourceSp[i]);
                }
                Integer maxPrev = fromSourceMap.floorKey(fromSourceSp[i]);
                if (maxPrev != null) {
                    // if(maxPrev + toDestSp[i] + 1 <= originalSp) {
                    newSp = Math.max(newSp, maxPrev + toDestSp[i] + 1);
                // }
                }
                fromSourceMap.put(fromSourceSp[i], fromSourceMap.getOrDefault(fromSourceSp[i], 0) + 1);
            }
        }
        // for(int i = 0; i < n; i++) {
        // if(sfSet.contains(i)) {
        // toDestMap.put(toDestSp[i], toDestMap.get(toDestSp[i]) - 1);
        // if(toDestMap.get(toDestSp[i]) == 0) {
        // toDestMap.remove(toDestSp[i]);
        // }
        // Integer maxNext = toDestMap.ceilingKey(toDestSp[i]);
        // if(maxNext != null) {
        // //if(maxNext + fromSourceSp[i] + 1 <= originalSp) {
        // newSp = Math.max(newSp, maxNext + fromSourceSp[i] + 1);
        // //}
        // }
        // toDestMap.put(toDestSp[i], toDestMap.getOrDefault(toDestSp[i], 0) + 1);
        // }
        // }
        // out.println(newSp >= 0 ? newSp : originalSp);
        out.println(Math.min(newSp, originalSp));
    }
    out.close();
}