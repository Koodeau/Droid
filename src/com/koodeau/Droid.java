package com.koodeau;

import javax.swing.*;



public class Droid{


  /*
  A simple Droid (robot) that can be activated, charged, and hover above ground.
  This project creates some baseline behaviors of the droid.
  */



    int batteryLevel;
    int errorMessage = JOptionPane.ERROR_MESSAGE;
    int warningMessage = JOptionPane.WARNING_MESSAGE;
    int informationMessage = JOptionPane.INFORMATION_MESSAGE;
    int okOption = JOptionPane.OK_OPTION;
    String title = "Droid";
    String droidName;
    String userName;
    String helpCommand;
    String activateCommand;






    public Droid() {
        batteryLevel = 100; // 100%
        String userName = JOptionPane.showInputDialog("Hello! Tell me your name?");
        String droidName = JOptionPane.showInputDialog("Hello, "+userName+"! How would you call me?");
    }


    /**
     * Hello void will welcome you
     */
    public void Hello(){
        String HelloMessage = "Hello! It is you new personal Droid.\n\n" +
                "\n\n" +
                "Press 'Ok' to start";
        String HelloMessageTitle = "Droid";
        JOptionPane.showMessageDialog(null,HelloMessage,title,okOption);
    }


    /**
     * Help void will show you list of commands
     */
    public void Help(){
        if (helpCommand == "/help") {
            JOptionPane.showMessageDialog(null,"Commands you can use to communicate to your droid:\n" +
                    "/help - Shows you this list of commands\n" +
                    "/activate - Activates your droid\n" +
                    "/chargeBattery - Charges droid's battery until full\n" +
                    "/hover - Makes your droid levitate");
        }
    }


    /**
     *
     */
    public void activate(){
        title = droidName;

        JOptionPane.showMessageDialog(null,"Activated.\n" +
                "Hello! How can I help you, "+userName+"?");

        batteryLevel -= 5; // -5% per any action
        System.out.println("Battery level is: " + batteryLevel + " percent.");


        /**
         *
         */
    public void chargeBattery(int hours){
        JOptionPane.showMessageDialog(null,droidName+" charging...");
        batteryLevel += hours;

        if(batteryLevel >= 100){
            JOptionPane.showMessageDialog(null,"Droid is fully charged."+ '\n' +"Battery level is: " + batteryLevel + " percent.",title,informationMessage);
        } else {
            JOptionPane.showMessageDialog(null,"Battery level is: " + batteryLevel + " percent.",title,informationMessage);
        }
    }


        /**
         *
         */
    public void checkBatteryLevel(){
        JOptionPane.showMessageDialog(null,"Battery level is: " + batteryLevel + " percent.",title,informationMessage);
    }


        /**
         *
         */
    public void lowBattery(){
        if (batteryLevel == 20){
            JOptionPane.showMessageDialog(null,
                    "Your battery level is low!\n"+
                    batteryLevel+"% left."
                    ,title,warningMessage);
        } else if (batteryLevel == 10){
            JOptionPane.showMessageDialog(null,
                    "Your battery level is critically low!\n"+
                            batteryLevel+"% left.",
                    title,errorMessage);
        } else if (batteryLevel <= 5){
            JOptionPane.showMessageDialog(null,
                    "Your battery level is absolutely low!\n" +
                            "\n"+
                            batteryLevel+"% left."+
                            "I am turning on reserve batteries to charge my battery.",
                    title,errorMessage);
        }
    }


        /**
         *
         */
    public void hover(int feet){
        if(feet > 2){
            JOptionPane.showMessageDialog(null,"Error! I cannot hover above 2 feet.",title,errorMessage);
        } else {
            JOptionPane.showMessageDialog(null,"Hovering...",title,informationMessage);
            batteryLevel -= 20;
            JOptionPane.showMessageDialog(null,"Battery level is: " + batteryLevel + " percent.",title,informationMessage);
        }
    }


        /**
         *
         */
    public static void main(String[] args){

        Droid droid = new Droid();
        droid.Help();
        droid.activate();
        droid.chargeBattery(5);
        droid.hover(2);
    }


}
