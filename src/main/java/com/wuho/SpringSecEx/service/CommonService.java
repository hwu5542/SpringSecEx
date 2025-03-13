package com.wuho.SpringSecEx.service;

import com.wuho.SpringSecEx.common.Color;
import com.wuho.SpringSecEx.common.MarkerAnnotation;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class CommonService {

    @SuppressWarnings(value = "unchecked")
    public String getColor(){
        for (Color color : Color.values()) {
            System.out.println("Enum: " + color.name() + "  " + color.getValue());
        }
        Color c1 = Color.RED;
        return String.format("%s : %s", c1.name(), c1.getValue());
    }

    @MarkerAnnotation(value = 10)
    public void hello() {
        System.out.println("Custom Annotation");
    }

    public void sayHello() throws NoSuchMethodException {
        CommonService service = new CommonService();
        Method method = service.getClass().getMethod("hello");
        MarkerAnnotation annotation = method.getAnnotation(MarkerAnnotation.class);
        System.out.println("Value is : " + annotation.value());
    }
}
