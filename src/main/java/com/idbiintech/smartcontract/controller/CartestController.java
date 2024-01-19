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

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.ServiceImpl.CarloanServiceImpl;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

@CrossOrigin
@Controller 
@RequestMapping("/api")
public class CartestController {
	
	@Autowired
	CarloanServiceImpl CarloanServiceImpl;

	@PostMapping("/viewcarloanPdf")
	public ResponseEntity<?> viewcarloanagreement(CarloanDTO carloandto) throws IOException {

		String docxPath = "C:\\test\\carloan.docx";
		String modifiedDocxPath = "C:\\test\\test1.docx";
		String pdfPath = "C:\\test\\test.pdf";

		String carmake = "Audi";
		String carmodel = "Audi";
		String carcolor = "white";
		String loanamt = "100000";
		String borrowername = "Ankita";
		String borroweremail = "ankita@gmail.com";
		String lenderemail = "rahul@gmail";
		String lenderfirstname = "rahul";
		String lendermiddlename = "rahul";
		String lenderlastname = "rahul";
		
		String lendername = "fghj";

		

		
		Resource resource = null;

		try {

			updateDocument(docxPath, modifiedDocxPath, carmake, carmodel, carcolor,loanamt,borrowername,borroweremail,lendername,lenderemail);
			ConvertToPDF(modifiedDocxPath, pdfPath);

			Path path = Paths.get(pdfPath);
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\\\"\" + resource.getFilename() + \"\\\"")
				.body(resource);

	}

	static private void updateDocument(String input, String output, String carmake, String carmodel, String carcolor, String loanamt,String borrowername,String borroweremail,String lendername,String lenderemail)
			throws IOException {

		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

			List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
			// Iterate over paragraph list and check for the replaceable text in each
			// paragraph
			for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
				for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
					String docText = xwpfRun.getText(0);
					// replacement and setting position

					docText = docText.replace("${carmake}", carmake);

					docText = docText.replace("${carmodel}", carmodel);

					docText = docText.replace("${carcolor}", carcolor);
					docText = docText.replace("${loanamt}", loanamt);
					docText = docText.replace("${borrowername}", borrowername);
					docText = docText.replace("${borroweremail}", borroweremail);
					docText = docText.replace("${lendername}", lendername);
					docText = docText.replace("${lenderemail}", lenderemail);

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
