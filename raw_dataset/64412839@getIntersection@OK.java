public static LongRange getIntersection(LongRange... a) {
    return Arrays.stream(a).reduce((res, b) -> res.intersectedWith(b)).get();
}