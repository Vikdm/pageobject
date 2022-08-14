package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;

public class BalanceCard {
    private ElementsCollection buttonCards = $$("[data-test-id='action-deposit']");
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public BalanceCard() {
    }

    public TransferValueCard changeCard(int id) {
        buttonCards.get(id).click();
        return new TransferValueCard();
    }

    public int getCardBalance(String id) {
        val text = cards.get(Integer.parseInt(id)).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}