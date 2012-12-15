package de.effectivetrainings;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import java.util.Date;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

        IModel<EffectiveTrainer> effectiveTrainerModel = Model.of(new EffectiveTrainer());
		add(new FeedbackPanel("feedback"));
        Form<EffectiveTrainer> form = new Form<EffectiveTrainer>("form", effectiveTrainerModel);

        form.add(new TextField<String>("name", new PropertyModel<String>(effectiveTrainerModel, "name"))
                .add(new PropertyValidator<String>()));
        form.add(new TextField<String>("email", new PropertyModel<String>(effectiveTrainerModel, "email"))
                .add(new PropertyValidator<String>()));
        form.add(new TextField<String>("phone", new PropertyModel<String>(effectiveTrainerModel, "phone"))
                .add(new PropertyValidator<String>()));
        form.add(new TextField<Date>("date", new PropertyModel<Date>(effectiveTrainerModel, "birthDay"))
                .add(new PropertyValidator<String>()));
        form.add(new TextField<Integer>("zip", new PropertyModel<Integer>(effectiveTrainerModel, "zip"))
                .add(new PropertyValidator<Integer>()));

        add(form);

    }
}
