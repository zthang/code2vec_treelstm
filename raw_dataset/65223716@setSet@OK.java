public int setSet(int n) {
    if (p[n] == n)
        return n;
    else
        return p[n] = setSet(p[n]);
}