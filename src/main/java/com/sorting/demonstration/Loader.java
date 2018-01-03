package com.sorting.demonstration;

import java.io.IOException;
import java.io.RandomAccessFile;

public final class Loader {

    private final static String READ_MODE = "r";
    private final static String READ_WRITE_MODE = "rw";

    private final String path;
    private String text;

    public Loader(final String path) {
        this(path, "");
    }

    public Loader(final String path, final String text) {
        this.path = path;
        this.text = text;
    }

    public String read() throws IOException {
        try (RandomAccessFile in = new RandomAccessFile(this.path, READ_MODE)) {
            byte[] buf = new byte[(int) in.length()];
            in.read(buf);
            this.text = new String(buf);
            return this.text;
        }
    }

    public void write() throws IOException {
        try (RandomAccessFile out = new RandomAccessFile(this.path, READ_WRITE_MODE)) {
            byte[] buf = this.text.getBytes();
            out.setLength(0);
            out.write(buf);
        }
    }

    public String getPath() {
        return this.path;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
