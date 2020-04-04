package com.exp.persistence;

import org.springframework.stereotype.Component;

@Component
public class TestPersistenceException {
    public void testThrowException(){
     //   try {
            throw new RuntimeException("Test Persistence Exception");
      //  }
       // catch(Exception ex){
        //    System.out.println("catch : TestPersistenceException");
       // }
    }
}
