package com.idbiintech.smartcontract.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class EscrowController {


	@PostMapping("/escrowPdf")
	public ResponseEntity<?> generatePdf(@RequestParam Map<String, String> map) throws IOException {

		String docxPath = "C:\\test\\escrow.docx";
		String modifiedDocxPath = "C:\\test\\test1.docx";
		String pdfPath = "C:\\test\\test.pdf";
		
		
		String sellerfirstname = map.get("sellerfirstname");
		String sellerlastname = map.get("sellerlastname");
		String purchaserfirstname = map.get("purchaserfirstname");
		String purchaserlastname = map.get("purchaserlastname");
		String propertyaddress = map.get("propertyaddress");
		String agentname = map.get("agentname");
		String amount = map.get("amount");
		String sellercompany = map.get("sellercompany");
		
		
		
		String name = "Ankita Menon";
		String age = "10";
		
		String gender = map.get("gender");
		
		System.out.println(gender);
		
		System.out.println(name);
		Resource resource = null;

		try {

			updateDocument(docxPath, modifiedDocxPath, name, age, gender);
			ConvertToPDF(modifiedDocxPath, pdfPath);

			Path path = Paths.get(pdfPath);
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		  
		  return ResponseEntity.ok()
	                .contentType(MediaType.APPLICATION_PDF)
	                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\\\"\" + resource.getFilename() + \"\\\"")
	                .body(resource);
		  
	}

	static private void updateDocument(String input, String output, String name, String age, String gender) throws IOException {

		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

			List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
			// Iterate over paragraph list and check for the replaceable text in each
			// paragraph
			for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
				for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
					String docText = xwpfRun.getText(0);
					// replacement and setting position
					docText = docText.replace("${name}", name);
					
					
					xwpfRun.setText(docText, 0);
				}
			}

			// save the docs
			try (FileOutputStream out = new FileOutputStream(output)) {
				doc.write(out);
			}

		}

	}

	public static void ConvertToPDF(String docPath, String pdfPath) {
		try {
			InputStream docFile = new FileInputStream(new File(docPath));
			XWPFDocument doc = new XWPFDocument(docFile);
			PdfOptions pdfOptions = PdfOptions.create();
			OutputStream out = new FileOutputStream(new File(pdfPath));
			PdfConverter.getInstance().convert(doc, out, pdfOptions);
			doc.close();
			out.close();
			System.out.println("Done");

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
