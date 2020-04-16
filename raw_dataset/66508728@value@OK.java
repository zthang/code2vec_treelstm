static int value(char c) {
    if (c == '(')
        return 1;
    if (c == ')')
        return -1;
    return 0;
}