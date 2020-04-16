void DFS(int edges) {
    Set<Integer> greySet = new HashSet<>();
    parent.put(1, 0);
    for (int i = 1; i <= vertices; i++) {
        if (!visited[i]) {
            DFSutil(i, greySet, visited);
        }
    }
    if (cycle) {
        System.out.println(2);
    } else {
        System.out.println(1);
    }
    for (int i = 0; i < edges; i++) {
        if (color.containsKey(i)) {
            System.out.print(2 + " ");
        } else {
            System.out.print(1 + " ");
        }
    }
}