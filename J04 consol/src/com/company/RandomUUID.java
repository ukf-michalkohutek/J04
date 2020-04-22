package com.company;

import java.util.UUID;

public class RandomUUID {
    public static String newuid(){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        //System.out.println("Random UUID String = "+ randomUUIDString);
        //System.out.println("UUID version       = "+ uuid.version());
        //System.out.println("UUID variant       = "+ uuid.variant());
        //System.out.println();

        return randomUUIDString;
    }
}
