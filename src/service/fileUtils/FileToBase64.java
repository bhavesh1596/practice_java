package service.fileUtils;

import org.apache.commons.codec.binary.Base64;

import java.io.*;


public class FileToBase64 {
    private static final String FILE_PATH = "C:\\Users\\A707963\\Desktop\\DEV\\DSL_CR5462\\IMP_DOCS\\selfcare 3893 OCR code\\EID Front.jpg";
    public static void main(String args[]) throws IOException {

        final File frontEIDImg = new File(FILE_PATH);
        System.out.println(new FileToBase64().encodeFileToBase64Binary(FILE_PATH));
        System.out.println(new FileToBase64().encodeFileToBase64Binary(frontEIDImg));
    }

    private String encodeFileToBase64Binary(String fileName)
            throws IOException {

        File file = new File(fileName);
        byte[] bytes = loadFile(file);
        byte[] encoded = Base64.encodeBase64(bytes);
        String encodedString = new String(encoded);

        return encodedString;
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        is.close();
        return bytes;
    }


    /**
     * Method used for encode the file to base64 binary format
     * @param file
     * @return encoded file format
     */
    private String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.encodeBase64(bytes).toString();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }

}
