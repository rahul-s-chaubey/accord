//package com.idbiintech.smartcontract.controller;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
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
//public class OCRController {
//	
//	
//	  private String word;
//
//	@PostMapping("/ocr")
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
//	            System.out.println(text);
//	            // Close document
//	            document.close();
//
//	            String[] wordsBeforeUnderscores = extractWordsBeforeUnderscores(text);
//	            
//	            System.out.println("Words before underscores:");
//	            for (String word : wordsBeforeUnderscores) {
//	                System.out.println(word);
//	            }
//
//				return word;
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return "Error extracting words before spaces from PDF";
//	        }
//	
//	  }
//
//	  public static String[] extractWordsBeforeUnderscores(String text) {
//	        List<String> wordsBeforeUnderscores = new ArrayList<>();
//	        Pattern pattern = Pattern.compile("([\\S]+)\\s*[_]+\\s*");
//	        Matcher matcher = pattern.matcher(text);
//
//	        while (matcher.find()) {
//	            wordsBeforeUnderscores.add(matcher.group(1));
//	        }
//
//	        return wordsBeforeUnderscores.toArray(new String[0]);
//	    }
//
//}
