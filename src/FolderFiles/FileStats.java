package FolderFiles;

import java.io.File;

public class FileStats {
    public static void listFilesForFolder(File folder) {
        File[] entries = folder.listFiles();
        if (entries == null) {
            return;
        }
        for (File fileEntry : entries) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\XamZer0\\Desktop\\Java_Projects\\src");
        listFilesForFolder(folder);
    }
}
