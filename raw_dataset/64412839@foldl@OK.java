public static int foldl(IntBinaryOperator operator, int... vals) {
    int result = vals[0];
    for (int i = 1; i < vals.length; i++) {
        result = operator.applyAsInt(result, vals[i]);
    }
    return result;
}