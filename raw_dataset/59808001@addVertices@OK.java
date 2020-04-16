public final void addVertices(int count) {
    ensureVertexCapacity(vertexCount + count);
    Arrays.fill(firstOutbound, vertexCount, vertexCount + count, -1);
    if (firstInbound != null) {
        Arrays.fill(firstInbound, vertexCount, vertexCount + count, -1);
    }
    vertexCount += count;
}