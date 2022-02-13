package com.techelevator.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.data.Menu;

public class MenuTest {

    private ByteArrayOutputStream sut;

    @Before
    public void setup()  {
        sut = new ByteArrayOutputStream();
    }

    @Test
    public void display_menu_options_and_user_prompt_for_input() throws IOException {
        Object[] options = new Object[] { new Integer(3), "Blind", "Mice" };
        Menu menu = getMenuForTesting();

        menu.getChoiceFromOptions(options);

        String expected = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
                + options[2].toString() + "\n\n" + "Please choose an option >>> ";
        Assert.assertEquals(expected, sut.toString());
    }

    @Test
    public void get_choice_from_options_purchase_menu_return_selection() throws IOException {
        Integer expected = new Integer(456);
        Integer[] options = new Integer[] { new Integer(123), expected, new Integer(789) };
        Menu menu = getMenuForTestingWithUserInput("2\n");

        Integer result = (Integer) menu.getChoiceFromOptions(options);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void redisplays_menu_if_user_does_not_choose_valid_option() throws IOException {
        Object[] options = new Object[] { "Lays", "Doritos", "Skittles" };
        Menu menu = getMenuForTestingWithUserInput("4\n1\n");

        menu.getChoiceFromOptions(options);

        String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
                + options[2].toString() + "\n\n" + "Please choose an option >>> ";

        String expected = menuDisplay + "\n<<< 4 is not a valid option >>>\n\n" + menuDisplay;

        Assert.assertEquals(expected, sut.toString());
    }

    @Test
    public void redisplays_menu_if_user_chooses_option_less_than_1() throws IOException {
        Object[] options = new Object[] { "Larry", "Curly", "Moe" };
        Menu menu = getMenuForTestingWithUserInput("0\n1\n");

        menu.getChoiceFromOptions(options);

        String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
                + options[2].toString() + "\n\n" + "Please choose an option >>> ";

        String expected = menuDisplay + "\n<<< 0 is not a valid option >>>\n\n" + menuDisplay;

        Assert.assertEquals(expected, sut.toString());
    }

    @Test
    public void redisplays_menu_if_user_enters_garbage() throws IOException {
        Object[] options = new Object[] { "Larry", "Curly", "Moe" };
        Menu menu = getMenuForTestingWithUserInput("Mickey Mouse\n1\n");

        menu.getChoiceFromOptions(options);

        String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
                + options[2].toString() + "\n\n" + "Please choose an option >>> ";

        String expected = menuDisplay + "\n<<< Mickey Mouse is not a valid option >>>\n\n" + menuDisplay;

        Assert.assertEquals(expected, sut.toString());
    }

    private Menu getMenuForTestingWithUserInput(String userInput) throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
        return new Menu(input, sut);
    }

    private Menu getMenuForTesting() throws IOException {
        return getMenuForTestingWithUserInput("1\n");
    }
}