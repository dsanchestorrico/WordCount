/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bo.wordscount;

import com.sun.xml.internal.ws.api.ResourceLoader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author Daniel Sanchez
 */
public class WordCount {

    public void CountWordsInFile(String name) throws IOException, URISyntaxException {
        Path path = Paths.get(this.getClass().getClassLoader().getResource(name).toURI());
        Map<String, Long> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));

        wordCount.keySet().stream()
                .sorted(Comparator
                        .comparing(wordCount::get)
                        .reversed()
                        .thenComparing(Collator.getInstance()))
                .map(k -> k + " (" + wordCount.get(k) + ")")
                .forEach(System.out::println);

    }
}
