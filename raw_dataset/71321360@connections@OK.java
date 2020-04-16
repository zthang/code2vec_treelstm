public static ArrayList<ArrayList<Integer>> connections(int[][] edges, int vertices) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
        result.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        result.get(edge[0]).add(edge[1]);
        result.get(edge[1]).add(edge[0]);
    }
    return result;
}