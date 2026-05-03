package org.skypro.skyshop.Search;

public interface Searchable {

    String getSearchTerm();

    String getSearchContentType();

    default String getStringRepresentation() {
        return this.getClass().getSimpleName() + '-' + getSearchContentType();
    }
}
