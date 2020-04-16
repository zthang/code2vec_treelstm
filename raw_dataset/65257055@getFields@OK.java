private NavigableMap<String, Object> getFields() {
    try {
        NavigableMap<String, Object> result = new TreeMap<String, Object>();
        for (Field field : this.getClass().getFields()) {
            if (Modifier.isTransient(field.getModifiers())) {
                continue;
            }
            result.put(field.getName(), field.get(this));
        }
        return result;
    } catch (IllegalAccessException e) {
        throw new RuntimeException("Can't access my own elements!", e);
    }
}