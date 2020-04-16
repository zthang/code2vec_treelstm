public int hashCode() {
    int hu = (int) (u ^ (u >>> 32));
    int hv = (int) (v ^ (v >>> 32));
    return 31 * hu + hv;
}