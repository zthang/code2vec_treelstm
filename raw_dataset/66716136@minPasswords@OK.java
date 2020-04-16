public static int minPasswords(String[] passwords) {
    HashMap<Character, String> hash = new HashMap<>();
    HashMap<String, ArrayList<String>> graph = new HashMap<>();
    int n = passwords.length;
    for (int i = 0; i < n; i++) {
        String currPassword = passwords[i];
        if (graph.containsKey(currPassword)) {
            continue;
        } else {
            ArrayList<String> arr = new ArrayList<>();
            graph.put(currPassword, arr);
        }
        for (int j = 0; j < currPassword.length(); j++) {
            if (hash.containsKey(currPassword.charAt(j))) {
                String u = hash.get(currPassword.charAt(j));
                String v = currPassword;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }
        for (int j = 0; j < currPassword.length(); j++) {
            hash.put(currPassword.charAt(j), currPassword);
        }
    }
    return countComponents(graph);
}