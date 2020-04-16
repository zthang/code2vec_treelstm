HarmeyerHash getHash() {
    HarmeyerHash res = new HarmeyerHash();
    for (int i : leftReachable) res.add(i);
    return res;
}