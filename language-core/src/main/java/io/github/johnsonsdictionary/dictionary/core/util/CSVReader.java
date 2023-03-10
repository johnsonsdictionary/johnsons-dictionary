/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.johnsonsdictionary.dictionary.core.util;

import io.github.johnsonsdictionary.dictionary.core.words.WordDefinition;
import io.github.johnsonsdictionary.dictionary.core.words.WordDefinitionId;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Default implementation of a CSV Reader
 *
 * @param <I> The type of id of each record we are reading
 * @param <T> The type of record
 * @author Michael Lavelle
 */
public class CSVReader<I, T> {

    private BiFunction<I, List<String>, T> mappingFunction;
    private boolean firstLineAsHeader;
    private List<String> fileResources;
    private Function<T, I> idExtractor;
    private BiFunction<SortedMap<I, T>, List<String>, I> idGenerator;

    public CSVReader(BiFunction<I, List<String>, T> mappingFunction, Function<T, I> idExtractor,
                     BiFunction<SortedMap<I, T>, List<String>, I> idGenerator, boolean firstLineAsHeader, String primaryFileResource, String... additionalFileResources) {
        this.mappingFunction = mappingFunction;
        this.idExtractor = idExtractor;
        this.idGenerator = idGenerator;
        this.firstLineAsHeader = firstLineAsHeader;
        this.fileResources = new ArrayList<>();
        this.fileResources.add(primaryFileResource);
        if (firstLineAsHeader) {
            throw new UnsupportedOperationException("First line as header configuration not yet implemented");
        }
        this.fileResources.addAll(Arrays.asList(additionalFileResources));
    }

    public CSVReader(BiFunction<I, List<String>, T> mappingFunction, Function<T, I> idExtractor,
                     BiFunction<SortedMap<I, T>, List<String>, I> idGenerator, boolean firstLineAsHeader, List<String> fileResources) {
        this.mappingFunction = mappingFunction;
        this.idExtractor = idExtractor;
        this.idGenerator = idGenerator;
        this.firstLineAsHeader = firstLineAsHeader;
        this.fileResources = fileResources;
        if (firstLineAsHeader) {
            throw new UnsupportedOperationException("First line as header configuration not yet implemented");
        }
    }

    protected static int getOccurrenceId(SortedMap<WordDefinitionId, WordDefinition> resultsSoFar, String verb) {
        int meaningId = 1;
        for (Map.Entry<WordDefinitionId, WordDefinition> entry : resultsSoFar.entrySet()) {
            if (entry.getValue().getWord().equals(verb)) {
                meaningId++;
            }
        }
        return meaningId;
    }

    public SortedMap<I, T> load() {
        List<String> lines = new ArrayList<>();
        for (String resource : fileResources) {
            try (InputStream is = CSVReader.class.getResourceAsStream(resource)) {
                try (BufferedInputStream bis = new BufferedInputStream(is)) {
                    String content = new String(bis.readAllBytes());
                    StringTokenizer st = new StringTokenizer(content, "\n");
                    while (st.hasMoreTokens()) {
                        String line = st.nextToken().trim();
                        if (!line.isEmpty()) {
                            lines.add(line);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return processLines(lines);
    }

    private SortedMap<I, T> processLines(List<String> lines) {
        SortedMap<I, T> results = new TreeMap<>();
        for (String line : lines) {
            T mapped = getMappedLine(results, line);
            I id = idExtractor.apply(mapped);
            results.put(id, getMappedLine(results, line));
        }
        return results;
    }

    private T getMappedLine(SortedMap<I, T> resultsSoFar, String line) {
        StringTokenizer st = new StringTokenizer(line, ",");
        List<String> variables = new ArrayList<>();
        while (st.hasMoreTokens()) {
            variables.add(st.nextToken());
        }
        I id = idGenerator.apply(resultsSoFar, variables);
        T mapped = mappingFunction.apply(id, variables);
        return mapped;
    }
}
