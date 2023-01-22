package persistence.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class IteratorReader implements Iterable<String> {
    private final BufferedReader reader;

    public IteratorReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            String currentLine = this.readLine();

            private String readLine() {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public boolean hasNext() {
                return currentLine != null;
            }

            @Override
            public String next() {
                String result = currentLine;
                currentLine = this.readLine();
                return result;
            }
        };
    }
}
