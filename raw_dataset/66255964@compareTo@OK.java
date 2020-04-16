@Override
public int compareTo(Arr arr) {
    for (int i = 0; i < 4; i++) {
        if (a[i] != arr.a[i])
            return a[i] - arr.a[i];
    }
    return 0;
}