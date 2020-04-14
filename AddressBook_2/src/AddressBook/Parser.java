package AddressBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Commands {
    ADD,
    EDIT,
    LIST,
    DELETE,
    SEARCH,
    QUIT
}

public class Parser {
    private String inputText = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String textToBeFound = "";
    private Commands actualCommand = null;

    public Parser(String inputString) {
        this.inputText = inputString;

        // Need to rid of all duplicated whitespaces and trim final command. Just to avoid errors.
        this.inputText = this.inputText.replaceAll("\\s+", " ").trim();

        this.findCommand();

    }

    private void findCommand() {
        Matcher matcher;
        // Add command -> Used regular expression to distinguish whether is used first name , last name , email or their mixture like last name and email and so on.
        // Capture groups in regex to simplify parsing
        // Example(1): Add L: Janko F: Hrasko E: janko.hrasko@gmail.com
        // Example(2): Add L: Janko E: janko.hrasko@gmail.com
        // Example(3): Add E: janko.hrasko@gmail.com

        String ADD_REGEX = "[A|a][D|d]{2}\\s(F:\\s?[A-Za-z]*\\s?)?(L:\\s?[A-Za-z]*\\s?)?(E:\\s?[a-zA-Z0-9_.]*@[a-z]*\\.(com|sk|cz))?";
        Pattern addPattern = Pattern.compile(ADD_REGEX);
        // Edit command is same as  Add command but you have to click on person who you want to edit.
        // Examples are the same as in ADD command
        String EDIT_REGEX = "[E|e][D|d][I|i][T|t]\\s(F:\\s?[A-Za-z]*\\s?)?(L:\\s?[A-Za-z]*\\s?)?(E:\\s?[a-zA-Z0-9_.]*@[a-z]*\\.(com|sk|cz))?";
        Pattern editPattern = Pattern.compile(EDIT_REGEX);
        String LIST_REGEX = "[L|l][I|i][S|s][T|t]";
        Pattern listPattern = Pattern.compile(LIST_REGEX);
        // First you have to click on person you want to delete.
        String DEL_REGEX = "[D|d][E|e][L|l][E|e][T|t][E|e]";
        Pattern deletePattern = Pattern.compile(DEL_REGEX);
        // Type word you want to search and it will check all FirstName, LastName and email columns
        // Example: Search janko
        String SEA_REGEX = "[S|s][E|e][A|a][R|r][C|c][H|h]\\s([A-Za-z0-9._@]*)";
        Pattern searchPattern = Pattern.compile(SEA_REGEX);
        // Just type word "Quit". Regex takes every "quit" word
        String QUIT_REGEX = "[Q|q][U|u][I|i][T|t]";
        Pattern quitPattern = Pattern.compile(QUIT_REGEX);

        if (addPattern.matcher(this.inputText).matches()) {
            this.actualCommand = Commands.ADD;
            matcher = addPattern.matcher(this.inputText);
            // Get Person from groups in regex
            if (matcher.find()) {
                // At first we get for example: F: Name. First we need to rid of substring "F: " and we get Name and so on with another attributes
                this.firstName = ((matcher.group(1) != null) ? matcher.group(1) : "").replaceAll("[F:|F:\\s]", "");
                this.lastName = ((matcher.group(2) != null) ? matcher.group(2) : "").replaceAll("[L:|L:\\s]", "");
                this.email = ((matcher.group(3) != null) ? matcher.group(3) : "").replaceAll("[E:|E:\\s]", "");
            }
        }else if (editPattern.matcher(this.inputText).matches()){
            this.actualCommand = Commands.EDIT;
            matcher = editPattern.matcher(this.inputText);
            // Get Person
            if (matcher.find()) {
                // At first we get for example: F: Name. First we need to rid of substring "F: " and we get Name and so on with another attributes
                this.firstName = ((matcher.group(1) != null) ? matcher.group(1) : "").replaceAll("[F:|F:\\s]", "");
                this.lastName = ((matcher.group(2) != null) ? matcher.group(2) : "").replaceAll("[L:|L:\\s]", "");
                this.email = ((matcher.group(3) != null) ? matcher.group(3) : "").replaceAll("[E:|E:\\s]", "");
            }
        }else if (listPattern.matcher(this.inputText).matches()) {
            this.actualCommand = Commands.LIST;
        }else if (deletePattern.matcher(this.inputText).matches()) {
            this.actualCommand = Commands.DELETE;
        }else if (searchPattern.matcher(this.inputText).matches()) {
            this.actualCommand = Commands.SEARCH;
            matcher = searchPattern.matcher(this.inputText);
            if (matcher.find()) {
                this.textToBeFound = ((matcher.group(1) != null) ? matcher.group(1) : "").trim();
            }
        }else if (quitPattern.matcher(this.inputText).matches()) {
            this.actualCommand = Commands.QUIT;
        }else {
            this.actualCommand = null;
        }
    }

    public String getTextToBeFound() {
        return textToBeFound;
    }

    public Commands getActualCommand() {
        return actualCommand;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
