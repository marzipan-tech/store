package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private LinkedList<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "SearchEngine " + searchables;
    }

    public Map<String, Searchable> search(String query) {
        Iterator<Searchable> iterator = searchables.iterator();
        Map<String, Searchable> searchResult = new TreeMap<>();
        while (iterator.hasNext()) {
            Searchable item = iterator.next();
            if (item.searchTerm().toLowerCase().contains(query.toLowerCase())) {
                searchResult.put(item.getName(), item);
            }
        }
        return searchResult;
    }

    public void add(Searchable item) {
        searchables.add(item);
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;
        for (Searchable value : searchables) {
            int count = 0;
            int index = 0;
            int searchIndex = value.searchTerm().toLowerCase().indexOf(search.toLowerCase(), index);
            while (searchIndex != -1) {
                count++;
                index = searchIndex + search.length();
                searchIndex = value.searchTerm().toLowerCase().indexOf(search.toLowerCase(), index);
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
