private static boolean hasCycle(int[] vertices, int[][] edges) {
    List<Integer> queue = new LinkedList<>();
    for (int i = 1; i < vertices.length; i++) {
        if (vertices[i] == 0) {
            queue.add(i);
        }
    }
    while (!queue.isEmpty()) {
        int i = queue.remove(0);
        for (int j = 1; j < edges.length; j++) {
            if (edges[j][0] == i) {
                vertices[edges[j][1]]--;
                if (vertices[edges[j][1]] == 0) {
                    queue.add(edges[j][1]);
                }
            }
        }
    }
    for (int i = 1; i < vertices.length; i++) {
        if (vertices[i] > 0) {
            return true;
        }
    }
    return false;
}