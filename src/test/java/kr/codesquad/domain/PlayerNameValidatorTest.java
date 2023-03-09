package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerNameValidatorTest {

    PlayerNameValidator nameValidator = new PlayerNameValidator();
    InputView inputHandler = new InputView();
    @Test
    @DisplayName("모든 playerName이 5글자 이하일떄 test")
    void parseAndValidateSuccessTest(){
        ArrayList list = new ArrayList<>();
        String input = "Tom,Dean,crong,boy";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(nameValidator.getValidNameFromUser(list,inputHandler));
    }

    @Test
    @DisplayName("5글자 이상인 playerName이 존재할때 test")
    void parseAndValidateFailTest(){
        ArrayList list = new ArrayList<>();
        String input = "Tom,Dean,crong,charlie";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertFalse(nameValidator.getValidNameFromUser(list,inputHandler));
    }

}