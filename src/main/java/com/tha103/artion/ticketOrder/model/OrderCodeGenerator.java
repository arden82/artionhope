package com.tha103.artion.ticketOrder.model;

import java.math.BigInteger;
import java.security.SecureRandom;

public class OrderCodeGenerator {

	private static String generateOrderCode() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32).substring(0, 15).toUpperCase();
    }

    public static void main(String[] args) {
        String orderCode = generateOrderCode();
        System.out.println("Generated Order Code: " + orderCode);
    }
}
