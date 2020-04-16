// μ(n) = 1 if n is a square-free positive integer with an even number of prime factors. e.g.  6, 15
// μ(n) = −1 if n is a square-free positive integer with an odd number of prime factors. e.g.  2, 3, 5, 2*3*5
// μ(n) = 0 if n has a squared prime factor. e.g : 2*2,  3*3*5
private void build_pow2_function(int n) {
    pow2 = new int[n + 1];
    pow2[0] = 1;
    for (int i = 1; i <= n; i++) pow2[i] = (int) (1L * pow2[i - 1] * 2 % MOD);
}