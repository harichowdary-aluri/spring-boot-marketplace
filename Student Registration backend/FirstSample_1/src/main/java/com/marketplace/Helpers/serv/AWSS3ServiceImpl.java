	package com.marketplace.Helpers.serv;

	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.time.LocalDateTime;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.scheduling.annotation.Async;
	import org.springframework.stereotype.Service;
	import org.springframework.web.multipart.MultipartFile;

	import com.amazonaws.AmazonServiceException;
	import com.amazonaws.services.s3.AmazonS3;
	import com.amazonaws.services.s3.model.PutObjectRequest;

	@Service
	public class AWSS3ServiceImpl implements AWSS3Service {

		private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3ServiceImpl.class);

		@Autowired
		private AmazonS3 amazonS3;
		@Value("${aws.s3.bucket}")
		private String bucketName;

		@Override
		// @Async annotation ensures that the method is executed in a different background thread
		// but not consume the main thread.
		@Async
		public String uploadFile(final MultipartFile multipartFile) {
			LOGGER.info("File upload in progress.");
			try {
				String type = multipartFile.getOriginalFilename()
						.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
				LOGGER.info(type);
				if (type.equalsIgnoreCase(".jpeg") || type.equalsIgnoreCase(".png") || type.equalsIgnoreCase(".jpg")) {
					final File file = convertMultiPartFileToFile(multipartFile);

					String url = uploadFileToS3Bucket(bucketName, file);
					LOGGER.info("File upload is completed.");
					file.delete(); // To remove the file locally created in the project folder.
					return url;
				} else {
					return null;
				}

			} catch (final AmazonServiceException ex) {
				LOGGER.info("File upload is failed.");
				LOGGER.error("Error= {} while uploading file.", ex.getMessage());
				return null;
			}
		}

		private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
			final File file = new File(multipartFile.getOriginalFilename());
			try (final FileOutputStream outputStream = new FileOutputStream(file)) {
				outputStream.write(multipartFile.getBytes());
			} catch (final IOException ex) {
				LOGGER.error("Error converting the multi-part file to file= ", ex.getMessage());
			}
			return file;
		}

		private String uploadFileToS3Bucket(final String bucketName, final File file) {
			final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
			LOGGER.info("Uploading file with name= " + uniqueFileName);
			final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
			amazonS3.putObject(putObjectRequest);
			String url = "https://" + bucketName + ".s3.us-east-2.amazonaws.com/" + uniqueFileName;
			System.out.println(url);
			return url;
		}

		@Async
		public String deleteFile(String name) {
			amazonS3.deleteObject(bucketName, name);
			return name + " Successfully deleted";
		}

		public String getImageLinks(MultipartFile[] files) {
			String images = "";
			for (MultipartFile multipart : files) {
				String fileName = multipart.getOriginalFilename();

				String message = "";

				try {
					String url = uploadFile(multipart);
					images += url != null ? url + " " : "https://dummyimage.com/300 ";
//                images += s3service.getImageLink(multipart)+" ";
					message = "Your file has been uploaded successfully!";

				} catch (Exception ex) {
					message = "Error uploading file: " + ex.getMessage();
				}
			}
			return images;
		}
	}
