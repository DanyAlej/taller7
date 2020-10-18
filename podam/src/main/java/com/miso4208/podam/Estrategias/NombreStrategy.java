package com.miso4208.podam.Estrategias;

import java.lang.annotation.Annotation;
import java.util.List;

import uk.co.jemos.podam.common.AttributeStrategy;

public class NombreStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue(Class<?> arg0, List<Annotation> arg1) {
        int numCharacters = (int) (Math.random() * 200);

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(numCharacters);

        for (int i = 0; i < numCharacters; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

}
