package ru.netology.test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.page.BalanceCard;
import ru.netology.page.LoginPage;

public class MoneyTransferTest {

    @BeforeEach
    void form() {
        open("http://localhost:7777");
        var loginPage = new LoginPage();
        var authInfo = DataGenerator.getAuthInfo();
        var verificationCode = DataGenerator.getVerificationCodeFor(authInfo);
        loginPage.validLogin(authInfo).validVerify(verificationCode);
    }


    @Test
    void shouldTransferMoneyFirstCard() {
        int value = 7000;
        var donorInfo = DataGenerator.getInfoSecondCard();

        var balanceCard = new BalanceCard();
        int firstBalanceFirstCard = balanceCard.getCardBalance("0");
        int firstBalanceSecondCard = balanceCard.getCardBalance("1");

        balanceCard.changeCard(0).transferValue(donorInfo, value);
        int secondBalanceFirstCard = balanceCard.getCardBalance("0");
        int secondBalanceSecondCard = balanceCard.getCardBalance("1");

        assertEquals(secondBalanceFirstCard, firstBalanceFirstCard + value);
        assertEquals(secondBalanceSecondCard, firstBalanceSecondCard - value);
    }

    @Test
    void shouldTransferMoneySecondCard() {
        int value = 5000;
        var donorInfo = DataGenerator.getInfoFirstCard();

        var balanceCard = new BalanceCard();
        int firstBalanceFirstCard = balanceCard.getCardBalance("0");
        int firstBalanceSecondCard = balanceCard.getCardBalance("1");

        balanceCard.changeCard(1).transferValue(donorInfo, value);
        int secondBalanceFirstCard = balanceCard.getCardBalance("0");
        int secondBalanceSecondCard = balanceCard.getCardBalance("1");

        assertEquals(secondBalanceFirstCard, firstBalanceFirstCard - value);
        assertEquals(secondBalanceSecondCard, firstBalanceSecondCard + value);
    }

    @Test
    void shouldTransferMoneyCardLowAmount() {

        int value = 1;
        var donorInfo = DataGenerator.getInfoFirstCard();

        var balanceCard = new BalanceCard();
        int firstBalanceFirstCard = balanceCard.getCardBalance("0");
        int firstBalanceSecondCard = balanceCard.getCardBalance("1");

        balanceCard.changeCard(1).transferValue(donorInfo, value);
        int secondBalanceFirstCard = balanceCard.getCardBalance("0");
        int secondBalanceSecondCard = balanceCard.getCardBalance("1");

        assertEquals(secondBalanceFirstCard, firstBalanceFirstCard - value);
        assertEquals(secondBalanceSecondCard, firstBalanceSecondCard + value);
    }
}





