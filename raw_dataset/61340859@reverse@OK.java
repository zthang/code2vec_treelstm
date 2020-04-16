public static void reverse(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> rgraph) {
    for (int i = 0; i < graph.size(); i++) {
        for (int c : graph.get(i)) {
            rgraph.get(c).add(i);
        }
    }
}