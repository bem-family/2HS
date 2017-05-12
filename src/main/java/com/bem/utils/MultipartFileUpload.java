package com.bem.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;


public class MultipartFileUpload {
	
	public void MultipartFile(MultipartFile mfile){
		String mFileName = new Date().getTime() + mfile.getOriginalFilename();	// 文件名
		// 储存缓存文件地址
		String Path = Class.class.getClass().getResource("/").getPath() + "static/images/";
		File file = new File(Path);
		// 创建文件夹
		if (!file.isDirectory()) {
			file.mkdir();
		}
		String imageFilePath = Path + mFileName;
		// 移动文件夹到指定目录
		if (mfile.isEmpty()) {

		} else {
			File mImageFile = new File(imageFilePath);
			try {
				mfile.transferTo(mImageFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
}
