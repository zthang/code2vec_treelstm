public static long[] count(int color1, int color2, int vertex, int old_vertex, int[][] colors, int[][] graph, boolean start, long[] res) {
    res[0] += colors[color1][vertex];
    res[vertex] = color1 + 1;
    int pos;
    if (graph[vertex][0] == old_vertex) {
        pos = 1;
    } else {
        pos = 0;
    }
    if (graph[vertex][pos] == 0 && !start) {
        return res;
    } else {
        return count(color2, 3 - color1 - color2, graph[vertex][pos], vertex, colors, graph, false, res);
    }
}