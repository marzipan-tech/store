package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private int count = 0;
    private int size;
    private Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        this.size = size;
    }

    @Override
    public String toString() {
        return Arrays.toString(searchables);
    }

    public Searchable[] search(String query) {
        Searchable[] searchResult = new Searchable[5];
        int results = 0;
        for (int i = 0, j = 0; i < searchables.length; i++) {
            if (results == 5) {
                break;
            }
            if (searchables[i] != null && searchables[i].searchTerm().toLowerCase().contains(query.toLowerCase())) {
                searchResult[j] = searchables[i];
                results++;
                j++;
            }
        }
        return searchResult;
    }

    public void add(Searchable item) {
        if (count==size) {
            System.out.println("Нельзя добавить позицию");
        }
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = item;
                count++;
                return;
            }
        }
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;
        for (Searchable value : searchables) {
            int count = 0;
            int index = 0;
            int searchIndex = value.searchTerm().toLowerCase().indexOf(search, index);
            while (searchIndex != -1) {
                count++;
                index = searchIndex + search.length();
                searchIndex = value.searchTerm().toLowerCase().indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                searchable = value;
            }
        }
        if (maxCount == 0) {
            throw new BestResultNotFound("Ничего не найдено по запросу: " + search);
        }
        return searchable;
    }
}
