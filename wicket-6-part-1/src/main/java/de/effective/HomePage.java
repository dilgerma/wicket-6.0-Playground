package de.effective;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converter.AbstractConverter;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.AbstractValidator;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import java.util.Locale;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        add(new FeedbackPanel("feedback"));
        Form<Email> form = new Form<Email>("form", new CompoundPropertyModel<Email>(new Email()));
        TextField<Email> mail = emailField();
        form.add(mail);
        form.add(new AjaxSubmitLink("submit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                System.out.println(form.getDefaultModelObject());
                target.add(HomePage.this);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(HomePage.this);
            }
        });
        add(form);
    }

    private TextField<Email> emailField() {
        TextField<Email> mail = new TextField<Email>("mail"){
            @Override
            public <C> IConverter<C> getConverter(Class<C> type) {
               return (IConverter<C>)new AbstractConverter<Email>(){
                   @Override
                   protected Class<Email> getTargetType() {
                       return Email.class;
                   }

                   @Override
                   public Email convertToObject(String s, Locale locale) {
                       return new Email(s);
                   }

                   @Override
                   public String convertToString(Email value, Locale locale) {
                       return value.getMail();
                   }
               };
            }
        };

        mail.add(new IValidator<Email>() {
            @Override
            public void validate(IValidatable<Email> validatable) {
                Email email = validatable.getValue();
                if (!email.isValid()) {
                    ValidationError validationError = new ValidationError().addKey("email.error");
                    validationError.setVariable("email", email.getMail());
                    validatable.error(validationError);
                }
            }
        });
        return mail;
    }
}
