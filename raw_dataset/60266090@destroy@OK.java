private void destroy(Splay s) {
    s.info = null;
    s.chain = null;
    s.infoWithMaxLevel = null;
    s.containEdge = null;
    deque.addLast(s);
}