package FolderFiles;

import java.io.File;
import javax.swing.JFileChooser;
import static FolderFiles.Utils.selectAFolderDialog;

public class FileStats {
    public static int directoriesVisited = 0, filesVisited = 0;

    public static void listFilesForFolder(File folder) {
        File[] entries = folder.listFiles();
        if (entries == null) {
            return;
        }
        for (File fileEntry : entries) {
            if (fileEntry.isDirectory()) {
                directoriesVisited++;
                listFilesForFolder(fileEntry);
            } else {
                filesVisited++;
            }
        }
    }
    public static void main(String[] args) {
        String s = selectAFolderDialog(JFileChooser.DIRECTORIES_ONLY);
        if (s.isEmpty()) return;
        File folder = new File(s);
        listFilesForFolder(folder);
        System.out.println("Directories Visited: " + directoriesVisited);
        System.out.println("Files Visited: " + filesVisited);

    }
}