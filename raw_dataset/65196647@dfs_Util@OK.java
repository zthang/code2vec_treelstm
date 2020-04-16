public static long dfs_Util() {
    int n = adj.length;
    PriorityQueue<Integer> helper = new PriorityQueue<>();
    boolean[] visited = new boolean[n];
    long count = 0;
    for (int i = 0; i < n; i++) {
        if (!visited[i] && helper.size() == 0) {
            dfs(i, visited, helper);
        } else if (helper.size() != 0) {
            int min = helper.poll() + 1;
            while (helper.size() != 0) {
                int nextmin = helper.poll();
                if (min == nextmin) {
                    min++;
                } else {
                    dfs(min, visited, helper);
                    helper.add(nextmin);
                    count++;
                }
            }
            i--;
        }
    }
    return count;
}