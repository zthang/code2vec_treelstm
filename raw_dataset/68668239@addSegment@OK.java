SegmentCountForInterval addSegment(int segmentNumber) {
    return new SegmentCountForInterval(this.count + 1, segmentNumber);
}