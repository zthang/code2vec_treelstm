public static Node[] nodesdfs(Node a, Node[] ns, int[] pos) {
    if (a == null)
        return ns;
    ns[pos[0]++] = a;
    nodesdfs(a.left, ns, pos);
    nodesdfs(a.right, ns, pos);
    return ns;
}