public static long binarySearch(long from, long to, LongFilter function) {
    while (from < to) {
        long argument = from + ((to - from) >> 1);
        if (function.accept(argument)) {
            to = argument;
        } else {
            from = argument + 1;
        }
    }
    return from;
}