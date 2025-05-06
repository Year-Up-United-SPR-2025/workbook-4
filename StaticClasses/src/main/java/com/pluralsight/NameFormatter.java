package com.pluralsight;

class NameFormatter {
    private NameFormatter() {
    }

    public static String formatName(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder sb = new StringBuilder();

        sb.append(lastName).append(",");

        if (!prefix.isEmpty()) {
            sb.append(" ").append(prefix);
        }

        sb.append(" ").append(firstName);

        if (!middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }

        if (!suffix.isEmpty()) {
            sb.append(", ").append(suffix);
        }

        return sb.toString().trim();
    }
}