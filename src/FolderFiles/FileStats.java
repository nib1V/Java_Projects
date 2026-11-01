package FolderFiles;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import static FolderFiles.Utils.selectAFolderDialog;

public class FileStats {
    public static int directoriesVisited = 0, filesVisited = 0;
    public static ArrayList<String> imagePathNames = new ArrayList<>();

    public static void listFilesForFolder(File folder) {
        File[] entries = folder.listFiles();
        MakeHTML(entries);
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

    public static void MakeHTML(File[] files){
        PrintWriter writer;
        try {
            writer = new PrintWriter("images.html");
            writer.println("<!DOCTYPE html>\n<html>\n\t<body>");
            for (int i = 0; i < files.length; i++) {
                String fileType = files[i].getAbsolutePath();
                if (fileType.endsWith(".png") || fileType.endsWith(".jpg") || fileType.endsWith("jpeg")){
                    imagePathNames.add(files[i].getAbsolutePath());
                    writer.println("\t\t<img src=\""+ files[i].toURI() +"\" alt=\"aa\" height=\"250\">");
                }
            }
            writer.println("\t</body>\n</html>");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }

    public static void main(String[] args) {
        String s = selectAFolderDialog(JFileChooser.DIRECTORIES_ONLY);
        if (s.isEmpty()) return;
        File folder = new File(s);
        listFilesForFolder(folder);
        GUIskeleton GUI = new GUIskeleton(imagePathNames);
        System.out.println("Directories Visited: " + directoriesVisited);
        System.out.println("Files Visited: " + filesVisited);
    }
}