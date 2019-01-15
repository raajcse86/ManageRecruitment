package com.app.util;

import java.util.Random;

public class GenerateRGB {
	
	static Random randomGenerator;

    static {
        randomGenerator = new Random();
    }
    
    public static String generateColor() {
        int newColor = 0x1000000 + randomGenerator.nextInt(0x1000000);
        return "#" + Integer.toHexString(newColor).substring(1, 7);
    }
}
