package ru.netology.page;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    public VerificationPage (){
        $("[data-test-id=code] input").shouldBe(visible);
    }

    public void validVerify(DataGenerator.VerificationCode verificationCode) {
        $("[data-test-id=code] input").setValue(verificationCode.getCode());
        $("[data-test-id=action-verify]").click();

    }
}