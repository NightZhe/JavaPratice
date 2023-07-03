import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class test5ZipFile {
    public static void main(String[] args) throws Exception {
        // 要壓縮的來源目錄
        String sourceDir = "/Users/ben/Documents/myjava/three/ziplo";
        // 壓縮後要放置ZIP檔的目錄
        String targetDir = "/Users/ben/Documents/myjava/three";

        File books = new File(sourceDir);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(targetDir, "total.zip")));

        // 取出來源目錄底下的所有 File 並新增至 ZIP 中
        for (File tmp : books.listFiles()) {
            checkFileType(tmp, zos, tmp.getName());
        }

        zos.finish();
        zos.close();

        books = null;

    }

    private static void checkFileType(File file, ZipOutputStream zos, String fileName) throws Exception {
        if (file.isDirectory()) {
            for (File tmp : file.listFiles()) {
                checkFileType(tmp, zos, fileName + "/" + tmp.getName());
            }
        } else {
            addZipFile(file, zos, fileName);
        }
    }

    private static void addZipFile(File file, ZipOutputStream zos, String fileName) throws IOException {
        int l;

        byte[] b = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);

        ZipEntry entry = new ZipEntry(fileName);

        zos.putNextEntry(entry);

        while ((l = fis.read(b)) != -1) {
            zos.write(b, 0, l);
        }

        entry = null;
        fis.close();
        b = null;
    }
}
