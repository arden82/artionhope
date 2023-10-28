package com.tha103.artion.seller.controller;

import java.security.SecureRandom;

public class VerificationCodeGenerator {

    // 生成指定长度的随机验证码
    public static String generateVerificationCode(int length) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            code.append(randomChar);
        }

        return code.toString();
    }

    public static void main(String[] args) {
        int codeLength = 6; // 验证码长度
        String verificationCode = generateVerificationCode(codeLength);
        System.out.println("生成的隨機驗證碼: " + verificationCode);
    }
}
