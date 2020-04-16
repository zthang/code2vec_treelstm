ArrayList<ArrayList<Integer>> apply(int[] p) {
    ArrayList<ArrayList<Integer>> cycle = new ArrayList<>();
    boolean[] visited = new boolean[p.length];
    for (int i = 0; i < p.length; i++) {
        if (!visited[i]) {
            cycle.add(new ArrayList<>());
            int cur = i;
            visited[cur] = true;
            cycle.get(cycle.size() - 1).add(cur);
            while (!visited[p[cur]]) {
                cur = p[cur];
                visited[cur] = true;
                cycle.get(cycle.size() - 1).add(cur);
            }
        }
    }
    return cycle;
}