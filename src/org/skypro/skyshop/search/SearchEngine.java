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
}
