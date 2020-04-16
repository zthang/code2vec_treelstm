public static void DFS(ArrayList<Integer>[] ar, int s, int[] visited, int c) {
    if (min.size() == c) {
        min.add(s);
        max.add(s);
    } else {
        min.set(c, Math.min(s, min.get(c)));
        max.set(c, Math.max(s, max.get(c)));
    }
    for (int i = 0; i < ar[s].size(); i++) {
        int u = ar[s].get(i);
        if (visited[u] == 0) {
            // System.out.print(u+" ");
            visited[u] = 1;
            DFS(ar, u, visited, c);
        }
    }
}