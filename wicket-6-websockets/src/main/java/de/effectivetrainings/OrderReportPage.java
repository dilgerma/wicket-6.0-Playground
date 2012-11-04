package de.effectivetrainings;

import org.apache.wicket.ajax.WebSocketRequestHandler;
import org.apache.wicket.event.IEvent;
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
        container.getHeaderResponse().render(JavaScriptHeaderItem.forReference(new WebSocketClientResourceReference()));
    }

    @Override
    public void onEvent(IEvent<?> event) {
        super.onEvent(event);
        Object payload = event.getPayload();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        add(new WebSocketBehavior() {
            @Override
            protected void onConnect(ConnectedMessage message) {
                super.onConnect(message);
                WicketApplication.get().getRegistry().
                        clientConnects(message.getApplication().getName(),
                                message.getSessionId(), message.getPageId());
            }

            @Override
            protected void onClose(ClosedMessage message) {
                super.onClose(message);
                WicketApplication.get().getRegistry().
                        clientDisconnects(message.getApplication().getName(),
                                message.getSessionId(), message.getPageId());
            }

            @Override
            protected void onMessage(WebSocketRequestHandler handler, TextMessage message) {
                super.onMessage(handler, message);
            }

            @Override
            protected void onMessage(WebSocketRequestHandler handler, BinaryMessage binaryMessage) {
                super.onMessage(handler, binaryMessage);
            }
        });

    }
}
