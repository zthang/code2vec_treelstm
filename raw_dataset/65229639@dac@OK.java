public void dac(Edge[] es, int el, int er, Query[] qs, int ql, int qr) {
    if (ql > qr) {
        return;
    }
    if (el == er) {
        for (int i = ql; i <= qr; i++) {
            qs[i].ans = es[el].w;
        }
        return;
    }
    int sp = deque.size();
    int m = (el + er) / 2;
    for (int i = el; i <= m; i++) {
        Node.merge(es[i].a, es[i].b, deque);
    }
    int lpos = ql;
    for (int i = ql; i <= qr; i++) {
        if (qs[i].a.find() == qs[i].b.find()) {
            buf[lpos++] = qs[i];
        }
    }
    int rpos = lpos;
    for (int i = ql; i <= qr; i++) {
        if (qs[i].a.find() != qs[i].b.find()) {
            buf[rpos++] = qs[i];
        }
    }
    System.arraycopy(buf, ql, qs, ql, qr - ql + 1);
    dac(es, m + 1, er, qs, lpos, qr);
    while (deque.size() > sp) {
        Node.split(deque.removeLast());
    }
    dac(es, el, m, qs, ql, lpos - 1);
}