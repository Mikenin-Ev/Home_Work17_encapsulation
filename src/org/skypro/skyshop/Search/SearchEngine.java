package org.skypro.skyshop.Search;

import java.util.List;

public class SearchEngine {
    private final Searchable[] searchables;

    private static final int MAX_SEARCH_RESALT = 5;
    private static final int NOT_FOUND = -1;
    private static final int DEFAULT_SIZE = 50;

    public Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        if (search == null || search.isBlank() || items == null || items.isEmpty()) {
            throw new BestResultNotFound("Не найдено подходящего объекта для запроса: '" + search + "'");
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        // Используем for-each для перебора всех элементов
        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm(), search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxCount == 0) {
            throw new BestResultNotFound("Не найдено подходящего объекта для запроса: '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        if (str == null || substring == null || str.isEmpty() || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        while (true) {
            int foundIndex = str.indexOf(substring, index);
            if (foundIndex == -1) {
                break;
            }
            count++;
            index = foundIndex + substringLength;
        }

        return count;
    }

    public SearchEngine () {

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
