package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " " + getContentType();
    }
}
