package de.effectivetrainings;

import org.apache.wicket.ajax.WebSocketRequestHandler;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.protocol.ws.api.WebSocketBehavior;
import org.apache.wicket.protocol.ws.api.message.BinaryMessage;
import org.apache.wicket.protocol.ws.api.message.ClosedMessage;
import org.apache.wicket.protocol.ws.api.message.ConnectedMessage;
import org.apache.wicket.protocol.ws.api.message.TextMessage;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * @author martindilger
 *         Date: 31.10.12
 *         Time: 14:56
 */
public class OrderReportPage extends WebPage {


    @Override
    public void renderHead(HtmlHeaderContainer container) {
        super.renderHead(container);
        container.getHeaderResponse().render(new JQueryVisualizePlugin());
        container.getHeaderResponse().render(new OnDomReadyHeaderItem("$('table').visualize();"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

    }
}
