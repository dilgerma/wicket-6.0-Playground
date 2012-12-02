package de.effectivetrainings.cachedemo;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.Arrays;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 13:50
 */
public class CacheDemoPanel extends Panel {

    public CacheDemoPanel(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
    }

    @Override
    public void renderHead(HtmlHeaderContainer container) {
        super.renderHead(container);
        ResourceReference ref = new PackageResourceReference(CacheDemoPanel.class,"CacheDemoPanel.js"){
            @Override
            public Iterable<? extends HeaderItem> getDependencies() {
                return Arrays.asList(JavaScriptHeaderItem.forReference(JQueryResourceReference.get()));
            }
        };
        container.getHeaderResponse().render(JavaScriptHeaderItem.forReference(ref));


    }
}

