public HarmeyerHash clone() {
    HarmeyerHash toReturn = new HarmeyerHash();
    toReturn.v1 = v1;
    toReturn.v2 = v2;
    toReturn.l = l;
    return toReturn;
}