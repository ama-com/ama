package model;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.http.Part;

public class FileUploader {
		private Part filePart;
		private String applicationPath;
	
		public FileUploader(Part filePart, String applicationPath) {
			this.filePart = filePart;
			this.applicationPath = applicationPath;
		}
	public String fileUploader() {
//		ファイルの存在を確認し、作成する
		
		String uploadFilePath = applicationPath + File.separator + "uploads";
		File uploadDir = new File(uploadFilePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		String[] extension = filePart.getSubmittedFileName().split("[.]");
		UUID uuid = UUID.randomUUID();
		String filePath = uploadFilePath + File.separator + uuid.toString() + "."  + extension[1];
		try {
			filePart.write(filePath);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return filePath;
	}
}
