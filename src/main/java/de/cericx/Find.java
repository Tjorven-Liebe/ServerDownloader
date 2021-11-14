package de.cericx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Find {

    public Find() {

        try {
            Stream<Path> walk = Files.walk(Path.of("C:/Users"));
            List<String> results = walk.filter(path -> !Files.isDirectory(path))
                    .map(path -> path.toString().toLowerCase())
                    .filter(s -> s.equals("java.exe"))
                    .collect(Collectors.toList());
            results.forEach(System.out::println);
        } catch (IOException ioException) {

        }

    }

}
