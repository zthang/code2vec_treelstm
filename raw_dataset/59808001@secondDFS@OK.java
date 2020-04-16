private void secondDFS(int vertexID) {
    if (visited[vertexID]) {
        if (condensed[vertexID] != index) {
            if (next[condensed[vertexID]] != key) {
                next[condensed[vertexID]] = key;
                queue[queueSize++] = condensed[vertexID];
            }
        }
        return;
    }
    condensed[vertexID] = index;
    visited[vertexID] = true;
    int edgeID = graph.firstInbound(vertexID);
    while (edgeID != -1) {
        secondDFS(graph.source(edgeID));
        edgeID = graph.nextInbound(edgeID);
    }
}