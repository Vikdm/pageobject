package ru.netology.data;

import lombok.Value;

public class DataGenerator {
    private DataGenerator() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthUnfo() {
        return new AuthInfo("petya", "password");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardTransfer {
        private String id;
        private String cardNumber;
    }

    public static CardTransfer getInfoFirstCard() {
        return new CardTransfer("0", "5559 0000 0000 0001");
    }

    public static CardTransfer getInfoSecondCard() {
        return new CardTransfer("1", "5559 0000 0000 0002");
    }
}

