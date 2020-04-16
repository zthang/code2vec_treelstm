public static int max(int... vals) {
    return foldl(Math::max, vals);
}