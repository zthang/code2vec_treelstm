public Edge findPartner(Node leaf, Node p) {
    Node b = t1[lcaOnTree.lca(leaf.id, p.id)];
    Node a;
    if (sameComponent(leaf, b)) {
        a = t1[p.id];
    } else {
        a = t1[leaf.id];
    }
    for (int i = 20 - 1; i >= 0; i--) {
        if (a.jump[i] == null || lcaOnTree.lca(b.id, a.jump[i].id) != b.id) {
            continue;
        }
        boolean sameWithA;
        if (sameComponent(leaf, a)) {
            sameWithA = sameComponent(leaf, a.jump[i]);
        } else {
            sameWithA = !sameComponent(leaf, a.jump[i]);
        }
        if (sameWithA) {
            a = a.jump[i];
        }
    }
    return a.from;
}