public static int[] longestSubarray(int[] inp) {
    // array containing prefix sums up to a certain index i
    int[] p = new int[inp.length];
    p[0] = inp[0];
    for (int i = 1; i < inp.length; i++) {
        p[i] = p[i - 1] + inp[i];
    }
    // array Q from the description below
    int[] q = new int[inp.length];
    q[inp.length - 1] = p[inp.length - 1];
    for (int i = inp.length - 2; i >= 0; i--) {
        q[i] = Math.max(q[i + 1], p[i]);
    }
    int a = 0;
    int b = 0;
    int maxLen = 0;
    int curr;
    int[] res = new int[] { -1, -1 };
    while (b < inp.length) {
        curr = a > 0 ? q[b] - p[a - 1] : q[b];
        if (curr >= 0) {
            if (b - a > maxLen) {
                maxLen = b - a;
                res = new int[] { a, b };
            }
            b++;
        } else {
            a++;
        }
    }
    return res;
}