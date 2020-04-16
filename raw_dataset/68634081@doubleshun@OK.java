boolean doubleshun(int[] put) {
    int len = put.length;
    if (len % 2 == 1)
        return false;
    for (int i = 1; i < len; i += 2) {
        if (put[i] - put[i - 1] != 0)
            return false;
    }
    for (int i = 2; i < len; i += 2) {
        if (put[i] - put[i - 1] != 1)
            return false;
    }
    return true;
}