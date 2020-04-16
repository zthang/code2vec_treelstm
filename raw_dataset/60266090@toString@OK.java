@Override
public String toString() {
    StringBuilder builder = new StringBuilder().append(id).append(":");
    toString(cloneTree(this), builder);
    return builder.toString();
}