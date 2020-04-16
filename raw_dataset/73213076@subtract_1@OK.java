static // it will subtract 1 from the given number.  number should be positive
void subtract_1(// it will subtract 1 from the given number.  number should be positive
char[] s) {
    if (// number is zero
    s[0] == '0')
        return;
    int n = s.length, i = n - 1;
    while (s[i] == '0') i--;
    s[i] = (char) ((int) (s[i] - '0') + 47);
    for (int j = i + 1; j < n; j++) s[j] = '9';
}