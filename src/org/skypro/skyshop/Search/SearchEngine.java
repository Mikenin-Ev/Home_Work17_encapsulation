package org.skypro.skyshop.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine () {
        this.searchables = new LinkedList<>();
    }

    public Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        if (search == null || search.isBlank() || items == null || items.isEmpty()) {
            throw new BestResultNotFound("Не найдено подходящего объекта для запроса: '" + search + "'");
        }

        Searchable bestMatch = null;
        int maxCount = -1;
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

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Не возможно добавить null элемент для поиска...");
        }
        searchables.add(searchable);
    }

    public List<Searchable> search(String searchString) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchString)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            add(searchable);
        }
    }
}
