// need fastPow if o can be longer than 10^6
void append(HarmeyerHash o) {
    precomp();
    v1 = (v1 * s1Pow[o.l] + o.v1) % m1;
    v2 = (v2 * s2Pow[o.l] + o.v2) % m2;
    l += o.l;
}