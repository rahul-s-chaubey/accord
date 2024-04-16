//package com.idbiintech.smartcontract.controller;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import net.sourceforge.tess4j.Tesseract;
//
//@RestController
//@RequestMapping("/api")
//public class TestOCRController {
//	
//	
//	  private String word;
//
//	@PostMapping("/testocr")
//	  public String readtemplate(@RequestParam("file") MultipartFile file) {
//		  
//		  try {
//	            // Load PDF file
//	            ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
//	            PDDocument document = PDDocument.load(inputStream);
//
//	            // Initialize Tesseract OCR
//	            Tesseract tesseract = new Tesseract();
//	            tesseract.setDatapath("C:\\Program Files\\Tess4J\\tessdata"); // Set path to Tesseract data directory
//
//	            // Extract text from PDF
//	            PDFTextStripper stripper = new PDFTextStripper();
//	            String text = stripper.getText(document);
//	          
//	            // Close document
//	            document.close();
//
//	            Map<String, String> wordsBeforeUnderscores = extractWordsBeforeUnderscores(text);
//	            
//	            System.out.println("wordsBeforeUnderscores");
//	            
//	            System.out.println(wordsBeforeUnderscores);
//	            
//	            Map<String, String> loanAgreementMap = new HashMap<>();
//	            loanAgreementMap.put("borrowername", "ankita");
//	            loanAgreementMap.put("enddate", "12-04-2023");
//	            loanAgreementMap.put("penalty", "1000");
//	            loanAgreementMap.put("penaltydate_", "12-08-2023");
//	            loanAgreementMap.put("lenderemail", "ankita@gmail.com");
//	            loanAgreementMap.put("startdate", "12-04-2023");
//	            loanAgreementMap.put("lendername", "ankita");
//	            loanAgreementMap.put("borroweremail", "ankita@gmail");
//	            loanAgreementMap.put("interest", "92");
//	            loanAgreementMap.put("monthlypayment", "100");
//	            
//	            
//	            Map<String, String> oldMap = new HashMap<>();
//	            oldMap.put("borrowername", "borrowername");
//	            oldMap.put("enddate", "enddate");
//	            oldMap.put("penalty", "penalty");
//	            oldMap.put("penaltydate_", "penaltydate_");
//	            oldMap.put("lenderemail", "lenderemail");
//	            oldMap.put("startdate", "startdate");
//	            oldMap.put("lendername", "lendername");
//	            oldMap.put("borroweremail", "borroweremail");
//	            oldMap.put("interest", "interest");
//	            oldMap.put("monthlypayment", "monthlypayment");
//	            
//	            
//	            
//	            
//	            // Replace specific text using maps
//	            String replacedString = replaceUsingMaps(text, loanAgreementMap);
//	            
//	            System.out.println("After replacing using maps: " + replacedString);  
//	            
//	            
//	            
////	          pdf
//	            
//	            String folderPath = "C:\\Users\\Ankita\\Desktop\\smartcontractdump";
//
//	            try (PDDocument document1 = new PDDocument()) {
//	                PDPage page = new PDPage();
//	                document1.addPage(page);
//
//	                try (PDPageContentStream contentStream = new PDPageContentStream(document1, page)) {
//	                    contentStream.setFont(PDType1Font.HELVETICA, 12);
//	                    contentStream.beginText();
//	                    contentStream.newLineAtOffset(50, 700);
//	                    contentStream.showText(replacedString);
//	                    contentStream.endText();
//	                }
//
//	                // Create the folder if it doesn't exist
//	                File folder = new File(folderPath);
//	                if (!folder.exists()) {
//	                    folder.mkdirs(); // Create all necessary directories
//	                }
//
//	                // Save the PDF to the specified folder
//	                String filePath = folderPath + "auto_loan_agreement.pdf";
//	                document1.save(filePath);
//	                System.out.println("PDF created successfully at: " + filePath);
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	            
//	            
//
//				return word;
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return "Error extracting words before spaces from PDF";
//	        }
//	
//	  }
//
//	 public static String replaceUsingMaps(String originalString, Map<String, String> replaceMap) {
//	        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
//	            String oldValue = entry.getKey();
//	            String newValue = entry.getValue();
//	            originalString = originalString.replaceAll("\\b" + oldValue + "\\b", newValue);
//	        }
//	        return originalString;
//	    }
//	 
//	 
//	 
//
//	public static Map<String, String> extractWordsBeforeUnderscores(String text) {
//        Map<String, String> wordsBeforeUnderscores = new HashMap<>();
//        Pattern pattern = Pattern.compile("([\\S]+)\\s*[_]+\\s*");
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()) {
//            String keyword = matcher.group(1);
//            wordsBeforeUnderscores.put(keyword, keyword);
//        }
//
//        return wordsBeforeUnderscores;
//    }
//
//	
//	
//	
//}
