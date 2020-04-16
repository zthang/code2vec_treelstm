public void intersectWith(LongRange range) {
    a = Math.max(range.a, a);
    b = Math.min(range.b, b);
}