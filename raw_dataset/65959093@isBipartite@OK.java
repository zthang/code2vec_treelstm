public static int isBipartite(ArrayList<Integer>[] list, int src) {
    color[src] = 0;
    Queue<Integer> queue = new LinkedList<>();
    int[] ans = { 0, 0 };
    queue.add(src);
    while (!queue.isEmpty()) {
        ans[color[src = queue.poll()]]++;
        for (int v : list[src]) {
            if (color[v] == -1) {
                queue.add(v);
                color[v] = color[src] ^ 1;
            } else if (color[v] == color[src])
                check = false;
        }
    }
    return add(pow[ans[0]], pow[ans[1]]);
}