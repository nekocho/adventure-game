package com.nekocho.adventuregame.model;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class Story {

    // Get player stats
    private Player player;

    // Access Set up mainText value for GameController
    private String mainText;

    // Display choices as a list
    private List<String> choices;

    // Construct the Story with player stats and choices
    public Story(Player player) {
        this.player = player;
        this.choices = new ArrayList<>();
    }

    // Method to set the main text
    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    // Method to set the choices
    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    // Method to get the main text
    public String getMainText() {
        return mainText;
    }

    // Method to get the current choices
    public List<String> getCurrentChoices() {
        return choices;
    }

    // Mapping choices to text
    private static final Map<String, String> choiceTextMap = new HashMap<>();
    private static final List<String> choiceIdentifiers = new ArrayList<>();

    static {
        // Initialize the map with the mappings
        choiceTextMap.put("talkToBaker", "Talk to the baker");
        choiceTextMap.put("lookAroundOakridge", "Look around");
        // Add more choice mappings as needed

        // Initialize the list of choice identifiers
        choiceIdentifiers.addAll(choiceTextMap.keySet());
    }
    public String getChoiceText(String choiceId) {
        // Get the user-friendly text corresponding to the choiceId from the map
        return choiceTextMap.getOrDefault(choiceId, "Unknown choice");
    }
    public List<String> getCurrentChoiceIdentifiers() {
        return choiceIdentifiers;
    }

    public void selectPosition(String nextPosition) {
        // Implement story progression logic based on the nextPosition
        // You can set the main text and choices accordingly
            switch (nextPosition) {
                case "enterOakridge":
                    System.out.println("Enter Oakridge");
                    System.out.println(getChoiceText("talkToBaker"));
                    System.out.println(nextPosition);
                    System.out.println(choiceTextMap);
                    setMainText("It's a bright sunny day when you enter Oakridge, a small humble village.  \nThe smell of fresh bread fills the air as you walk past the baker. \nLooking around you notice that everyone looks really tense... \n\n What do you do?");
                    setChoices(Arrays.asList("Talk to the Baker", "Look around"));
                    break;
                case "talkToBaker":
                    System.out.println(nextPosition);
                    System.out.println("talk to baker");
                    setMainText("You approach the baker and he looks up. You notice a Tavern next door. You ask him why everyone is so tense, and he responds: \n'Someone's been causing trouble, people going missing... got everyone scared' \n\n What do you do?");
                    setChoices(Arrays.asList("Thank him and leave", "Go to the Tavern", "Attack Baker"));
                    break;
                case "lookAroundOakridge":
                    System.out.println("Look Around");
                    setMainText("You see a few people buying bread from the baker, next to the bakery is a Tavern. \nNothing else really stands out.");
                    setChoices(Arrays.asList("Leave", "", "", ""));
                    break;
                // Add more cases for other story progression points
            }
    }

//}
//    public void selectPosition(String nextPosition) {
//        switch (nextPosition) {
//            case "enterOakridge", "Leave":
//                enterOakridge();
//                break;
//            case "Talk to Baker":
//                talkToBaker();
//                break;
//            case "Attack Baker":
//                attackBaker();
//                break;
//            case "Look Around Oakridge":
//                lookAroundOakridge();
//                break;

            //TO FIX
//            case "enterTavern":
//                enterTavern();
//                break;
//            case "talkToBarkeep":
//                talkToBarkeep();
//                break;
//            case "sitAtTable":
//                sitAtTable();
//                break;
//            case "missingPeople":
//                missingPeople();
//                break;
//            case "bookRoom":
//                bookRoom();
//                break;
//            case "buyAle":
//                buyAle();
//                break;
//            case "findWeapon":
//                findWeapon();
//                break;
//            case "searchRoom":
//                searchRoom();
//                break;
//            case "chillRoom":
//                chillRoom();
//                break;
//            case "leaveRoom":
//                leaveRoom();
//                break;
//            case "endDay":
//                endDay();
//                break;

//        }
//
//    }
//
//    public void enterOakridge() {
//        setMainText("It's a bright sunny day when you enter Oakridge, a small humble village.  \nThe smell of fresh bread fills the air as you walk past the baker. \nLooking around you notice that everyone looks really tense... \n\n What do you do?");
//        setChoices(Arrays.asList("Talk to the Baker", "Look Around Oakridge", "", ""));
//        System.out.println(getCurrentChoices());
//        System.out.println(getChoiceText("talkToBaker"));
//    }
//
//    public void talkToBaker() {
//        System.out.println("talkToBaker");
//        setMainText("You approach the baker and he looks up. You notice a Tavern next door. You ask him why everyone is so tense, and he responds: \n'Someone's been causing trouble, people going missing... got everyone scared' \n\n What do you do?");
//        setChoices(Arrays.asList("Thank him and leave", "Go to the Tavern", "Attack Baker", ""));
//        System.out.println(getCurrentChoices());
//    }
//
//    public void attackBaker() {
//        setMainText("As you draw your weapon, a guard nearby attacks you. \n\n(You take 3 damage)");
//        player.hp = player.hp - 3; // Reduce player health
//        setChoices(Arrays.asList("Leave", "", "", ""));
//
//    }
//
//    public void lookAroundOakridge() {
//        System.out.println("LookAround");
//        setMainText("You see a few people buying bread from the baker, next to the bakery is a Tavern. \nNothing else really stands out.");
//        setChoices(Arrays.asList("Leave", "", "", ""));
//    }

    //TO FIX

//    public void enterTavern() {
//        ui.mainTextArea.setText("The Tavern is small but friendly, a barkeep is quietly observing you while cleaning a glass at the bar. \nThere are a few tables and chairs around. \n\nWhat do you do?");
//        ui.choice1.setText("Talk to the Barkeep");
//        ui.choice2.setText("Grab a seat at the table");
//        ui.choice3.setText("Leave");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "talkToBarkeep";
//        game.nextPosition2 = "sitAtTable";
//        game.nextPosition3 = "enterOakridge";
//        game.nextPosition4 = "";
//    }
//
//    public void talkToBarkeep() {
//        ui.mainTextArea.setText("'How's your day going? new here?' \n\nWhat do you do?");
//        ui.choice1.setText("Ask about the town");
//        ui.choice2.setText("Ask for a room");
//        ui.choice3.setText("Ask for an Ale (5 coins)");
//        ui.choice4.setText("Leave");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "missingPeople";
//        game.nextPosition2 = "bookRoom";
//        game.nextPosition3 = "buyAle";
//        game.nextPosition4 = "enterOakridge";
//
//    }
//
//    public void sitAtTable() {
//        ui.mainTextArea.setText("You sit at the nearest table. The barkeep approaches and asks if you'd like a drink. \n\nWhat do you do?");
//        ui.choice1.setText("Ask about the Town");
//        ui.choice2.setText("Ask for a room");
//        ui.choice3.setText("Ask for an Ale (5 coins)");
//        ui.choice4.setText("Get up and leave");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "missingPeople";
//        game.nextPosition2 = "bookRoom";
//        game.nextPosition3 = "buyAle";
//        game.nextPosition4 = "enterOakridge";
//    }
//
//    public void missingPeople() {
//        ui.mainTextArea.setText("'The people are friendly but something darker is happening, people are going missing... everyone's scared. There's a rumour of someone calling themselves The Illusionist that's causing these disappearances...' \n\nWhat do you do?");
//        ui.choice1.setText("Buy another Ale (5 coins)");
//        ui.choice2.setText("Ask for a room");
//        ui.choice3.setText("Thank him and Leave");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "buyAle";
//        game.nextPosition2 = "bookRoom";
//        game.nextPosition3 = "enterOakridge";
//        game.nextPosition4 = "";
//
//    }
//
//    public void buyAle() {
//        ui.mainTextArea.setText("The barkeep brings you your Ale (-5 coins) \n\n What do you want to do?");
//        player.coin = player.coin - 5; // Reduce player coin by 5
//        ui.coinNumberLabel.setText("" + player.coin); // Update coin number display each time
//        ui.choice1.setText("Talk to the barkeep");
//        ui.choice2.setText("Buy another Ale (5 coins)");
//        ui.choice3.setText("Leave");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "talkToBarkeep";
//        game.nextPosition2 = "buyAle";
//        game.nextPosition3 = "enterOakridge";
//        game.nextPosition4 = "";
//    }
//
//    public void bookRoom() {
//        ui.mainTextArea.setText("The barkeep takes you to your room. \n\nWhat do you do?");
//        ui.choice1.setText("Search Room");
//        ui.choice2.setText("Leave Room");
//        ui.choice3.setText("Rest for the day");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "searchRoom";
//        game.nextPosition2 = "leaveRoom";
//        game.nextPosition3 = "endDay";
//        game.nextPosition4 = "";
//    }
//
//    public void searchRoom() {
//        ui.mainTextArea.setText("Searching a room, you notice a loose floorboard. \n\nWhat do you do?");
//        ui.choice1.setText("Lift it up");
//        ui.choice2.setText("Leave it alone");
//        ui.choice3.setText("");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "findWeapon";
//        game.nextPosition2 = "chillRoom";
//        game.nextPosition3 = "";
//        game.nextPosition4 = "";
//
//    }
//
//    public void findWeapon() {
//        ui.mainTextArea.setText("Under the floorboard you find a Long Sword! (Obtained a Long Sword)");
//        player.currentWeapon = new WeaponLongSword(); //change weapon from knife to long sword
//        ui.weaponNameLabel.setText(player.currentWeapon.name); //set weapon name label in UI to new weapon
//        ui.choice1.setText("Next");
//        ui.choice2.setText("");
//        ui.choice3.setText("");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "chillRoom";
//        game.nextPosition2 = "";
//        game.nextPosition3 = "";
//        game.nextPosition4 = "";
//    }
//
//    public void chillRoom() {
//        ui.mainTextArea.setText("The room is simple and cosy, there is a bed, a small table and chair and an empty wardrobe to store your clothes. \n\nWhat would you like to do?");
//        ui.choice1.setText("Leave the room");
//        ui.choice2.setText("Rest for the Day");
//        ui.choice3.setText("");
//        ui.choice4.setText("");
//
//        // Sets next positions on button click
//        game.nextPosition1 = "leaveRoom";
//        game.nextPosition2 = "endDay";
//        game.nextPosition3 = "";
//        game.nextPosition4 = "";
//
//    }
//
//    public void leaveRoom() {
//
//    }
//
//    public void endDay() {
//
//    }
//}
//
//
//
}