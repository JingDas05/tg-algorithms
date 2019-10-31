package top.treegrowth.java.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 * 创建临时文件
 *
 * @author wusi
 * @since 2019-07-19 11:12
 */
public class CreateTmpFile {

    public static void main(String[] args) throws IOException {
        CreateTmpFile createTmpFile = new CreateTmpFile();
        File compressedTmpFile = createTmpFile.createTmpFile(UUID.randomUUID().toString(), "jpg");
    }

    /**
     * 海报暂存文件
     */
    private File createTmpFile(String name, String ext, File tmpDirFile) throws IOException {
        File resultFile = File.createTempFile(name, '.' + ext, tmpDirFile);
        resultFile.deleteOnExit();
        return resultFile;
    }

    /**
     * 创建临时文件
     */
    private File createTmpFile(String name, String ext) throws IOException {
        return createTmpFile(name, ext, Files.createTempDirectory("poster-java-tools-temp").toFile());
    }
}
