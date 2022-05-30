package ptithcm.controller;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
@Controller
public class TestController {
    @Autowired
    Drive googleDrive;
    @RequestMapping("/testdrive")
    String test() throws IOException {
        return this.getAllGoogleDriveFiles().toString();
    }
    private Integer getAllGoogleDriveFiles() throws IOException {
        FileList result = googleDrive.files().list()
                .setFields("nextPageToken, files(id, name, parents, mimeType)")
                .execute();
        return result.getFiles().size();
    }


}
