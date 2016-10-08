package org.glasma.teafriend.web;

import org.glasma.teafriend.LoggerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/rest/files")
public class PictureRestController {

    private LoggerWrapper LOG = LoggerWrapper.get(PictureRestController.class);

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity uploadFile(@RequestParam("file") MultipartFile file/*,
                              @RequestParam("id") int id*/) {
        if (!file.isEmpty()) {
            try {
                String uploadsDir = "/uploads/";
                String realPathToUploads = request.getServletContext().getRealPath("/WEB-INF/resources".concat(uploadsDir));
                LOG.info(realPathToUploads);
                if (!new File(realPathToUploads).exists()) {
                    new File(realPathToUploads).mkdir();
                }


                String originalName = file.getOriginalFilename();
                String ext = originalName.substring(originalName.lastIndexOf("."));
                String filePath = realPathToUploads + /*id + */ originalName + ext;
                File dest = new File(filePath);
                file.transferTo(dest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
