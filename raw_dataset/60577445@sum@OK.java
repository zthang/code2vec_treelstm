public long sum(int fromInclusive, int toExclusive) {
    if (fromInclusive > toExclusive)
        throw new IllegalArgumentException("Wrong value");
    return sums[toExclusive] - sums[fromInclusive];
}