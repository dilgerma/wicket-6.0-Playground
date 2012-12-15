package de.effectivetrainings;

import org.apache.wicket.bean.validation.Property;
import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

import java.util.Date;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

        IModel<MuenchensEffectiveTrainer> effectiveTrainerModel = Model.of(new MuenchensEffectiveTrainer());
		add(new FeedbackPanel("feedback"));
        CompoundPropertyModel<MuenchensEffectiveTrainer> compoundModel = new CompoundPropertyModel<MuenchensEffectiveTrainer>(effectiveTrainerModel);
        Form<MuenchensEffectiveTrainer> form = new Form<MuenchensEffectiveTrainer>("form", compoundModel);

        form.add(new TextField<String>("name")
                .add(new PropertyValidator<String>(new Property(MuenchensEffectiveTrainer.class,"name"))));
        form.add(new TextField<String>("email")
                .add(new PropertyValidator<String>(new Property(MuenchensEffectiveTrainer.class,"email"))));
        form.add(new TextField<String>("phone")
                .add(new PropertyValidator<String>(new Property(MuenchensEffectiveTrainer.class,"phone"))));
        form.add(new TextField<Date>("birthDay")
                .add(new PropertyValidator<String>(new Property(MuenchensEffectiveTrainer.class,"birthDay"))));

        form.add(new TextField<Integer>("zip")
                .add(new PropertyValidator<Integer>(new Property(MuenchensEffectiveTrainer.class, "zip"), EffectiveTrainer.class)));

        IModel<Integer> globalZipModel = compoundModel.bind("zip");
        form.add(new TextField<Integer>("globalZip", globalZipModel)
                .add(new PropertyValidator<Integer>(new Property(MuenchensEffectiveTrainer.class, "zip"))));

        add(form);

    }
}
