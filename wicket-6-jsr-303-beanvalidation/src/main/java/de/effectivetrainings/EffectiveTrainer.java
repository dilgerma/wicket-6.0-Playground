package de.effectivetrainings;

import org.apache.wicket.markup.html.form.EmailTextField;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author martindilger
 *         Date: 15.12.12
 *         Time: 17:29
 */
public class EffectiveTrainer implements Serializable {

    @NotNull
    private String name;

    @Pattern(message = "{email.invalid}",
            regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z]{2,}){1}$)")
    @NotNull
    private String email;

    @Pattern(message = "{phone.invalid}",regexp = "[0-9]+")
    private String phone;

    @Past(message = "{birthday.invalid}")
    @NotNull
    private Date birthDay;

    @Range(message = "{zip.muenchen}",min = 80805, max=80805)
    private Integer zip;

    public EffectiveTrainer(){}

    public EffectiveTrainer(String name, String email, String phone, Date birthDay, Integer zip) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
