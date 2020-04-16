public void dfsT2(Node root, Edge from) {
    for (Edge e : root.next) {
        if (e == from) {
            continue;
        }
        dfsT2(e.other(root), e);
    }
    for (Edge e : root.next) {
        if (e == from) {
            continue;
        }
        Edge partner = findPartner(e.other(root), root);
        answer(partner, e);
        Node.merge(t2[partner.a.id], t2[partner.b.id]);
    }
}