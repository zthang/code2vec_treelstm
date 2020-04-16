void reverseBfs() {
    boolean[] visited = new boolean[n + 1];
    boolean[] goodsLocked = new boolean[n + 1];
    List<Integer> curList = new ArrayList<>();
    curList.add(t);
    goodsLocked[t] = true;
    while (!curList.isEmpty()) {
        List<Integer> nextList = new ArrayList<>();
        for (int node : curList) {
            if (visited[node])
                continue;
            visited[node] = true;
            for (int ch : nodes[node].in) {
                if (visited[ch]) {
                    continue;
                }
                if (!goodsLocked[ch])
                    nodes[ch].goods.add(node);
                nextList.add(ch);
            }
        }
        for (int nextNode : nextList) {
            goodsLocked[nextNode] = true;
        }
        curList = nextList;
    }
}