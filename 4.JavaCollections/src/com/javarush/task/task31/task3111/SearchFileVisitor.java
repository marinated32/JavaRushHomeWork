package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName, partOfContent;
    private int minSize, maxSize;
    private List<Path> foundFiles = new ArrayList<> (  );

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if ((partOfName == null || file.getFileName().toString().contains(partOfName))
                && (partOfContent == null || new String(content).contains(partOfContent))
                && (minSize == 0 || content.length > minSize)
                && (maxSize == 0 || content.length < maxSize)){
            foundFiles.add(file);
        }

//        if (!(partOfName.isEmpty ())) {
//            if (file.toString ().contains ( partOfName )) {
//                foundFiles.add ( file );
//            }
//        }
//
//        if (!(partOfContent.isEmpty ())) {
//            if (Arrays.toString (content).contains ( partOfContent )) {
//                foundFiles.add ( file );
//            }
//        }
//
//        if (minSize > 0) {
//            if (content.length > minSize) {
//                foundFiles.add ( file );
//            }
//        }
//        if (maxSize > 0) {
//            if (content.length < maxSize) {
//                foundFiles.add ( file );
//            }
//        }

        return super.visitFile(file, attrs);
    }
}
