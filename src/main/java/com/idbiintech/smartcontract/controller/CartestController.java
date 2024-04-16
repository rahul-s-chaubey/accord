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

		String carmake = carloandto.getCarmake();
		String carmodel = carloandto.getCarmodel();
		String carcolor = carloandto.getCarcolor();
		String loanamt = carloandto.getLoanamount();
		String borrowername = carloandto.getBorrowername();
		String borroweremail = carloandto.getBorroweremail();
		String lenderemail = "rahul@gmail";
		String lenderfirstname = "rahul";
		String lendermiddlename = "rahul";
		String lenderlastname = "rahul";

		String lendername = "fghj";

		String smartcontracturul = carloandto.getSmartcontracturul();
		System.out.println(smartcontracturul);

		Resource resource = null;

		try {


			updateDocument(docxPath, modifiedDocxPath, carmake, carmodel, carcolor, loanamt, borrowername,
					borroweremail, lendername, lenderemail, smartcontracturul);

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

		
	
	private void updateDocument(String input, String output, String carmake, String carmodel, String carcolor,
	        String loanamt, String borrowername, String borroweremail, String lendername, String lenderemail,
	        String smartcontracturul) throws IOException {

	    System.out.println("ankita : " + carmake); // Ensure that carmake value is correct

	    try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {
	        List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();

	        // Iterate over each paragraph
	        for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
	            StringBuilder paragraphText = new StringBuilder();
	            List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();

	            // Iterate over each run in the paragraph
	            for (XWPFRun xwpfRun : xwpfRuns) {
	                paragraphText.append(xwpfRun.getText(0));
	            }

	            String docText = paragraphText.toString();

	            // Replace placeholders with actual values
	            docText = docText.replace("${carmake}", carmake);
	            docText = docText.replace("${carmodel}", carmodel);
	            docText = docText.replace("${carcolor}", carcolor);
	            docText = docText.replace("${loanamt}", loanamt);
	            docText = docText.replace("${borrowername}", borrowername);
	            docText = docText.replace("${borroweremail}", borroweremail);
	            docText = docText.replace("${lendername}", lendername);
	            docText = docText.replace("${lenderemail}", lenderemail);
	            docText = docText.replace("${smartcontracturul}", smartcontracturul);

	            // Set the updated text in the paragraph
	            xwpfParagraph.getRuns().forEach(run -> run.setText("", 0));
	            xwpfParagraph.createRun().setText(docText);
	        }

	        // Save the updated document
	        try (FileOutputStream out = new FileOutputStream(output)) {
	            doc.write(out);
	        }

	    } catch (IOException e) {
	        // Handle IOException
	        e.printStackTrace();
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
