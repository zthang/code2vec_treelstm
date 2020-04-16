public static long binarySearch(long low, long high) {
    while (high - low > 1) {
        long mid = (high - low) / 2 + low;
        // System.out.println(mid);
        if (works(mid)) {
            high = mid;
        } else {
            low = mid;
        }
    }
    return (works(low) ? low : high);
}