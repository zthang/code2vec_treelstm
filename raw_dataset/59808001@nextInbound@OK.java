public final int nextInbound(int id) {
    initInbound();
    id = nextInbound[id];
    while (id != -1 && isRemoved(id)) {
        id = nextInbound[id];
    }
    return id;
}