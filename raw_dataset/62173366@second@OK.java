public long second(long x) {
    int emit = 0;
    boolean find = false;
    for (int i = 2; ; i--) {
        if (abc[i] == x && !find) {
            find = true;
            continue;
        }
        if (emit == 0) {
            emit++;
            continue;
        }
        return abc[i];
    }
}