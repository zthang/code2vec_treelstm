private static void removeAllNodes(int i) {
    LinkedList<Integer> nextNodes = new LinkedList<Integer>();
    nextNodes.add(i);
    visited[i] = true;
    while (!nextNodes.isEmpty()) {
        int currNode = nextNodes.poll();
        iterator = nodes.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (hashSet[currNode].contains(n)) {
                continue;
            }
            iterator.remove();
            if (visited[n]) {
                continue;
            }
            nextNodes.add(n);
            visited[n] = true;
        }
    }
}