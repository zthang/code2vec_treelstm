private Pair<int[], Graph> kosaraju() {
    for (int i = 0; i < vertexCount; i++) {
        if (!visited[i]) {
            firstDFS(i);
        }
    }
    Arrays.fill(visited, false);
    Graph result = new Graph(0);
    index = 0;
    next = ArrayUtils.createArray(graph.vertexCount(), -1);
    queue = new int[graph.vertexCount()];
    for (int i = vertexCount - 1; i >= 0; i--) {
        if (!visited[order[i]]) {
            key = i;
            queueSize = 0;
            secondDFS(order[i]);
            result.addVertices(1);
            for (int j = 0; j < queueSize; j++) {
                result.addSimpleEdge(queue[j], index);
            }
            index++;
        }
    }
    return Pair.makePair(condensed, result);
}