private int[] build_z_function(String s) {
    int n = s.length();
    int[] zfun = new int[n];
    int l = -1, r = -1;
    for (int i = 1; i < n; i++) {
        // Set the start value
        if (i <= r)
            zfun[i] = Math.min(zfun[i - l], r - i + 1);
        while (i + zfun[i] < n && s.charAt(i + zfun[i]) == s.charAt(zfun[i])) zfun[i]++;
        if (i + zfun[i] - 1 > r) {
            l = i;
            r = i + zfun[i] - 1;
        }
    }
    if (test) {
        System.out.println("Z-function of " + s);
        for (int i = 0; i < n; i++) System.out.print(zfun[i] + " ");
        System.out.println();
    }
    return zfun;
}