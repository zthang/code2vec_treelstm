private static int factor(int a) {
    int n = 1, cnt = 0;
    while (a % 2 == 0) {
        a /= 2;
        cnt++;
    }
    if (cnt % 2 != 0)
        n = 2;
    for (int i = 3; i * i <= a; i += 2) {
        cnt = 0;
        while (a % i == 0) {
            a /= i;
            cnt++;
        }
        if (cnt % 2 != 0)
            n *= i;
    }
    if (a != 1)
        n *= a;
    return n;
}