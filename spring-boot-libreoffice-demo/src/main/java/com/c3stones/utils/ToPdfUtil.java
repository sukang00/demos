package com.c3stones.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Description
 * @Author sukang
 * @Date 2022-07-06 10:18
 * @Version 1.0
 */
public class ToPdfUtil {

    public static void addWaterMark(String pdfFilePath, String outputFilePath) {

        try {
            // 原PDF文件
            PdfReader reader = new PdfReader(pdfFilePath);
            // 输出的PDF文件内容
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFilePath));
            // 字体 来源于 itext-asian JAR包
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", true);

            PdfGState gs = new PdfGState();
            // 设置透明度
            gs.setFillOpacity(0.3f);
            gs.setStrokeOpacity(0.4f);

            int totalPage = reader.getNumberOfPages() + 1;
            for (int i = 1; i < totalPage; i++) {
                // 内容上层
//			PdfContentByte content = stamper.getOverContent(i);
                // 内容下层
                PdfContentByte content = stamper.getUnderContent(i);

                content.beginText();
                // 字体添加透明度
                content.setGState(gs);
                // 添加字体大小等
                content.setFontAndSize(baseFont, 50);
                // 添加范围
                content.setTextMatrix(70, 200);
                // 具体位置 内容 旋转多少度 共360度
                content.showTextAligned(Element.ALIGN_CENTER, "机密文件", 300, 350, 300);
                content.showTextAligned(Element.ALIGN_TOP, "机密文件", 100, 100, 5);
                content.showTextAligned(Element.ALIGN_BOTTOM, "机密文件", 400, 400, 75);

                content.endText();
            }

            // 关闭
            stamper.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void addWaterMark(String pdfFilePath, OutputStream outputStream) {

        try {
            // 原PDF文件
            PdfReader reader = new PdfReader(pdfFilePath);
            // 输出的PDF文件内容
            PdfStamper stamper = new PdfStamper(reader, outputStream);
            // 字体 来源于 itext-asian JAR包
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", true);

            PdfGState gs = new PdfGState();
            // 设置透明度
            gs.setFillOpacity(0.3f);
            gs.setStrokeOpacity(0.4f);

            int totalPage = reader.getNumberOfPages() + 1;
            String waterMarkName = "机密文件";
            JLabel label = new JLabel();
            FontMetrics metrics;
            Rectangle pageRect;
            int textH;
            int textW;
            label.setText(waterMarkName);
            metrics = label.getFontMetrics(label.getFont());
            //得到文字的宽高
            textH = metrics.getHeight();
            textW = metrics.stringWidth(label.getText());
            for (int i = 1; i < totalPage; i++) {
                pageRect = reader.getPageSizeWithRotation(i);
                // 内容上层
			    PdfContentByte content = stamper.getOverContent(i);
                // 内容下层
//                PdfContentByte content = stamper.getUnderContent(i);

                content.beginText();
                // 字体添加透明度
                content.setGState(gs);
                // 添加字体大小等
                content.setFontAndSize(baseFont, 12);
                //设置水印文字颜色
                content.setColorFill(BaseColor.LIGHT_GRAY);
                // 添加范围
//                content.setTextMatrix(70, 200);
                // 具体位置 内容 旋转多少度 共360度
//                content.showTextAligned(Element.ALIGN_CENTER, "机密文件", 300, 350, 5);
//                content.showTextAligned(Element.ALIGN_TOP, "机密文件", 100, 100, 5);
//                content.showTextAligned(Element.ALIGN_BOTTOM, "机密文件", 400, 400, 5);
                int position = 0;
                int interval = -3;
                for (int height = interval + textH; height < pageRect.getHeight(); height = height + textH * 3) {
                    for (int width = interval + textW -position * 150; width < pageRect.getWidth() + textW; width = width + textW) {
                        //添加水印文字，水印文字成25度角倾斜
                        content.showTextAligned(Element.ALIGN_LEFT, waterMarkName, width - textW , height - textH, 25);
                    }
                    position++;
                }
                content.endText();
            }

            // 关闭
            stamper.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
