package com.idbiintech.smartcontract.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")

public class TemplateUploadController {

	@PostMapping("/temp")
	public ResponseEntity<?> uploadtemplate(@RequestParam("file") MultipartFile file) {

		Map<String, Object> response = new HashMap<>();
		long Count = 0;

		String filename = file.getOriginalFilename();
		System.out.println("filename" + filename);

		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();

		String sysdate = date.format(now);

		System.out.println(date.format(now));

		System.out.println("==============================================================");
		System.out.println("saving files to temp folder");
		System.out.println("==============================================================");

		try {
			String uploadPath = "C:\\template";

			// Create the directory if it doesn't exist
			File directory = new File(uploadPath);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			// Save the file to the specified path
			Path targetPath = new File(uploadPath, file.getOriginalFilename()).toPath();
			Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

			System.out.println("File uploaded and stored successfully");

		} catch (IOException e) {
			e.printStackTrace();

			System.out.println("Failed to upload and store file");

		}

		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	/*
	 * @GetMapping("/viewtemplate") public ResponseEntity<?> viewtemplate() throws
	 * IOException {
	 * 
	 * String pdfPath = "C:\\template\\Personal-loan-agreement-template.pdf";
	 * 
	 * Resource resource = null;
	 * 
	 * try {
	 * 
	 * Path path = Paths.get(pdfPath); resource = new UrlResource(path.toUri()); }
	 * catch (MalformedURLException e) { e.printStackTrace(); }
	 * 
	 * return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
	 * .header(HttpHeaders.CONTENT_DISPOSITION,
	 * "inline; filename=\\\"\" + resource.getFilename() + \"\\\"") .body(resource);
	 * 
	 * }
	 */

	private static final String FILE_DIRECTORY = "C:\\template";

	@GetMapping("/viewtemplate")
	public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName) {
		System.out.println("fileName" + fileName);

		try {
			Path filePath = Paths.get(FILE_DIRECTORY).resolve(fileName);
			Resource resource = new UrlResource(filePath.toUri());

			if (resource.exists() && resource.isReadable()) {
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
						.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\\\"\" + resource.getFilename() + \"\\\"")
						.body(resource);

				// The application/octet-stream MIME type is used for unknown binary files.
				// the Content-Disposition response header is a header indicating if the content
				// is expected to be displayed inline in the browser
				// it taked only two types attachment and inline
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (MalformedURLException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}