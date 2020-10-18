package com.miso4208.podam.Estrategias;

import java.lang.annotation.Annotation;
import java.util.List;

import uk.co.jemos.podam.common.AttributeStrategy;

public class EdadStrategy implements AttributeStrategy<Integer> {

    @Override
    public Integer getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
        double probNegative = 0.5;
        int sign = Math.random() > probNegative ? 1 : -1;
        int edad = (int) (Math.random() * 100);

        return edad * sign;
    }

}
