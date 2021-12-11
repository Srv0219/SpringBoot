package com.api.book.springbootrestapi.Helper;

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

  /*   public final String UPLOAD_LOCATION = "C:\\Users\\ASUS\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\springbootrestapi\\src\\main\\resources\\static\\Image"; */
  public final String UPLOAD_LOCATION =  new ClassPathResource("static/Image/").getFile().getAbsolutePath();

  public FileUploadHelper() throws IOException  {   

  }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean file = false;
        try {

            InputStream is = multipartFile.getInputStream();
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            // Write

            /*
             * FileOutputStream fos = new FileOutputStream(UPLOAD_LOCATION + "\\" +
             * multipartFile.getOriginalFilename());
             * fos.write(bytes);
             * fos.close();
             * file = true;
             */

            Files.copy(
                multipartFile.getInputStream(), 
                Paths.get(UPLOAD_LOCATION + File.separator + multipartFile.getOriginalFilename()),
                     StandardCopyOption.REPLACE_EXISTING);
                     file = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
