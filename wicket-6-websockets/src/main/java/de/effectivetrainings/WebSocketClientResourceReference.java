package de.effectivetrainings;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.protocol.ws.api.WicketWebSocketJQueryResourceReference;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author martindilger
 *         Date: 31.10.12
 *         Time: 17:32
 */
public class WebSocketClientResourceReference extends PackageResourceReference {
    public WebSocketClientResourceReference() {
        super(HomePage.class, "orderreport-client.js");
    }

    @Override
    public Iterable<? extends HeaderItem> getDependencies() {
        List<HeaderItem> headerItems = new ArrayList<HeaderItem>();
        headerItems.add(JavaScriptHeaderItem.forReference(WicketWebSocketJQueryResourceReference.get()));
        return headerItems;
    }
}
