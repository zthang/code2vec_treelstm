static int pow(int a, int b) {
    int l = 1;
    for (int i = 0; i < b; i++) {
        l *= a;
    }
    return l;
}