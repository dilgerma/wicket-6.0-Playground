package de.effective;

import org.apache.wicket.model.IModel;

import java.io.Serializable;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * @author martin.dilger
 */
public class Email implements Serializable {

    private String mail;

    public Email(){}

    public Email(String email){
        this.mail = email;
    }

    public String getMail(){
        return mail;
    }

    public boolean isValid(){
        //regexp stolen from Wickets EmailAddressValidator:)
        return Pattern.matches(	"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z]{2,}){1}$)",mail);
    }

    @Override
    public String toString() {
        return mail;
    }
}
