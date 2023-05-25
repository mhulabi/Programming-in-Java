package com.mohi.imax;

import java.io.IOException;
import java.util.Scanner;

public class ImaxStore extends Exception{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        input.useDelimiter("\r?\n");

        boolean completedShop = false; //will become true when the user decides they have finished shopping
        String modelName;
        int storage;
        String color = null;
        String caseColor;
        int phonePrice;
        int accessoryPrice = 0;
        int currentTotal = 0;
        int fullTotal = 0;
        String accessory;
        boolean validColor = false;
        boolean validCaseColor = false;
        boolean doneAccessory = false;
        String status;
        String status2;

        //iPhones
        IphoneSE p1 = new IphoneSE ("White", 64, 2);
        IphoneSE p2 = new IphoneSE ("Black", 64, 3);
        IphoneTw p3 = new IphoneTw ("White", 64, 1);
        IphoneTw p4 = new IphoneTw ("Black", 64, 4);
        IphoneTw p5 = new IphoneTw ("Blue", 64, 2);
        IphoneTw p6 = new IphoneTw ("White", 128, 2);
        IphoneTw p7 = new IphoneTw ("Black", 128, 3);
        IphoneTw p8 = new IphoneTw ("Blue", 128, 4);
        IphoneTh p9 = new IphoneTh ("White", 128, 2);
        IphoneTh p10 = new IphoneTh ("Black", 128, 3);
        IphoneTh p11 = new IphoneTh ("Red", 128, 1);
        IphoneTh p12 = new IphoneTh ("White", 256, 3);
        IphoneTh p13 = new IphoneTh ("Black", 256, 1);
        IphoneTh p14 = new IphoneTh ("Red", 256, 2);

        //Accessories
        MagSafeCharger m1 = new MagSafeCharger("iPhone 12", 100, 3);
        MagSafeCharger m2 = new MagSafeCharger("iPhone 13", 100, 2);
        Case c1 = new Case("iPhone SE", 30, 2, "Red");
        Case c2 = new Case("iPhone SE", 30, 1, "Black");
        Case c3 = new Case("iPhone 12", 40, 3, "Blue");
        Case c4 = new Case("iPhone 12", 40, 4, "White");
        Case c5 = new Case("iPhone 13", 50, 1, "Yellow");
        Case c6 = new Case("iPhone 13", 50, 3, "Green");
        AirPods a1 = new AirPods("iPhone 13", 150, 5);

        //Temporary references for keeping track of selected phones and Accessories
        IphoneSE p15 = null;
        IphoneTw p16 = null;
        IphoneTh p17 = null;
        MagSafeCharger m3 = null;
        Case c7 = null;
        AirPods a2 = null;
        
        
        try {
        System.out.println("Welcome to iMax!");
        while(!completedShop) {
            System.out.println("These are the iPhones we sell:");
            p1.displayStock();
            p2.displayStock();
            p3.displayStock();
            p4.displayStock();
            p5.displayStock();
            p6.displayStock();
            p7.displayStock();
            p8.displayStock();
            p9.displayStock();
            p10.displayStock();
            p11.displayStock();
            p12.displayStock();
            p13.displayStock();
            p14.displayStock();

            System.out.println("Please select an iPhone in stock: ");
            modelName = input.next();
            if (modelName.equals("iPhone SE")) {
                System.out.println("iPhone SE is only available with 64 GB storage therefore that is the default");
                storage = 64;
                phonePrice = p1.getPrice();
                while (!validColor) { //Color selection
                    System.out.println("Please select the desired color for the " + modelName + ":");
                    p1.displayColors();
                    color = input.next();
                    if (p1.verifyColor(color)) {
                        validColor = true;
                        break;
                    }
                    else {
                        System.out.println("The color you have selected is not available for this model!");
                        System.out.println("Please try again!");
                        continue;
                    }
                }
                //validating if selected phone is in Stock
                if (color.equals("Black")) {
                    if (p2.getStock() != 0) {
                        System.out.println("Successfully added to cart!");
                        p15 = p2;
                    }
                    else {
                        System.out.println("Unfortunatley the " + p2.getColor() + " " + modelName + " " + p2.getStorage() + "GB is out of stock!");
                        System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                    }
                }
                else {
                    if (p1.getStock() != 0) {
                        System.out.println("Successfully added to cart!");
                        p15 = p1;
                    }
                    else {
                        System.out.println("Unfortunatley the " + p1.getColor() + " " + modelName + " " + p1.getStorage() + "GB is out of stock!");
                        System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                        continue;
                    }
                }
                // Now to display the accessories available for this model
                System.out.println("These are the following accessories available for the " + modelName + ":");
                c1.displayAccessories();
                c2.displayAccessories();
                System.out.println("Please select one of the following accessories or choose NO to skip accessory purchase:");
                System.out.println("Case");

                accessory = input.next();

                if (accessory.equals("NO") || accessory.equals("No") || accessory.equals("no")) { //cart view no accessories
                    //represent cart HERE
                    fullTotal += p15.getPrice();
                    printCart(modelName, color, fullTotal, phonePrice);
                    status = input.next();
                    if (status.equals("Confirm")) {
                        p15.buyPhone(storage, color);
                        System.out.println("1. Continue: to continue purchasing");
                        System.out.println("2. Stop: to stop shopping");
                        status2 = input.next();
                        if (status2.equals("Continue")) {
                            validColor = false;
                            validCaseColor = false;
                            continue;
                        }
                        else if (status2.equals("Stop")) {
                            completedShop = true;
                            break;
                        }

                    }
                    else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                        validColor = false;
                        validCaseColor = false;
                        continue;
                    }
                    else {
                        throw new IOException("Invalid Input");
                    }
                }

                else if (p1.verifyAccessory(accessory)){
                    fullTotal += p15.getPrice();
                    accessoryPrice = c1.getPrice();
                    while (!validCaseColor) { //Color selection
                        System.out.println("Please select the desired color for the " + modelName + " Case:");
                        c1.displayCaseColors(modelName);
                        caseColor = input.next();
                        if (c1.verifyCaseColor(modelName, caseColor)) {
                            System.out.println("Successfully added to cart!"); //CHECK THIS
                            if (caseColor.equals("Red")){
                                c7 = c1;
                            }
                            else{
                                c7 = c2;
                            }
                            fullTotal += accessoryPrice;
                            printCart(modelName, color, fullTotal, phonePrice, "Case", c7.getColor(), accessoryPrice);
                            status = input.next();
                            if (status.equals("Confirm")) {
                                p15.buyPhone(storage, color);
                                c7.buyCase(modelName, c7.getColor());
                                System.out.println("1. Continue: to continue purchasing");
                                System.out.println("2. Stop: to stop shopping");
                                status2 = input.next();
                                if (status2.equals("Continue")) {
                                    validColor = false;
                                    validCaseColor = false;
                                    break;
                                }
                                else if (status2.equals("Stop")) {
                                    completedShop = true;
                                    break;
                                }

                            }
                            else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                                validColor = false;
                                validCaseColor = false;
                                continue;
                            }
                            else {
                                throw new IOException("Invalid Input");
                            }
                            break;
                        }
                        else {
                            System.out.println("The color you have selected is not available for this case model!");
                            System.out.println("Please try again!");
                            continue;
                        }
                    } continue;
                }

                else {
                	throw new IOException("Invalid Input");                }

            }
            else if (modelName.equals("iPhone 12")) {
                System.out.println("Please select the desired storage for the " + modelName + ":");
                p7.displayStorages();
                storage = Integer.valueOf(input.next());
                if (p7.verifyStorage(storage)) { //Storage selection
                    if (storage == 64) {
                        phonePrice = 350;
                    }
                    else {
                        phonePrice = 400;
                    }
                    while (!validColor) {
                        System.out.println("Please select the desired color for the " + modelName + ":");
                        p7.displayColors();
                        color = input.next();
                        if (p7.verifyColor(color)) { //Color selection
                            validColor = true;
                            break;
                        }
                        else {
                            System.out.println("The color you have selected is not available for this model!");
                            System.out.println("Please try again!");
                            continue;
                        }
                    }
                    //validating if selected phone is in Stock
                    if (color.equals("Black") && storage == 64) {
                        if (p4.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p16 = p4;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p4.getColor() + " " + modelName + " " + p4.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                        }
                    }
                    else if (color.equals("Black") && storage == 128){
                        if (p7.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p16 = p7;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p7.getColor() + " " + modelName + " " + p7.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else if (color.equals("White") && storage == 64){
                        if (p3.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p16 = p3;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p3.getColor() + " " + modelName + " " + p3.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else if (color.equals("White") && storage == 128){
                        if (p6.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p16 = p6;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p6.getColor() + " " + modelName + " " + p6.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else if (color.equals("Blue") && storage == 64){
                        if (p5.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p16 = p5;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p5.getColor() + " " + modelName + " " + p5.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else {
                        if (p8.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p16 = p8;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p8.getColor() + " " + modelName + " " + p8.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    // Now to display the accessories available for this model
                    System.out.println("These are the following accessories available for the " + modelName + ":");
                    m1.displayAccessories();
                    c3.displayAccessories();
                    c4.displayAccessories();
                    System.out.println("Please select one of the following accessories or choose NO to skip accessory purchase:");
                    System.out.println("MagSafe Charger or Case");

                    accessory = input.next();

                    if (accessory.equals("NO") || accessory.equals("No") || accessory.equals("no")) { //cart view no accessories
                        //represent cart HERE
                        fullTotal += p16.getPrice();
                        printCart(modelName, color, fullTotal, phonePrice);
                        status = input.next();
                        if (status.equals("Confirm")) {
                            p16.buyPhone(storage, color);
                            System.out.println("1. Continue: to continue purchasing");
                            System.out.println("2. Stop: to stop shopping");
                            status2 = input.next();
                            if (status2.equals("Continue")) {
                                validColor = false;
                                validCaseColor = false;
                                continue;
                            }
                            else if (status2.equals("Stop")) {
                                completedShop = true;
                                break;
                            }

                        }
                        else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                            validColor = false;
                            validCaseColor = false;
                            continue;
                        }
                        else {
                        	throw new IOException("Invalid Input");
                        }
                    }

                    else if (p3.verifyAccessory(accessory)){
                        if (accessory.equals("Case")) {
                            accessoryPrice = c3.getPrice();
                            while (!validCaseColor) { //Color selection
                                System.out.println("Please select the desired color for the " + modelName + " Case:");
                                c1.displayCaseColors(modelName);
                                caseColor = input.next();
                                if (c1.verifyCaseColor(modelName, caseColor)) {
                                    System.out.println("Successfully added to cart!"); //CHECK THIS
                                    if (caseColor.equals("Blue")){
                                        c7 = c3;
                                    }
                                    else{
                                        c7 = c4;
                                    }
                                    if (c7.getStock() != 0) {
	                                    fullTotal += phonePrice;
	                                    fullTotal += accessoryPrice;
	                                    printCart(modelName, color, fullTotal, phonePrice, "Case", c7.getColor(), accessoryPrice);
	                                    status = input.next();
	                                    if (status.equals("Confirm")) {
	                                        p16 .buyPhone(storage, color);
	                                        c7.buyCase(modelName, c7.getColor());
	                                        System.out.println("1. Continue: to continue purchasing");
	                                        System.out.println("2. Stop: to stop shopping");
	                                        status2 = input.next();
	                                        if (status2.equals("Continue")) {
	                                            validColor = false;
	                                            validCaseColor = false;
	                                            break;
	                                        }
	                                        else if (status2.equals("Stop")) {
	                                            completedShop = true;
	                                            break;
	                                        }
	
	                                    }
	                                    else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
	                                        validColor = false;
	                                        validCaseColor = false;
	                                        continue;
	                                    }
	                                    else {
	                                    	throw new IOException();
	                                    } 
                                    }
                                    else {
                                        throw new IOException("OUT OF STOCK");
                                    }
                                    break; 
                        }
                                }
                            	continue;
                            }
                        else { //MagSafe Charger
                                    accessoryPrice = m1.getPrice();
                                    System.out.println("Successfully added to cart!"); //CHECK THIS
                                    m3 = m1;
                                    fullTotal += phonePrice;
                                    fullTotal += accessoryPrice;
                                    printCart(modelName, color, fullTotal, phonePrice, "MagSafe Charger", accessoryPrice);
                                    status = input.next();
                                    if (status.equals("Confirm")) {
                                        p16.buyPhone(storage, color);
                                        m3.buyMagSafeCharger(modelName);
                                        System.out.println("1. Continue: to continue purchasing");
                                        System.out.println("2. Stop: to stop shopping");
                                        status2 = input.next();
                                        if (status2.equals("Continue")) {
                                            validColor = false;
                                            validCaseColor = false;
                                            continue;
                                        }
                                        else if (status2.equals("Stop")) {
                                            completedShop = true;
                                            break;
                                        }

                                    }
                                    else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                                        validColor = false;
                                        validCaseColor = false;
                                        continue;
                                    }
                                    else {
                                    	throw new IOException("Invalid Input");
                                    }
                                    break;
                        } }
                    
                    else {
                    	throw new IOException("Invalid Input");
                    }
                }
                else {
                    System.out.println("The storage you have selected is not available for this model!");
                    System.out.println("Restarting phone selection...");
                    continue;
                }
            }
            else if( modelName.equals("iPhone 13")) {
                System.out.println("Please select the desired storage for the " + modelName + ":");
                p11.displayStorages();
                storage = Integer.valueOf(input.next());
                if (p11.verifyStorage(storage)) { //Storage selection
                    if (storage == 128) {
                        phonePrice = 450;
                    }
                    else {
                        phonePrice = 500;
                    }
                    while (!validColor) {
                        System.out.println("Please select the desired color for the " + modelName + ":");
                        p11.displayColors();
                        color = input.next();
                        if (p11.verifyColor(color)) { //Color selection
                            validColor = true;
                            break;
                        }
                        else {
                            System.out.println("The color you have selected is not available for this model!");
                            System.out.println("Please try again!");
                            continue;
                        }
                    }
                    //validating if selected phone is in Stock
                    if (color.equals("Black") && storage == 128) {
                        if (p10.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p17 = p10;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p10.getColor() + " " + modelName + " " + p10.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                        }
                    }
                    else if (color.equals("Black") && storage == 256){
                        if (p13.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p17 = p13;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p13.getColor() + " " + modelName + " " + p13.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else if (color.equals("White") && storage == 128){
                        if (p9.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p17 = p9;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p9.getColor() + " " + modelName + " " + p9.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else if (color.equals("White") && storage == 256){
                        if (p12.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p17 = p12;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p12.getColor() + " " + modelName + " " + p12.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else if (color.equals("Red") && storage == 128){
                        if (p11.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p17 = p11;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p11.getColor() + " " + modelName + " " + p11.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    else {
                        if (p14.getStock() != 0) {
                            System.out.println("Successfully added to cart!");
                            p17 = p14;
                        }
                        else {
                            System.out.println("Unfortunatley the " + p14.getColor() + " " + modelName + " " + p14.getStorage() + "GB is out of stock!");
                            System.out.println("Select a different model, model storage capacity, or model color during your next transaction.");
                            continue;
                        }
                    }
                    // Now to display the accessories available for this model
                    System.out.println("These are the following accessories available for the " + modelName + ":");
                    m2.displayAccessories();
                    c5.displayAccessories();
                    c6.displayAccessories();
                    a1.displayAccessories();
                    System.out.println("Please select one of the following accessories or choose NO to skip accessory purchase:");
                    System.out.println("MagSafe Charger or Case or Airpods");

                    accessory = input.next();

                    if (accessory.equals("NO") || accessory.equals("No") || accessory.equals("no")) { //cart view no accessories
                        //represent cart HERE
                        fullTotal += p17.getPrice();
                        printCart(modelName, color, fullTotal, phonePrice);
                        status = input.next();
                        if (status.equals("Confirm")) {
                            p17.buyPhone(storage, color);
                            System.out.println("1. Continue: to continue purchasing");
                            System.out.println("2. Stop: to stop shopping");
                            status2 = input.next();
                            if (status2.equals("Continue")) {
                                validColor = false;
                                validCaseColor = false;
                                continue;
                            }
                            else if (status2.equals("Stop")) {
                                completedShop = true;
                                break;
                            }

                        }
                        else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                            validColor = false;
                            validCaseColor = false;
                            continue;
                        }
                        else {
                        	throw new IOException("Invalid Input");
                        }
                    }

                    else if (p11.verifyAccessory(accessory)){
                        if (accessory.equals("Case")) {
                            accessoryPrice = c5.getPrice();
                            while (!validCaseColor) { //Color selection
                                System.out.println("Please select the desired color for the " + modelName + " Case:");
                                c1.displayCaseColors(modelName);
                                caseColor = input.next();
                                if (c1.verifyCaseColor(modelName, caseColor)) {
                                    System.out.println("Successfully added to cart!"); //CHECK THIS
                                    if (caseColor.equals("Yellow")){
                                        c7 = c5;
                                    }
                                    else{
                                        c7 = c6;
                                    }
                                    fullTotal += phonePrice;
                                    fullTotal += accessoryPrice;
                                    printCart(modelName, color, fullTotal, phonePrice, "Case", c7.getColor(), accessoryPrice);
                                    status = input.next();
                                    if (status.equals("Confirm")) {
                                        p17.buyPhone(storage, color);
                                        c7.buyCase(modelName, c7.getColor());
                                        System.out.println("1. Continue: to continue purchasing");
                                        System.out.println("2. Stop: to stop shopping");
                                        status2 = input.next();
                                        if (status2.equals("Continue")) {
                                            validColor = false;
                                            validCaseColor = false;
                                            break;
                                        }
                                        else if (status2.equals("Stop")) {
                                            completedShop = true;
                                            break;
                                        }

                                    }
                                    else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                                        validColor = false;
                                        validCaseColor = false;
                                        continue;
                                    }
                                    else {
                                    	throw new IOException("Invalid Input");
                                    }
                                    break;
                        }}
                            continue;}
                        else if(accessory.equals("Airpods")) {
                            accessoryPrice = a1.getPrice();
                            System.out.println("Successfully added to cart!"); //CHECK THIS
                            a2 = a1;
                            fullTotal += phonePrice;
                            fullTotal += accessoryPrice;
                            printCart(modelName, color, fullTotal, phonePrice, "MagSafe Charger", accessoryPrice);
                            status = input.next();
                            if (status.equals("Confirm")) {
                                p17.buyPhone(storage, color);
                                a2.buyAirPods(modelName);
                                System.out.println("1. Continue: to continue purchasing");
                                System.out.println("2. Stop: to stop shopping");
                                status2 = input.next();
                                if (status2.equals("Continue")) {
                                    validColor = false;
                                    validCaseColor = false;
                                    continue;
                                }
                                else if (status2.equals("Stop")) {
                                    completedShop = true;
                                    break;
                                }

                            }
                            else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                                validColor = false;
                                validCaseColor = false;
                                continue;
                            }
                            else {
                            	throw new IOException("Invalid Input");
                            }
                            break;
                        }

                        else { //MagSafe Charger
                            accessoryPrice = m1.getPrice();
                            System.out.println("Successfully added to cart!"); //CHECK THIS
                            m3 = m2;
                            fullTotal += phonePrice;
                            fullTotal += accessoryPrice;
                            printCart(modelName, color, fullTotal, phonePrice, "MagSafe Charger", accessoryPrice);
                            status = input.next();
                            if (status.equals("Confirm")) {
                                p17.buyPhone(storage, color);
                                m3.buyMagSafeCharger(modelName);
                                System.out.println("1. Continue: to continue purchasing");
                                System.out.println("2. Stop: to stop shopping");
                                status2 = input.next();
                                if (status2.equals("Continue")) {
                                    validColor = false;
                                    validCaseColor = false;
                                    continue;
                                }
                                else if (status2.equals("Stop")) {
                                    completedShop = true;
                                    break;
                                }

                            }
                            else if (status.equals("No") || status.equals("no") || status.equals("NO")) {
                                validColor = false;
                                validCaseColor = false;
                                continue;
                            }
                            else {
                                throw new IOException("Invalid Input");
                            }
                            break;
                        }
                    }

                    else {
                        //catch error
                    }
                }
                else {
                    System.out.println("The storage you have selected is not available for this model!");
                    System.out.println("Restarting phone selection...");
                    continue;
                }
            }
            else {
                System.out.println("Unfortunatley this model is not sold in our store!");
                continue;
            }
        }
        System.out.println("Your total is $"+ fullTotal +". Thank you for shopping at iMax! We hope to see you again soon!");
        input.close();
        return;}
        
        catch(Exception IOException) {
        	System.out.println("Invalid Input Terminating Program");
        	System.exit (0);
        }
    }

    public static void printCart(String modelName, String color, int total, int phonePrice) { //No Accessories
        System.out.println("1. " + modelName + " = $" + phonePrice);
        System.out.println("2. Color = " + color);
        System.out.println("3. Total = " + "$" + total);
        System.out.println("4. Action: Confirm, No Repeat the process");
        System.out.println("	i. Confirm: Complete the sale");
        System.out.println("	ii.No: Start from the beginning");
    }

    public static void printCart(String modelName, String color, int total, int phonePrice, String accessoryName, int accessoryPrice) { //Airpods or MagSafe
        System.out.println("1. " + modelName + " = $" + phonePrice);
        System.out.println("2. Color = " + color);
        System.out.println("3. " + accessoryName +" = $" + accessoryPrice);
        System.out.println("4. Total = " + "$" + total);
        System.out.println("5. Action: Confirm, No Repeat the process");
        System.out.println("	i. Confirm: Complete the sale");
        System.out.println("	ii.No: Start from the beginning");
    }

    public static void printCart(String modelName, String color, int total, int phonePrice, String accessoryName, String caseColor, int accessoryPrice) { //Case
        System.out.println("1. " + modelName + " = $" + phonePrice);
        System.out.println("2. Color = " + color);
        System.out.println("3. " + caseColor + " "+ accessoryName +" = $" + accessoryPrice);
        System.out.println("4. Total = " + "$" + total);
        System.out.println("5. Action: Confirm, No Repeat the process");
        System.out.println("	i. Confirm: Complete the sale");
        System.out.println("	ii.No: Start from the beginning");
    }

};