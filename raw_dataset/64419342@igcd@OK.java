int igcd(int a, int b) {
    if (a % b == 0)
        return b;
    else
        return igcd(b, a % b);
}