public final int firstInbound(int vertex) {
    initInbound();
    int id = firstInbound[vertex];
    while (id != -1 && isRemoved(id)) {
        id = nextInbound[id];
    }
    return id;
}