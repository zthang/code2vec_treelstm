private Splay alloc(int id) {
    Splay splay = deque.isEmpty() ? new Splay() : deque.removeFirst();
    splay.id = id;
    return splay;
}