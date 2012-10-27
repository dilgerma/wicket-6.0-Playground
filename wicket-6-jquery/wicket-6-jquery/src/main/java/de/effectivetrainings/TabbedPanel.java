package de.effectivetrainings;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.JavaScriptPackageResource;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.Locale;

/**
 * @author martindilger
 *         Date: 27.10.12
 *         Time: 14:29
 */
public class TabbedPanel extends Panel {
    public TabbedPanel(String id) {
        super(id);
    }

    @Override
    public void renderHead(HtmlHeaderContainer container) {
        super.renderHead(container);
        container.getHeaderResponse().render(new JQueryUIResourceReference());
        container.getHeaderResponse().render(
                JavaScriptHeaderItem.forReference(
                        new PackageResourceReference(TabbedPanel.class, "tabbed-script.js")));
    }
}
