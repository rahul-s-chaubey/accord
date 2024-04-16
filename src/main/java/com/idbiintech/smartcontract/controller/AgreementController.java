package com.idbiintech.smartcontract.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.idbiintech.smartcontract.DTO.TemplateCarloanDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import net.sourceforge.tess4j.Tesseract;

@RestController
@RequestMapping("/api")
public class AgreementController {
	
	
	 
	@PostMapping(value = "/testocr")
	  public String readtemplate(@RequestParam(value = "file",required = false) MultipartFile file,
			  TemplateCarloanDTO TemplateCarloanDTO) throws DocumentException {
		  
	
		System.out.println(TemplateCarloanDTO.getCarmake());
		
		  try {
	            // Load PDF file
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
	            PDDocument document = PDDocument.load(inputStream);

	            // Initialize Tesseract OCR
	            Tesseract tesseract = new Tesseract();
	            tesseract.setDatapath("C:\\Program Files\\Tess4J\\tessdata"); // Set path to Tesseract data directory

	            // Extract text from PDF
	            PDFTextStripper stripper = new PDFTextStripper();
	            String text = stripper.getText(document);
	          
	            // Close document
	            document.close();

	            Map<String, String> wordsBeforeUnderscores = extractWordsBeforeUnderscores(text);
	            
	            System.out.println("wordsBeforeUnderscores");
	            
	            System.out.println(wordsBeforeUnderscores);
	            
	            Map<String, String> loanAgreementMap = new HashMap<>();
	            loanAgreementMap.put("borrowername", "ankita");
	            loanAgreementMap.put("enddate", "12-04-2023");
	            loanAgreementMap.put("penalty", "1000");
	            loanAgreementMap.put("penaltydate_", "12-08-2023");
	            loanAgreementMap.put("lenderemail", "ankita@gmail.com");
	            loanAgreementMap.put("startdate", "12-04-2023");
	            loanAgreementMap.put("lendername", "ankita");
	            loanAgreementMap.put("borroweremail", "ankita@gmail");
	            loanAgreementMap.put("interest", "92");
	            loanAgreementMap.put("monthlypayment", "100");
	            loanAgreementMap.put("carmake", "audi");
	            loanAgreementMap.put("carmodel", "audi");
	            loanAgreementMap.put("caryear", "2024");
	            loanAgreementMap.put("carcolor", "white");
	            loanAgreementMap.put("carstyle", "sedan");
	            loanAgreementMap.put("cardrive", "manual");
	            loanAgreementMap.put("loanamount", "1000");
	            loanAgreementMap.put("date", "12-02-2024");
	            
	            
	            Map<String, String> oldMap = new HashMap<>();
	            oldMap.put("borrowername", "borrowername");
	            oldMap.put("enddate", "enddate");
	            oldMap.put("penalty", "penalty");
	            oldMap.put("penaltydate_", "penaltydate_");
	            oldMap.put("lenderemail", "lenderemail");
	            oldMap.put("startdate", "startdate");
	            oldMap.put("lendername", "lendername");
	            oldMap.put("borroweremail", "borroweremail");
	            oldMap.put("interest", "interest");
	            oldMap.put("monthlypayment", "monthlypayment");
	            oldMap.put("carmake", "carmake");
	            oldMap.put("carmodel", "carmodel");
	            oldMap.put("caryear", "caryear");
	            oldMap.put("carcolor", "carcolor");
	            oldMap.put("carstyle", "carstyle");
	            oldMap.put("cardrive", "cardrive");
	            oldMap.put("loanamount", "loanamount");
	            oldMap.put("date", "date");
	            
	            
	            
	            
	            // Replace specific text using maps
	            String replacedString = replaceUsingMaps(text, loanAgreementMap);
	            
	            System.out.println("After replacing using maps: " + replacedString);  
	            
	            
	            
//	          pdf
	            
	            String filePath = "C:\\Users\\Ankita\\Desktop\\smartcontractdump\\test.txt";
	            FileWriter writer = null;
	            
	            File fileToBeModified = new File(filePath);

	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(replacedString);
	           
                
                writer.close();
                
                
                Document document1 = new Document();
                PdfWriter.getInstance(document1, new FileOutputStream("C:\\Users\\Ankita\\Desktop\\smartcontractdump\\testocr_"+System.currentTimeMillis()+".pdf"));

                document1.open();
                Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
                Chunk chunk = new Chunk(replacedString, font);
                
//                document1.add(new Paragraph(chunk));
                
                String[] lines = replacedString.split("\\r?\\n");
                
                Paragraph paragraph = new Paragraph();
                paragraph.setFirstLineIndent(160); // Set the first-line indent

                // Iterate through each line
                for (int i = 0; i < lines.length; i++) {
                    Chunk chunk1;
                    // Apply bold to the first line
                    if (i == 0) {
                        Font boldFont = new Font(font);
                        boldFont.setStyle(Font.BOLD);
                        int fontSize = 14;
						boldFont.setSize(fontSize  + 4);
                        chunk1 = new Chunk(lines[i], boldFont);
                    } else {
                        chunk1 = new Chunk(lines[i], font);
                    }
                    paragraph.add(chunk1);
                    
                    // Add a new line if it's not the last line
                    if (i < lines.length - 1) {
                        paragraph.add(Chunk.NEWLINE);
                    }
                }

                document1.add(paragraph);
                               
                
//                document1.add(Chunk.NEWLINE);
                document1.close();
                
	            

				return "sucess";
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error extracting words before spaces from PDF";
	        }
	
	  }

	
	/////////////////////////////////////////* replace words *///////////////////////////////////////////////////////////////

	
	
	 public static String replaceUsingMaps(String originalString, Map<String, String> replaceMap) {
	        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
	            String oldValue = entry.getKey();
	            String newValue = entry.getValue();
	            originalString = originalString.replaceAll("\\b" + oldValue + "\\b", newValue);
	        }
	        return originalString;
	    }
	 
	 
	 
		/////////////////////////////////////////* save document *///////////////////////////////////////////////////////////////
	 
	 private static void saveDocument(XWPFDocument document, String filePath) throws IOException {
	        FileOutputStream out = new FileOutputStream(new File(filePath));
	        document.write(out);
	        out.close();
	    }
	 
	 
	 
	 
		/////////////////////////////////////////* words before dash *///////////////////////////////////////////////////////////////	 
	 
	 

	public static Map<String, String> extractWordsBeforeUnderscores(String text) {
        Map<String, String> wordsBeforeUnderscores = new HashMap<>();
        Pattern pattern = Pattern.compile("([\\S]+)\\s*[_]+\\s*");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String keyword = matcher.group(1);
            wordsBeforeUnderscores.put(keyword, keyword);
        }

        return wordsBeforeUnderscores;
    }

	
	
	
}
