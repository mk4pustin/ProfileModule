package ru.sber.kapustin.homework2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {

    public Map<Integer, Document> organizeDocuments(List<Document> documents) {
        Map<Integer, Document> map = new HashMap<>();
        documents.forEach(document -> map.put(document.id, document));

        return map;
    }
}
