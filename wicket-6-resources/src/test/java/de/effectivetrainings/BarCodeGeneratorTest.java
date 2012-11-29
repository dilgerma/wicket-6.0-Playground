package de.effectivetrainings;

import org.junit.Test;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author martindilger
 *         Date: 29.11.12
 *         Time: 21:40
 */
public class BarCodeGeneratorTest {

    @Test
    public void testGenerateQRCode() throws Exception{
        byte[] raw = new BarCodeGenerator().asRawBytes("http://www.effectivetrainings.de");
        File outputfile = new File("/User/saved.png");
        FileOutputStream fout = new FileOutputStream(outputfile);
        fout.write(raw);

    }
}
