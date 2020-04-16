public static Node next(Node x) {
    if (x == null)
        return null;
    if (x.right != null) {
        x = x.right;
        while (x.left != null) x = x.left;
        return x;
    } else {
        while (true) {
            Node p = x.parent;
            if (p == null)
                return null;
            if (p.left == x)
                return p;
            x = p;
        }
    }
}