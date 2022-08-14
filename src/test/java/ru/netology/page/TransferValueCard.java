package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class TransferValueCard {
    private SelenideElement amountTransfer = $("[data-test-id='amount'] .input__control");
    private SelenideElement numberCard = $("[data-test-id='from'] .input__control");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement errorMessage = $("[data-test-id=error-notification]");

    public BalanceCard transferValue(DataGenerator.CardTransfer info, int value) {
        amountTransfer.setValue(String.valueOf(value));
        numberCard.setValue(info.getCardNumber());
        transferButton.click();
        return new BalanceCard();
    }

}

