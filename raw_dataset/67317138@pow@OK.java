long pow(long a, long b) {
    if (b == 0)
        return 1;
    else {
        long x = pow(a, b / 2);
        if (b % 2 == 1)
            return (x * x * a);
        else
            return (x * x);
    }
}