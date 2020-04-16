public int find(int id) {
    if (ids[id] == -1) {
        ids[id] = id;
        return id;
    }
    while (id != ids[id]) {
        id = ids[ids[id]];
    }
    return id;
}