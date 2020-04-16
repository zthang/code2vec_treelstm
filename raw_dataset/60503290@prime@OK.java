public static boolean prime(long src) {
    for (int i = 2; i * i <= src; i++) {
        if (src % i == 0)
            return false;
    }
    return true;
}