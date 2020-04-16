boolean isshun(int[] put) {
    int len = put.length;
    if (put[len - 1] == 14)
        return false;
    if (put[0] == 2)
        return false;
    if (put[1] == 2)
        return false;
    for (int i = 1; i < len; ++i) {
        if (put[i] - put[i - 1] != 1)
            return false;
    }
    return true;
}