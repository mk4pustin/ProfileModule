package ru.sber.kapustin.homework2;

import java.util.*;

public class AdditionalTask1 {

    public List<String> getTopWords(String[] words, int k) {
        final var wordsCount = new HashMap<String, Integer>();
        Arrays.stream(words).forEach(word -> wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1));

        PriorityQueue<String> topWords = new PriorityQueue<>(
                (word1, word2) -> wordsCount.get(word1).equals(wordsCount.get(word2)) ?
                        word1.compareTo(word2) : wordsCount.get(word1) - wordsCount.get(word2)
        );

        wordsCount.keySet().forEach(word -> {
            topWords.offer(word);
            if (topWords.size() > k) topWords.poll();
        });

        List<String> result = new ArrayList<>();
        topWords.forEach(word -> result.add(0, word));

        return result;
    }
}
