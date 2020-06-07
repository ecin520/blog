package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/5/20 21:07
 */
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public JSONObject fileUpload(@RequestParam("file") MultipartFile file){
		int begin = file.getOriginalFilename().lastIndexOf(".");
		int last = file.getOriginalFilename().length();
		String fileName = System.currentTimeMillis() + file.getOriginalFilename().substring(begin, last);
		String path = "/usr/local/webserver/nginx/html/files/"+fileName;
		try {
			OutputStream os = new FileOutputStream(path);
			InputStream is = file.getInputStream();
			int len;
			while((len=is.read())!=(-1)) {
				os.write(len);
			}
			os.flush();
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			return JsonUtil.fail();
		}
		return JsonUtil.result("http://www.pytap.com/files/"+fileName);
	}

	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	public JSONObject imageUpload(@RequestParam("file") MultipartFile file){
		int begin = file.getOriginalFilename().lastIndexOf(".");
		int last = file.getOriginalFilename().length();
		String fileName = System.currentTimeMillis() + file.getOriginalFilename().substring(begin, last);
		String path = "/usr/local/webserver/nginx/html/source/"+fileName;
		//String path = "C:\\Users\\NICE\\" + fileName;
		try {
			OutputStream os = new FileOutputStream(path);
			InputStream is = file.getInputStream();
			int len;
			while((len=is.read())!=(-1)){
				os.write(len);
			}
			os.flush();
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			return JsonUtil.fail();
		}
		return JsonUtil.result("http://www.pytap.com/source/"+fileName);
	}

}
