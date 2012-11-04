package de.effectivetrainings;

import de.effectivetrainings.connections.ClientConnection;
import de.effectivetrainings.domain.Food;
import de.effectivetrainings.domain.Order;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.WebSocketRequestHandler;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JsonUtils;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.ws.api.IWebSocketConnection;
import org.apache.wicket.protocol.ws.api.SimpleWebSocketConnectionRegistry;
import org.apache.wicket.protocol.ws.api.WebSocketBehavior;
import org.apache.wicket.protocol.ws.api.message.BinaryMessage;
import org.apache.wicket.protocol.ws.api.message.ClosedMessage;
import org.apache.wicket.protocol.ws.api.message.ConnectedMessage;
import org.apache.wicket.protocol.ws.api.message.TextMessage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.Arrays;
import java.util.HashMap;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;


    private String applicationName;
    private String sessionId;
    private Integer pageId;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        Form<Order> orderForm = new Form<Order>("form", new CompoundPropertyModel<Order>(new Order())){
            @Override
            protected void onSubmit() {
                super.onSubmit();
                DB.get().store(getModelObject());
            }
        };
        orderForm.add(new TextField<String>("name"));
        orderForm.add(new TextField<String>("street"));
        orderForm.add(new TextField<String>("zip"));
        orderForm.add(new TextField<String>("city"));
        orderForm.add(new DropDownChoice<Food>("food", Arrays.asList(Food.values())));
        orderForm.add(new AjaxSubmitLink("submit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                SimpleWebSocketConnectionRegistry registry = new SimpleWebSocketConnectionRegistry() ;
                for(ClientConnection clientConnection :
                        WicketApplication.get().getRegistry().getConnectionsBySessionId(Session.get().getId())) {
                    IWebSocketConnection connection = registry.getConnection(Application.get(), clientConnection.getSessionId(), clientConnection.getPageId());
                    if (connection != null) {
                        WebSocketRequestHandler webSocketHandler = new WebSocketRequestHandler(this, connection);
                        try {
                            webSocketHandler.push(JsonUtils.asArray(DB.get().countOrdersByFood()).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                }

            }
        });
        add(orderForm);


    }

    @Override
    public void renderHead(HtmlHeaderContainer container) {
        super.renderHead(container);
        container.getHeaderResponse().render(JavaScriptHeaderItem.forReference(new WebSocketClientResourceReference()));
    }
}
