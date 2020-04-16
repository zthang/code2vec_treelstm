public int hashCode() {
    // System.out.println("In hashcode");
    int hashcode = 0;
    hashcode = a * 20;
    hashcode += b * 20;
    return hashcode;
}