public void removeAll(Range range) {
    rangeCheck(range.a);
    rangeCheck(range.b);
    range.ensureValidity();
    shift(range.b, range.a - range.b);
}