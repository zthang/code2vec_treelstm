static int nextLog2(int a) {
    return (a == 0 ? 0 : 32 - Integer.numberOfLeadingZeros(a - 1));
}