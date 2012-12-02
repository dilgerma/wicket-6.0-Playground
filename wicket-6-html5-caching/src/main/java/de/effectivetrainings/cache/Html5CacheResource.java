package de.effectivetrainings.cache;

import org.apache.wicket.Page;
import org.apache.wicket.request.resource.AbstractResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.util.io.IOUtils;
import org.apache.wicket.util.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;

/**
 * @author martindilger
 *         Date: 01.12.12
 *         Time: 17:19
 */
public class Html5CacheResource extends PackageResource {

    private static final Logger LOG = LoggerFactory.getLogger(Html5CacheResource.class);


    public Html5CacheResource(Class<? extends Page> scope, Locale locale, String style, String variation) {
        super(scope, scope.getSimpleName() + ".manifest", locale, style, variation);
        setTextEncoding("utf-8");
        setCachingEnabled(false);
    }

    @Override
    protected byte[] processResponse(Attributes attributes, byte[] original) {
        try {
            String manifest = IOUtils.toString(new ByteArrayInputStream(original));
            return IOUtils.toByteArray(new StringReader(generateManifest(manifest)));
        } catch (Exception e) {
            LOG.warn("Cannot create cache manifest");
        }
        return original;
    }

    @Override
    protected void setResponseHeaders(ResourceResponse data, Attributes attributes) {
        super.setResponseHeaders(data, attributes);
        data.getHeaders().addHeader("Pragma", "no-cache");
        data.getHeaders().addHeader("Cache-Control",
                "no-cache, max-age=0, must-revalidate, no-store");
    }

    /**
     * override this to process your manifest
     *
     * @param template
     * @return
     */
    protected String generateManifest(String template) {
        return template;
    }
}
