package com.kartasista.kartasista.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file) {
		try {
			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			System.out.println(realPath);
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			return baseFolder + "/" + file.getOriginalFilename();

		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(String foto) {
		String realPath = request.getServletContext().getRealPath("/");
		File file = new File(realPath + foto);
		boolean result = file.delete();
		if (result) {
			System.out.println("File is successfully deleted.");
		} else {
			System.out.println("File deletion failed.");
		}
	}

}
