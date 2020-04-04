package com.exp.common;

import org.springframework.stereotype.Component;

@Component
public class SecureByTestResolver implements SecureByTestExtender {


    @Override
    public String resolveResource(String resourceid) {
        System.out.println("*****************");
        System.out.println("Inside resolveResource of SecureByTestResolver : " + resourceid);
        System.out.println("*****************");
        // Can do authorization check based on given resourceId from db or anywhere (and throw unauthorized error from here itself)
        // or return the value on which authorization has to be taken place in the aspect itself
        return "1";
    }
}
