package de.effectivetrainings;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author martindilger
 *         Date: 15.12.12
 *         Time: 17:29
 */
public class MuenchensEffectiveTrainer implements Serializable, EffectiveTrainer {

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

    @Range.List(value = {
            @Range(message = "{zip.muenchen}",min = 80805, max=80805, groups = EffectiveTrainer.class),
            @Range(message = "{zip.global}",min = 1, max=Integer.MAX_VALUE)
    })
    private Integer zip;

    public MuenchensEffectiveTrainer(){}

    public MuenchensEffectiveTrainer(String name, String email, String phone, Date birthDay, Integer zip) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.zip = zip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
