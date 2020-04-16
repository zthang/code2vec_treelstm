int[] multXOR(int[] a1, int[] a2, boolean doMod) {
    a1 = fftXor(a1, a1.length, false, doMod);
    a2 = fftXor(a2, a2.length, false, doMod);
    for (int i = 0; i < a1.length; i++) {
        if (doMod)
            a1[i] = mult(a1[i], a2[i]);
        else
            a1[i] = a1[i] * a2[i];
    }
    a1 = fftXor(a1, a1.length, true, doMod);
    // for(int i = 0; i < a1.length; i++) a1[i] %= MOD;
    return a1;
}