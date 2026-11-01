package FolderFiles;

import java.io.File;
import javax.swing.JFileChooser;

class Utils {

    /**
     * Dialog for selecting a folder
     * mode: JFileChooser.DIRECTORIES_ONLY,
     * @return
     */
    public static String selectAFolderDialog(int mode) {
        String filePath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(mode); // JFileChooser.DIRECTORIES_ONLY
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePath = selectedFile.getAbsolutePath();
            System.out.println("Selected file/folder: " + filePath);
        }
        return filePath;
    }
}
