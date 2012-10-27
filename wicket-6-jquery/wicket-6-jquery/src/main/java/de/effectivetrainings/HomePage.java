package de.effectivetrainings;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.*;
import org.apache.wicket.markup.head.internal.HeaderResponse;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.resource.JQueryResourceReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage {

    public  HomePage() {
        super();
        add(new TabbedPanel("tabbedPanel"));
    }

    @Override
    public void renderHead(HtmlHeaderContainer container) {
        super.renderHead(container);
        IHeaderResponse response = container.getHeaderResponse();
        response.render(new JQueryUIResourceReference());
    }

}
