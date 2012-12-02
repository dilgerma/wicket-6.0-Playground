package de.effectivetrainings;

import de.effectivetrainings.cache.Html5CacheManifestMarkupContainer;
import de.effectivetrainings.cachedemo.CacheDemoPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.UrlResourceReference;

public class Another extends WebPage {
	private static final long serialVersionUID = 1L;

	public Another(final PageParameters parameters) {
		super(parameters);
        add(new Html5CacheManifestMarkupContainer("html", new AnotherCacheManifestModel()));
        add(new Image("image",new UrlResourceReference(Url.parse("http://svn.apache.org/repos/asf/wicket/sandbox/dashorst/animation/logo-top.png"))));
        add(new CacheDemoPanel("htmlCacheDemo"));
    }


    public static final String MOUNT_PATH = "/another.html";
}
