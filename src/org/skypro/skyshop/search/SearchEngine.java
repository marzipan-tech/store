package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    @Override
    public String toString() {
        return "SearchEngine " + searchables;
    }

    public Set<Searchable> search(String query) {
        return searchables
                .stream()
                .filter(i -> i.searchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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
