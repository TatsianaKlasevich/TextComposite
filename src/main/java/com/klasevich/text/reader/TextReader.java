package com.klasevich.text.reader;

import com.klasevich.text.exception.ReaderException;
import com.klasevich.text.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_FILE = "data/text.txt";

    public String readingFromFile(String fileName) throws ReaderException {
        StringBuilder text = new StringBuilder();
        String result;
        Path path = Paths.get(fileName);

        if (!FileValidator.isFileExist(path)) {
            path = Paths.get(DEFAULT_FILE);
        }
        try {
            String data = new String(Files.readAllBytes(Paths.get(fileName)));
            logger.debug(data);
            logger.info("File '{}' was successfully read", fileName);
            return data;
            //lines =Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error(e);
            throw new ReaderException(e);
        }
    }
}
