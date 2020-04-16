public int compareTo(HarmeyerHash o) {
    if (v1 != o.v1)
        return Long.compare(v1, o.v1);
    return Long.compare(v2, o.v2);
}