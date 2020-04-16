public double DistanceofPointandLine(DoublePair P, Triplet T) {
    return Math.abs(P.a * T.a + P.b * T.b + T.c) / Math.sqrt(T.a * T.a + T.b * T.b);
}