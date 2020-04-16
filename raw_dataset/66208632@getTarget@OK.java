private static int getTarget(int from, ArrayList<Integer>[] adj) {
    int index = 0;
    for (int i = 0; i < adj.length; i++) {
        if (i != from && !adj[i].contains(from)) {
            if (adj[i].size() == 0) {
                return i;
            } else if (adj[i].size() < 2) {
                index = i;
            }
        }
    }
    return index;
}