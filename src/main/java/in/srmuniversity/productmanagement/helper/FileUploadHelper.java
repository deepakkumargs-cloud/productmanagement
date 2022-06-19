package in.srmuniversity.productmanagement.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // static Path
    public final String UPLOAD_DIR_MAC = "/Users/ketanaggarwal/Desktop/ARDBMS/internal/productmanagement/src/main/resources/static/images";

    // Dynamic Path
    public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartfile) {
        boolean isFileExists = false;

        try {

            InputStream stream = multipartfile.getInputStream();
            byte data[] = new byte[stream.available()];
            stream.read(data);

            // write
            Files.copy(multipartfile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartfile.getOriginalFilename() + ".png"),
                    StandardCopyOption.REPLACE_EXISTING);

            isFileExists = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isFileExists;
    }
}
