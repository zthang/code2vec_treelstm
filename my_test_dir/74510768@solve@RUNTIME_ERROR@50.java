    public static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int i = 0; i < n-1; ++i) {
            int from = in.nextInt();
            int to = in.nextInt();
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                List<Integer> v = new ArrayList<>();
                v.add(to);
                graph.put(from, v);
            }
            if (graph.containsKey(to)) {
                graph.get(to).add(from);
            } else {
                List<Integer> v = new ArrayList<>();
                v.add(to);
                graph.put(to, v);
            }
        }
        Map<Integer, Integer> heights = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        heights.put(1, 1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        Map<Integer, Integer> parents = new HashMap<>(n);
        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            visited.add(v);
            Integer h = heights.get(v);
            for (Integer to : graph.get(v)) {
                if (visited.contains(to)) continue;
                heights.put(to, h+1);
                parents.put(to, v);
                queue.add(to);
            }
        }
        for (int i = 0; i < m; ++i) {
            int k = in.nextInt();
            Set<Integer> v = new HashSet<>(k);
            int maxHeight = 0;
            Integer current = -1;
            for (int j = 0; j < k; ++j) {
                int vi = in.nextInt();
                v.add(vi);
                Integer h = heights.get(vi);
                if (h > maxHeight) {
                    maxHeight = h;
                    current = vi;
                }
            }
            while (current != null && !v.isEmpty()) {
                v.removeAll(graph.get(current));
                v.remove(current);
                current = parents.get(current);
            }
            out.println(v.isEmpty() ? "YES" : "NO");
        }
    }