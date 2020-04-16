public static long asLong(int high, int low) {
    return ((((long) high)) << 32) | (((long) low) & mask32);
}