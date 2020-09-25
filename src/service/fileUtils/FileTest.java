package service.fileUtils;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String args[]) throws IOException {
        File dirFile = new File("C:\\Users\\A707963\\Desktop\\tempFiles");
        File[] files = getAllFilesInDir(dirFile);
        printCSVFilesOnly(files);
        printAllFileExactPaths(files);

    }

    private static void printAllFileExactPaths(File[] files) throws IOException {
        if( null != files && files.length>0 ) {
            System.out.println("File paths are :\n");
            for (File file : files) {
                if (null != file) {
                    String canonicalPath = file.getCanonicalPath();
                    System.out.println(canonicalPath +"\n");
                }
            }
        }
    }

    private static void printCSVFilesOnly(File[] files) {
        if( null != files && files.length>0 ) {
            for (File file : files) {
                if (null != file) {
                    String extension = getFileExtension(file);
                    if (null != extension) {
                        if ("csv".equalsIgnoreCase(extension)) {
                            System.out.println("File "+file.getName().substring(0,file.getName().lastIndexOf('.'))+" good for processing");
                        }
                    }
                }
            }
        }
    }

    private static String getFileExtension(File file) {
        String extension = null;
        if(null != file) {
            String fileName = file.getName();
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                extension = fileName.substring(i+1);
            }
        }
        return extension;
    }

    private static File[] getAllFilesInDir(File file) {
        File[] files = null;
        if( file.isDirectory() ) {
            files = file.listFiles();
        }
        return files;
    }
}
