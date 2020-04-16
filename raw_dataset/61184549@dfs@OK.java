public static void dfs(int parent, boolean[] visited, int[] dp) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr = graph.get(parent);
    visited[parent] = true;
    for (int i = 0; i < arr.size(); i++) {
        int num = (int) arr.get(i);
        if (visited[num] == false) {
            dfs(num, visited, dp);
        }
        dp[parent] = Math.max(dp[num] + 1, dp[parent]);
    }
}