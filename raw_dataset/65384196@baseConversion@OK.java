public static String baseConversion(String number, int sBase, int dBase) {
    // and return in specified radix(base)
    return Long.toString(Long.parseLong(number, sBase), dBase);
}