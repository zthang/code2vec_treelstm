private static Node update(Node a) {
    if (a == null)
        return null;
    a.count = 1;
    if (a.left != null)
        a.count += a.left.count;
    if (a.right != null)
        a.count += a.right.count;
    a.desptn = a.from < a.to ? 1 << a.info.level : 0;
    if (a.left != null)
        a.desptn |= a.left.desptn;
    if (a.right != null)
        a.desptn |= a.right.desptn;
    a.desaux = a.level.forest[a.from] == a && a.level.auxis[a.from] != null ? a.level.nauxis[a.from] : 0;
    if (a.left != null)
        a.desaux += a.left.desaux;
    if (a.right != null)
        a.desaux += a.right.desaux;
    return a;
}