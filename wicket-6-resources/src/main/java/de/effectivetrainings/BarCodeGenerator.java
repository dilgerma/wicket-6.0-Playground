package de.effectivetrainings;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.qrcode.EncodeHintType;
import org.apache.wicket.markup.html.image.resource.BufferedDynamicImageResource;

import javax.imageio.ImageIO;
import javax.naming.ConfigurationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author martin@effectivetrainings.de
 *         Date: 29.11.12
 *         Time: 21:42
 */
public class BarCodeGenerator {

    public BufferedImage generate(String code)  {
        BarcodeQRCode qrCode = new BarcodeQRCode(code,300,300, new HashMap<EncodeHintType, Object>());
        java.awt.Image image = qrCode.createAwtImage(Color.BLACK,Color.WHITE);
        return toBufferedImage(image);
    }

    public byte[] asRawBytes(String code){
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            ImageIO.write(generate(code), "png",bout);
            return bout.toByteArray();
        } catch (Exception e) {
            //here you should throw some kind of exception
            return new byte[0];
        }
    }

    private BufferedImage toBufferedImage(java.awt.Image image){
        BufferedImage bi = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(image, 0, 0, null);
        bg.dispose();
        return bi;

    }



}
