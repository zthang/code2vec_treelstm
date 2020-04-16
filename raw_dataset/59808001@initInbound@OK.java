private void initInbound() {
    if (firstInbound == null) {
        firstInbound = new int[firstOutbound.length];
        Arrays.fill(firstInbound, 0, vertexCount, -1);
        nextInbound = new int[from.length];
        for (int i = 0; i < edgeCount; i++) {
            nextInbound[i] = firstInbound[to[i]];
            firstInbound[to[i]] = i;
        }
    }
}