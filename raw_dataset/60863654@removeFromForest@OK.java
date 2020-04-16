private void removeFromForest(Node xy, int k) {
    Node[] forest = lvs[k].forest;
    if (forest[xy.from] == xy) {
        forest[xy.from] = xy.next;
        gctSplit++;
        updateForest(k, xy.from);
    }
    Node next = xy.next;
    Node prev = xy.prev;
    if (prev != null)
        prev.next = next;
    if (next != null)
        next.prev = prev;
    xy.prev = xy.next = null;
}