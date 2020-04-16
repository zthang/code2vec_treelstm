public static int min(int... vals) {
    return foldl(Math::min, vals);
}