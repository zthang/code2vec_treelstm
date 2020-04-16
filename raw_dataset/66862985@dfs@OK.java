public static void dfs(ArrayList<Integer>[] road, Integer start, boolean[] visited) {
    visited[start] = true;
    ArrayList<Integer> friends = road[start];
    for (int i = 0; i < friends.size(); i++) {
        int temp = friends.get(i);
        if (!visited[temp]) {
            dfs(road, temp, visited);
        }
    }
}