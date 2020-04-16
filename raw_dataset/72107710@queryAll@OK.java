public SegmentTreeResult queryAll(int y1, int y2) {
    SegmentTreeResult result = this._query(y1, y2, 1, 1, this.n, 0);
    return result;
}