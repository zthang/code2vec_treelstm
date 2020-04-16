static long power(int i) {
    // if(i==0)
    // return 1;
    long a = 1;
    for (int k = 0; k < i; k++) a *= i;
    return a;
}