public static int countComponents(HashMap<String, ArrayList<String>> graph) {
    int count = 0;
    HashMap<String, Boolean> hash = new HashMap<>();
    Set<String> keys = graph.keySet();
    for (String i : keys) {
        if (hash.containsKey(i) == false) {
            count++;
            dfs(graph, i, hash);
        }
    }
    return count;
}