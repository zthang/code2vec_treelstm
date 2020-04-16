// inclusive, exclusive
public static HarmeyerHash substringHash(HarmeyerHash[] prefixHashes, int from, int to) {
    if (from == to)
        return new HarmeyerHash();
    HarmeyerHash old = prefixHashes[to].clone(), toSub = prefixHashes[from];
    int diff = to - from;
    old.v1 = (old.v1 - (toSub.v1 * s1Pow[diff]) % m1 + m1) % m1;
    old.v2 = (old.v2 - (toSub.v2 * s2Pow[diff]) % m2 + m2) % m2;
    old.l = to - from;
    return old;
}