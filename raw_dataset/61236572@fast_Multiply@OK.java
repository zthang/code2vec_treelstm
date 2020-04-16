static long fast_Multiply(long no, long pow) {
    long result = 1;
    while (pow > 0) {
        if ((pow & 1) == 1) {
            result = result * no;
        }
        no = no * no;
        pow >>= 1;
    }
    return result;
}