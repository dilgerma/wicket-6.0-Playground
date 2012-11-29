package de.effectivetrainings;

import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * @author martindilger
 *         Date: 29.11.12
 *         Time: 22:22
 */
public class QRResource extends DynamicImageResource {

    public static final String VARIABLE = "code";

    private BarCodeGenerator generator;

    public QRResource(){
        generator = new BarCodeGenerator();
    }

    @Override
    protected byte[] getImageData(Attributes attributes) {
        String code = attributes.getParameters().get(VARIABLE).toString();
        return generator.asRawBytes(code);
    }

    public static ResourceReference asReference(){
        return new ResourceReference("qr"){

            @Override
            public IResource getResource() {
                return new QRResource();
            }
        };
    }
}
