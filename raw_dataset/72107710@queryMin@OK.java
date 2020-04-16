public int queryMin(int y1, int y2) {
    SegmentTreeResult result = this.queryAll(y1, y2);
    return result.min;
}