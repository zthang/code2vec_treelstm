matrix pow(long pow) {
    matrix ans = new matrix(n);
    matrix temp = new matrix(a);
    for (int i = 0; i < n; i++) ans.a[i][i] = 1;
    while (pow != 0) {
        if ((pow & 1) == 1)
            ans = ans.mul(temp);
        temp = temp.mul(temp);
        pow >>= 1;
    }
    return ans;
}