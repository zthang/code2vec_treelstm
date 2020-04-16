static int pow(int a, int b) {
    int ans = 1;
    for (int i = 0; i < b; i++) ans *= a;
    return ans;
}