public static void bfsColor(int src) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(src);
    while (!queue.isEmpty()) {
        boolean b = false;
        int vertex = -1, p = -1;
        int poll = queue.remove();
        for (int v : list[poll]) {
            if (color[v] == 0) {
                vertex = v;
                break;
            }
        }
        for (int v : list[poll]) {
            if (color[v] != 0 && v != vertex) {
                p = v;
                break;
            }
        }
        for (int v : list[p]) {
            if (color[v] != 0) {
                color[vertex] = color[v];
                b = true;
                break;
            }
        }
        if (!b) {
            color[vertex] = color[poll] + 1;
        }
    }
}