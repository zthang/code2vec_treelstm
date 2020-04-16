private void firstDFS(int vertexID) {
    if (visited[vertexID]) {
        return;
    }
    visited[vertexID] = true;
    int edgeID = graph.firstOutbound(vertexID);
    while (edgeID != -1) {
        firstDFS(graph.destination(edgeID));
        edgeID = graph.nextOutbound(edgeID);
    }
    order[index++] = vertexID;
}