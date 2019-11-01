package edu.ssafy.boot.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {

	@RequestMapping("/fileuploadpage")
	public String fileUploadPage() {
		return "fileuploadpage";
	}
	
	@RequestMapping("/fileupload")
	public @ResponseBody Map<String, String> fileUpload(HttpServletRequest req) {
		String path = "c:/aaa";
		Map<String, String> resObj = new HashMap<String, String>();
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
		Iterator<String> fileNames = mhsr.getFileNames();
		File f = new File(path);
		if (!f.isDirectory()) {
			f.mkdirs();
		}
		try {
			while (fileNames.hasNext()) {
				String fileName = fileNames.next();
				MultipartFile file = mhsr.getFile(fileName);
				// encoding 필요하다
				String oriName = new String(file.getOriginalFilename().getBytes("UTF-8"), "UTF-8");
				//String ext = oriName.substring(oriName.lastIndexOf("."));
				String saveFileName = oriName;//+ext;
				File serverFile = new File(path+File.separator+saveFileName);
				file.transferTo(serverFile);
				resObj.put("resmsg", "file transfer success");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resObj;
	}
}
