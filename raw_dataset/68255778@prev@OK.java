public static Node prev(Node x) {
    if (x == null)
        return null;
    if (x.left != null) {
        x = x.left;
        while (x.right != null) x = x.right;
        return x;
    } else {
        while (true) {
            Node p = x.parent;
            if (p == null)
                return null;
            if (p.right == x)
                return p;
            x = p;
        }
    }
}