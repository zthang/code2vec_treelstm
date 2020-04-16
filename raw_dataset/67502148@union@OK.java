boolean union(int i, int j) {
    i = find(i);
    j = find(j);
    if (i == j)
        return false;
    if (s[i] == s[j])
        s[i]--;
    if (s[i] <= s[j])
        s[j] = i;
    else
        s[i] = j;
    return true;
}