public static void fill(ArrayList<Integer>[] road, int curr, int end, boolean[] visited) {
    visited[curr] = true;
    ArrayList<Integer> friends = road[curr];
    for (int i = 0; i < friends.size(); i++) {
        int temp = friends.get(i);
        boolean[] seen = new boolean[visited.length];
        seen[curr] = true;
        isPossible(road, temp, end, seen);
        if (seen[end]) {
            // System.out.println(temp+"x");
            for (int j = 1; j < visited.length; j++) {
                if (seen[j]) {
                    visited[j] = true;
                }
            }
        }
    }
}