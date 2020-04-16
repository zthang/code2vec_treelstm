private void ensureVertexCapacity(int size) {
    if (firstOutbound.length < size) {
        int newSize = Math.max(size, 2 * firstOutbound.length);
        firstOutbound = resize(firstOutbound, newSize);
        if (firstInbound != null) {
            firstInbound = resize(firstInbound, newSize);
        }
    }
}