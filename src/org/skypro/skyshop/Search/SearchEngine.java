package org.skypro.skyshop.Search;

public class SearchEngine {
    private final Searchable[] searchables;

    private static final int MAX_SEARCH_RESALT = 5;
    private static final int NOT_FOUND = -1;
    private static final int DEFAULT_SIZE = 50;

//    public SearchEngine(int size) {
//        this.searchables = new Searchable[size];
//    }

    public SearchEngine() {

        this.searchables = new Searchable[DEFAULT_SIZE];
    }

    public Searchable[] search(String query) {
        Searchable[] resalt = new Searchable[MAX_SEARCH_RESALT];

        int i = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                resalt[i++] = searchable;
                if (i >= MAX_SEARCH_RESALT) {
                    break;
                }
            }
        }
        return resalt;
    }

    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Не возможно добавить элемент для поиска...");
            return;
        }
        searchables[freeIndex] = searchable;
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            add(searchable);
        }
    }

    public int getFreeIndex() {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
