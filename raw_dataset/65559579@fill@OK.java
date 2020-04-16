static int[] fill(int fnode) {
    Deque<Integer> bfs = new ArrayDeque<Integer>();
    int max = fnode;
    int min = fnode;
    bfs.addLast(fnode);
    visit[fnode] = true;
    while (!bfs.isEmpty()) {
        int node = bfs.removeFirst();
        for (int i : al.get(node)) {
            if (!visit[i]) {
                max = Math.max(max, i);
                min = Math.min(min, i);
                bfs.addLast(i);
                visit[i] = true;
            }
        }
    }
    return new int[] { min, max };
}