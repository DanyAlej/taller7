package com.miso4208.podam.Estrategias;

import java.lang.annotation.Annotation;
import java.util.List;

import uk.co.jemos.podam.common.AttributeStrategy;

public class ClaveStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
        int numCharacters = (int) (Math.random() * 12);

        return AlphaNumericString.generateString(numCharacters);
    }

}
