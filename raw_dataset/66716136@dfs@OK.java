public static void dfs(HashMap<String, ArrayList<String>> graph, String start, HashMap<String, Boolean> hash) {
    hash.put(start, true);
    ArrayList<String> arr = graph.get(start);
    for (int i = 0; i < arr.size(); i++) {
        if (hash.containsKey(arr.get(i)) == false) {
            dfs(graph, arr.get(i), hash);
        }
    }
}