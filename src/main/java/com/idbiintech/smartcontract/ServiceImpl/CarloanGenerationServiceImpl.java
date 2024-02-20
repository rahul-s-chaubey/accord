package com.idbiintech.smartcontract.ServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import com.idbiintech.smartcontract.DTO.CarloanDTO;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;



@Service
public class CarloanGenerationServiceImpl {

	
	public static void updateDocument(CarloanDTO carloandto) throws IOException {
		
		String input = "C:\\test\\carloan.docx";
		String output  = "C:\\test\\test1.docx";
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
		
		
		
		
		System.out.println("Here");
		
		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

			List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
			// Iterate over paragraph list and check for the replaceable text in each
			// paragraph
			for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
				for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
					String docText = xwpfRun.getText(0);
					// replacement and setting position

					docText = docText.replace("${carmake}", carloandto.getCarmake());
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
		
		System.out.println("here too");
		
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
