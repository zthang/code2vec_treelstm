public static void isPossible(ArrayList<Integer>[] road, int curr, int end, boolean[] visited) {
    visited[curr] = true;
    if (curr == end) {
        return;
    }
    ArrayList<Integer> friends = road[curr];
    for (int i = 0; i < friends.size(); i++) {
        int temp = friends.get(i);
        if (!visited[temp]) {
            isPossible(road, temp, end, visited);
        }
    }
}