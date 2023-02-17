package com.marketplace.Helpers.serv;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

	String uploadFile(MultipartFile multipartFile);
	String getImageLinks(MultipartFile[] multipartFiles);
	String deleteFile(String filename);

}
