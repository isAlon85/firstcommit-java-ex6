package com.company;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Tag java = new Tag(1L, "Java", "Java");
        Tag spring = new Tag(2L, "Spring", "Spring");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(java);
        tags.add(spring);
        Picture picture1 = new Picture(1L, System.getProperty("user.dir") + "/src/main/resources/images/homer.png", "fake_cloudinaryid");
        Student student1 = new Student(1L, "Homer Simpson", "hsimpson@obootcamp.com", "764-84377", "United States", "Springfield", false, true);
        student1.setTags(tags);
        student1.setPicture(picture1);

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//            // Image
            PDImageXObject image = PDImageXObject.createFromFile(student1.getPicture().getUrl(), document);
            contentStream.drawImage(image, 90, 292, 115, 115);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 32);
            contentStream.newLineAtOffset(40, page.getMediaBox().getHeight() - 150);
            contentStream.showText(student1.getName());
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 15);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 190);
            contentStream.showText("Email: " + student1.getEmail());
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 15);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 230);
            contentStream.showText("Phone: " + student1.getPhone());
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 15);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 270);
            contentStream.showText("Country: " + student1.getCountry());
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 15);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 310);
            contentStream.showText("Location: " + student1.getLocation());
            contentStream.endText();
            for (int i = 0; i < student1.getTags().size(); i++) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.newLineAtOffset(40, page.getMediaBox().getHeight() - 350 - (20 * i));
                contentStream.showText("Tag " + (i + 1) + ": " + student1.getTags().get(i).getName());
                contentStream.endText();
            }

            contentStream.close();

            document.save("cv_" + student1.getName() + "_" + LocalDate.now() + "_" + LocalTime.now().getHour()
                    + "_" + LocalTime.now().getMinute() + ".pdf");
        }
    }
}
