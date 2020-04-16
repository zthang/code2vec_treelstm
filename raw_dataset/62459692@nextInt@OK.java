public int nextInt() throws Exception {
    int c, val = 0;
    for (c = scan(); c <= 32; c = scan()) ;
    boolean neg = c == '-';
    if (c == '-' || c == '+')
        c = scan();
    for (; c >= '0' && c <= '9'; c = scan()) val = (val << 3) + (val << 1) + (c & 15);
    return neg ? -val : val;
}