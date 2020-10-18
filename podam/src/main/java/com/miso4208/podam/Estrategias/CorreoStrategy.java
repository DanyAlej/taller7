package com.miso4208.podam.Estrategias;

import java.lang.annotation.Annotation;
import java.util.List;

import uk.co.jemos.podam.common.AttributeStrategy;

public class CorreoStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
        double probIncorrecto = 0.5;

        if (Math.random() > probIncorrecto) {
            return generarCorreoCorrecto();
        } else {
            return AlphaNumericString.generateString((int) Math.random() * 50);
        }
    }

    private String generarCorreoCorrecto() {
        String lhs = AlphaNumericString.generateString((int) (Math.random() * 20));

        String rhs = AlphaNumericString.generateString((int) (Math.random() * 10));

        return lhs + "@" + rhs + ".com";
    }

}
