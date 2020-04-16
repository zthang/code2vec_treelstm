// split excluding me
public static Node[] splitEx(Node x) {
    if (x == null)
        return new Node[] { null, null };
    if (x.left != null)
        x.left.parent = null;
    if (x.right != null)
        x.right.parent = null;
    Node[] sp = new Node[] { x.left, x.right };
    x.left = null;
    x.right = null;
    update(x);
    while (x.parent != null) {
        Node p = x.parent;
        x.parent = null;
        if (x == p.left) {
            p.left = sp[1];
            if (sp[1] != null)
                sp[1].parent = p;
            sp[1] = p;
        } else {
            p.right = sp[0];
            if (sp[0] != null)
                sp[0].parent = p;
            sp[0] = p;
        }
        update(p);
        x = p;
    }
    return sp;
}