public LongRange intersectedWith(LongRange range) {
    LongRange res = new LongRange(this);
    res.intersectWith(range);
    return res;
}