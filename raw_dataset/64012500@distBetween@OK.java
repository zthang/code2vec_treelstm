public long distBetween(Node a, Node b) {
    return (long) (a.k + b.k) * (Math.abs(a.x - b.x) + Math.abs(a.y - b.y));
}