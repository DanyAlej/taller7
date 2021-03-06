package com.miso4208.podam.Estrategias;

import java.lang.annotation.Annotation;
import java.util.List;

import uk.co.jemos.podam.common.AttributeStrategy;

public class NombreStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue(Class<?> arg0, List<Annotation> arg1) {
        int numCharacters = (int) (Math.random() * 200);

        return AlphaNumericString.generateString(numCharacters);
    }

}
