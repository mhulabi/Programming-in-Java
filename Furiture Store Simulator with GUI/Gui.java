package com.mohi.ifurnex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Gui extends JFrame {
	
	//The present frames
	private JPanel signIn;
	private JPanel signUp;
	private JPanel displayFurniture;
	private JPanel showCart;
	private JPanel stopOrNew;
	private JPanel backgroundPanel;
	private JPanel backgroundPanel2;
	private JPanel blurBackgroundPanel;
	private JPanel blurBackgroundPanel2;
	private JPanel blurBackgroundPanel3;
	private JPanel signBack;
	private JPanel signUpBack;
	private JPanel furnitureBack;
	private JPanel cartBack;
	private JPanel stopOrNewBack;
	
	//LayeredPanes
	private JLayeredPane signInBack;
	private JLayeredPane signUpBackground;
	private JLayeredPane furnitureBackground;
	private JLayeredPane cartBackground;
	private JLayeredPane stopOrNewBackground;
	
	//Buttons
	private JButton signInButton;
	private JButton signUpButton1; //Go to sign up frame
	private JButton signUpButton2; //actual sign up after entering information
	private JButton addChair;
	private JButton removeChair;
	private JButton addCouch;
	private JButton removeCouch;
	private JButton addBed;
	private JButton removeBed;
	private JButton addTable;
	private JButton removeTable;
	private JButton goToCart;
	private JButton confirmPurchase;
	private JButton restartPurchase;
	private JButton newPurchase;
	private JButton leaveStore;
	
	//Text Fields
	private JTextField username;
	private JTextField password;
	private JTextField newUsername;
	private JTextField newPassword;
	
	//Labels
	private JLabel user;
	private JLabel pass;
	private JLabel newUser;
	private JLabel newPass;
	private JLabel loginStatus;
	private JLabel signUpStatus;
	private JLabel backgroundIcon;
	private JLabel backgroundIcon1;
	private JLabel blurBackgroundIcon;
	private JLabel blurBackgroundIcon1;
	private JLabel blurBackgroundIcon2;
	private JLabel chairPrice;
	private JLabel couchPrice;
	private JLabel bedPrice;
	private JLabel tablePrice;
	private JLabel chairIcon;
	private JLabel couchIcon;
	private JLabel bedIcon;
	private JLabel tableIcon;
	private JLabel chairLabel;
	private JLabel couchLabel;
	private JLabel bedLabel;
	private JLabel tableLabel;
	private JLabel cartStatus;
	private JLabel chairCart;
	private JLabel couchCart;
	private JLabel bedCart;
	private JLabel tableCart;
	private JLabel chairDetail;
	private JLabel couchDetail;
	private JLabel bedDetail;
	private JLabel tableDetail;
	private JLabel total;
	private JLabel thankYou;
	
	//Furniture Objects
	public Chair chair;
	public Table table;
	public Couch couch;
	public Bed bed;
	
	//numbers sold
	public int chairs;
	public int couches;
	public int beds;
	public int tables;
	
	//Calculate rounded prices 
	public double finalPrice;
	public double roundBed;
	public double roundChair;
	public double roundCouch; 
	public double roundTable;
	
	public Gui() throws IOException {
		
		super("iFurnex");
		
		this.setSize(700, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Loading background images
		File backgroundImage = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\iFurnex.png");
		BufferedImage loadBackground = ImageIO.read(backgroundImage);
		backgroundIcon = new JLabel(new ImageIcon(loadBackground));
		backgroundIcon.setBounds(0, 0, 700, 600);
		
		File backgroundImage1 = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\iFurnex.png");
		BufferedImage loadBackground1 = ImageIO.read(backgroundImage1);
		backgroundIcon1 = new JLabel(new ImageIcon(loadBackground1));
		backgroundIcon1.setBounds(0, 0, 700, 600);
		
		File blurBackgroundImage = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\blur.png");
		BufferedImage loadBlurBackground = ImageIO.read(blurBackgroundImage);
		blurBackgroundIcon = new JLabel(new ImageIcon(loadBlurBackground));
		blurBackgroundIcon.setBounds(0, 0, 700, 600);
		
		File blurBackgroundImage1 = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\blur.png");
		BufferedImage loadBlurBackground1 = ImageIO.read(blurBackgroundImage1);
		blurBackgroundIcon1 = new JLabel(new ImageIcon(loadBlurBackground1));
		blurBackgroundIcon1.setBounds(0, 0, 700, 600);
		
		File blurBackgroundImage2 = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\blur.png");
		BufferedImage loadBlurBackground2 = ImageIO.read(blurBackgroundImage2);
		blurBackgroundIcon2 = new JLabel(new ImageIcon(loadBlurBackground2));
		blurBackgroundIcon2.setBounds(0, 0, 700, 600);
		
		//Panels taking the layered pane
		signBack = new JPanel(new BorderLayout());
		signBack.setLayout(null);
		signBack.setBounds(0,0,700,600);
		signBack.setOpaque(false);
		this.add(signBack);
		
		signUpBack = new JPanel(new BorderLayout());
		signUpBack.setLayout(null);
		signUpBack.setBounds(0,0,700,600);
		signUpBack.setOpaque(false);
		this.add(signUpBack);
		
		furnitureBack = new JPanel(new BorderLayout());
		furnitureBack.setLayout(null);
		furnitureBack.setBounds(0,0,700,600);
		furnitureBack.setOpaque(false);
		this.add(furnitureBack);
		
		cartBack = new JPanel(new BorderLayout());
		cartBack.setLayout(null);
		cartBack.setBounds(0,0,700,600);
		cartBack.setOpaque(false);
		this.add(cartBack);
		
		stopOrNewBack = new JPanel(new BorderLayout());
		stopOrNewBack.setLayout(null);
		stopOrNewBack.setBounds(0,0,700,600);
		stopOrNewBack.setOpaque(false);
		this.add(stopOrNewBack);
		
		//Layered panes to display panel on background image
		signInBack = new JLayeredPane();
		signInBack.setBounds(0,0,700,600);
		signBack.add(signInBack);
		
		signUpBackground = new JLayeredPane();
		signUpBackground.setBounds(0,0,700,600);
		signUpBack.add(signUpBackground);
		
		furnitureBackground = new JLayeredPane();
		furnitureBackground.setBounds(0,0,700,600);
		furnitureBack.add(furnitureBackground);
		
		cartBackground = new JLayeredPane();
		cartBackground.setBounds(0,0,700,600);
		cartBack.add(cartBackground);
		
		stopOrNewBackground = new JLayeredPane();
		stopOrNewBackground.setBounds(0,0,700,600);
		stopOrNewBack.add(stopOrNewBackground);
		
		//Background Panels
		backgroundPanel = new JPanel();
		backgroundPanel.setLayout(null);
		backgroundPanel.setBounds(0,0,700,600);
		backgroundPanel.setOpaque(false);
		backgroundPanel.add(backgroundIcon);
		
		backgroundPanel2 = new JPanel();
		backgroundPanel2.setLayout(null);
		backgroundPanel2.setBounds(0,0,700,600);
		backgroundPanel2.setOpaque(false);
		backgroundPanel2.add(backgroundIcon1);
		
		blurBackgroundPanel = new JPanel();
		blurBackgroundPanel.setLayout(null);
		blurBackgroundPanel.setBounds(0,0,700,600);
		blurBackgroundPanel.setOpaque(false);
		blurBackgroundPanel.add(blurBackgroundIcon);
		
		blurBackgroundPanel2 = new JPanel();
		blurBackgroundPanel2.setLayout(null);
		blurBackgroundPanel2.setBounds(0,0,700,600);
		blurBackgroundPanel2.setOpaque(false);
		blurBackgroundPanel2.add(blurBackgroundIcon1);
		
		blurBackgroundPanel3 = new JPanel();
		blurBackgroundPanel3.setLayout(null);
		blurBackgroundPanel3.setBounds(0,0,700,600);
		blurBackgroundPanel3.setOpaque(false);
		blurBackgroundPanel3.add(blurBackgroundIcon2);
		
		//Sign In
		signIn = new JPanel(new BorderLayout());
		signIn.setLayout(null);
		signIn.setBounds(0,0,700,600);
		signIn.setOpaque(false);

		signInBack.setLayer(backgroundPanel, 0);
		signInBack.setLayer(signIn, 1);
		signInBack.add(backgroundPanel);
		signInBack.add(signIn);
		
		signInButton = new JButton("Sign In");
		signInButton.setBounds(260, 300, 80, 25);
		
		signUpButton1 = new JButton("Sign Up");
		signUpButton1.setBounds(380, 300, 80, 25);
		
		signIn.add(signInButton);		
		signIn.add(signUpButton1);
		
		loginStatus = new JLabel("");
        loginStatus.setFont(new Font("Onyx", Font.PLAIN, 40));
        loginStatus.setForeground(Color.BLACK);
		loginStatus.setBounds(0, 400, 500, 30);
		signIn.add(loginStatus);
		
		username = new JTextField();
		user = new JLabel("Username: ");
        username.setBounds(260, 200, 200, 25);
        user.setBounds(190, 200, 200, 25);
        signIn.add(username);
        signIn.add(user);
        
        password = new JTextField();
        pass = new JLabel("Password: ");
        password.setBounds(260, 250, 200, 25);
        pass.setBounds(190, 250, 200, 25);
        signIn.add(password);
        signIn.add(pass);
				
        //Sign Up
		signUp = new JPanel();
		signUp.setLayout(null);
		signUp.setBounds(0,0,700,600);
		signUp.setOpaque(false);
		
		signUpBackground.setLayer(backgroundPanel2, 0);
		signUpBackground.setLayer(signUp, 1);
		signInBack.add(backgroundPanel2);
		signInBack.add(signUp);
		
		signUpButton2 = new JButton("Sign Up");
		signUpButton2.setBounds(310, 300, 80, 25);
		
		signUp.add(signUpButton2);
		
		signUpStatus = new JLabel("");
		signUpStatus.setFont(new Font("Onyx", Font.PLAIN, 40));
		signUpStatus.setForeground(Color.BLACK);
		signUpStatus.setBounds(0, 400, 600, 40);
		signUp.add(signUpStatus);
		
		newUsername = new JTextField();
		newUser = new JLabel("Username: ");
        newUsername.setBounds(250, 200, 200, 25);
        newUser.setBounds(180, 200, 200, 25);
        signUp.add(newUsername);
        signUp.add(newUser);
        
        newPassword = new JTextField();
        newPass = new JLabel("Password: ");
        newPassword.setBounds(250, 250, 200, 25);
        newPass.setBounds(180, 250, 200, 25);
        signUp.add(newPassword);
        signUp.add(newPass);
		
        //Display Furniture
		displayFurniture = new JPanel();
		displayFurniture.setLayout(null);
		displayFurniture.setBounds(0,0,700,600);
		displayFurniture.setOpaque(false);
		
		furnitureBackground.setLayer(blurBackgroundPanel, 0);
		furnitureBackground.setLayer(displayFurniture, 1);
		furnitureBackground.add(blurBackgroundPanel);
		furnitureBackground.add(displayFurniture);
		
		chairs = 0;
		couches = 0;
		beds = 0;
		tables = 0;
		
		cartStatus = new JLabel("");
		cartStatus.setFont(new Font("Onyx", Font.PLAIN, 40));
		cartStatus.setForeground(Color.BLACK);
		cartStatus.setBounds(0, 500, 600, 40);
		displayFurniture.add(cartStatus);
		
		chairPrice = new JLabel("$");
		chairPrice.setFont(new Font("Onyx", Font.PLAIN, 35));
		chairPrice.setBounds(73, 380, 70, 40);
		displayFurniture.add(chairPrice);
		
		couchPrice = new JLabel("$");
		couchPrice.setFont(new Font("Onyx", Font.PLAIN, 35));
		couchPrice.setBounds(248, 380, 70, 40);
		displayFurniture.add(couchPrice);
		
		bedPrice = new JLabel("$");
		bedPrice.setFont(new Font("Onyx", Font.PLAIN, 35));
		bedPrice.setBounds(428, 380, 70, 40);
		displayFurniture.add(bedPrice);
		
		tablePrice = new JLabel("$");
		tablePrice.setFont(new Font("Onyx", Font.PLAIN, 35));
		tablePrice.setBounds(578, 380, 70, 40);
		displayFurniture.add(tablePrice);
		
		chairCart = new JLabel("0");
		chairCart.setFont(new Font("Onyx", Font.PLAIN, 35));
		chairCart.setBounds(90, 350, 35, 35);
		displayFurniture.add(chairCart);
		
		chairLabel = new JLabel("Chair");
		chairLabel.setFont(new Font("Onyx", Font.PLAIN, 35));
        chairLabel.setBounds(65, 200, 200, 35);
        displayFurniture.add(chairLabel);
        
        couchCart = new JLabel("0");
		couchCart.setFont(new Font("Onyx", Font.PLAIN, 35));
		couchCart.setBounds(265, 350, 35, 35);
		displayFurniture.add(couchCart);
        
        couchLabel = new JLabel("Couch");
        couchLabel.setFont(new Font("Onyx", Font.PLAIN, 35));
        couchLabel.setBounds(250, 200, 200, 35);
        displayFurniture.add(couchLabel);
        
        bedCart = new JLabel("0");
		bedCart.setFont(new Font("Onyx", Font.PLAIN, 35));
		bedCart.setBounds(445, 350, 35, 35);
		displayFurniture.add(bedCart);
        
        bedLabel = new JLabel("Bed");
        bedLabel.setFont(new Font("Onyx", Font.PLAIN, 35));
        bedLabel.setBounds(430, 200, 200, 35);
        displayFurniture.add(bedLabel);
        
        tableCart = new JLabel("0");
		tableCart.setFont(new Font("Onyx", Font.PLAIN, 35));
		tableCart.setBounds(595, 350, 35, 35);
		displayFurniture.add(tableCart);
        
        tableLabel = new JLabel("Table");
        tableLabel.setFont(new Font("Onyx", Font.PLAIN, 35));
        tableLabel.setBounds(580, 200, 200, 35);
        displayFurniture.add(tableLabel);
        
        addChair = new JButton("+");
        addChair.setMargin(new Insets(0,0,0,0));
		addChair.setBounds( 120, 350, 25, 25);
		displayFurniture.add(addChair);
		
		removeChair = new JButton("-");
		removeChair.setMargin(new Insets(0,0,0,0));
		removeChair.setBounds( 45, 350, 25, 25);
		displayFurniture.add(removeChair);
		
		addCouch = new JButton("+");
		addCouch.setMargin(new Insets(0,0,0,0));
		addCouch.setBounds( 295, 350, 25, 25);
		displayFurniture.add(addCouch);
		
		removeCouch = new JButton("-");
		removeCouch.setMargin(new Insets(0,0,0,0));
		removeCouch.setBounds( 220, 350, 25, 25);
		displayFurniture.add(removeCouch);
		
		addBed = new JButton("+");
        addBed.setMargin(new Insets(0,0,0,0));
		addBed.setBounds( 475, 350, 25, 25);
		displayFurniture.add(addBed);
		
		removeBed = new JButton("-");
		removeBed.setMargin(new Insets(0,0,0,0));
		removeBed.setBounds( 400, 350, 25, 25);
		displayFurniture.add(removeBed);
		
		addTable = new JButton("+");
        addTable.setMargin(new Insets(0,0,0,0));
		addTable.setBounds( 620, 350, 25, 25);
		displayFurniture.add(addTable);
		
		removeTable = new JButton("-");
		removeTable.setMargin(new Insets(0,0,0,0));
		removeTable.setBounds( 555, 350, 25, 25);
		displayFurniture.add(removeTable);
		
		goToCart = new JButton("Go To Cart!");
		goToCart.setMargin(new Insets(0,0,0,0));
		goToCart.setBounds( 285, 430, 100, 50);
		displayFurniture.add(goToCart);
		
		//Show Cart		
		showCart = new JPanel();
		showCart.setLayout(null);
		showCart.setBounds(0,0,700,600);
		showCart.setOpaque(false);
		
		cartBackground.setLayer(blurBackgroundPanel2, 0);
		cartBackground.setLayer(showCart, 1);
		cartBackground.add(blurBackgroundPanel2);
		cartBackground.add(showCart);
		
		confirmPurchase = new JButton("Confirm Purchase");
        confirmPurchase.setMargin(new Insets(0,0,0,0));
		confirmPurchase.setBounds(220, 400, 120, 40);
		
		restartPurchase = new JButton("Restart Purchase");
        restartPurchase.setMargin(new Insets(0,0,0,0));
		restartPurchase.setBounds(360, 400, 120, 40);
		
		showCart.add(confirmPurchase);
		showCart.add(restartPurchase);
		
		chairDetail = new JLabel("");
		chairDetail.setFont(new Font("Onyx", Font.PLAIN, 35));
		chairDetail.setForeground(Color.BLACK);
		chairDetail.setBounds(220, 150, 200, 40);
		showCart.add(chairDetail);
		
		couchDetail = new JLabel("");
		couchDetail.setFont(new Font("Onyx", Font.PLAIN, 35));
		couchDetail.setForeground(Color.BLACK);
		couchDetail.setBounds(220, 200, 200, 40);
		showCart.add(couchDetail);
		
		bedDetail = new JLabel("");
		bedDetail.setFont(new Font("Onyx", Font.PLAIN, 35));
		bedDetail.setForeground(Color.BLACK);
		bedDetail.setBounds(220, 250, 200, 40);
		showCart.add(bedDetail);
		
		tableDetail = new JLabel("");
		tableDetail.setFont(new Font("Onyx", Font.PLAIN, 35));
		tableDetail.setForeground(Color.BLACK);
		tableDetail.setBounds(220, 300, 200, 40);
		showCart.add(tableDetail);
		
		total = new JLabel("");
		total.setFont(new Font("Onyx", Font.PLAIN, 35));
		total.setForeground(Color.BLACK);
		total.setBounds(220, 350, 200, 40);
		showCart.add(total);
		
		//Stop or New		
		stopOrNew = new JPanel();
		stopOrNew.setLayout(null);
		stopOrNew.setBounds(0,0,700,600);
		stopOrNew.setOpaque(false);
				
		stopOrNewBackground.setLayer(blurBackgroundPanel3, 0);
		stopOrNewBackground.setLayer(stopOrNew, 1);
		stopOrNewBackground.add(blurBackgroundPanel3);
		stopOrNewBackground.add(stopOrNew);
		
		newPurchase = new JButton("New Purchase");
		newPurchase.setMargin(new Insets(0,0,0,0));
		newPurchase.setBounds(220, 300, 120, 40);
		
		leaveStore = new JButton("Leave iFurnex");
		leaveStore.setMargin(new Insets(0,0,0,0));
		leaveStore.setBounds(360, 300, 120, 40);
		
		stopOrNew.add(newPurchase);
		stopOrNew.add(leaveStore);
		
		thankYou = new JLabel("");
		thankYou.setFont(new Font("Onyx", Font.PLAIN, 40));
		thankYou.setForeground(Color.BLACK);
		thankYou.setBounds(60, 200, 600, 40);
		stopOrNew.add(thankYou);
		
		signIn.setBackground(Color.WHITE);
		signUp.setBackground(Color.RED);
		displayFurniture.setBackground(Color.GREEN);
		showCart.setBackground(Color.BLUE);	
	}
	
	public void execute() throws IOException {
		
		//IMPORTANT NOTE 
		//PLEASE WHEN TESTING, REPLACE THE OLD PATHS WITH THE NEW PATHS OF ANY FILE AFTER DOWNLOADING IT TO YOUR SYSTEM
		//THIS WILL ALLOW THE PROGRAM TO RUN AS INTENDED
		File login = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\Login Information.csv");
		File inventory = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\Stock.csv"); //Inventory is the stock
		String line;
		ArrayList<String> loginCredentials = new ArrayList<String>(); //contains valid login credentials
		ArrayList<String> inventoryInfo = new ArrayList<String>(); //take input of stock and price from csv
		ArrayList<String> finalInventoryInfo = new ArrayList<String>();//properly parsed strings
		String[] split; //used to remove the commas in inventoryInfo
		
		
		//Reading info from CSV files
		BufferedReader readLogin = new BufferedReader(new FileReader(login));
		BufferedReader readInventory = new BufferedReader(new FileReader(inventory));
		
		//Writing info into CSV files
		BufferedWriter writeLogin = new BufferedWriter(new FileWriter(login, true));
		
		//Loading images for background and furnitures
		File chairImage = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\chair.png");
		File couchImage = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\couch.png");
		File bedImage = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\bed.png");
		File tableImage = new File("C:\\Users\\mhula\\eclipse-workspace\\IFurnex\\src\\com\\mohi\\ifurnex\\table.png");
		BufferedImage loadChair = ImageIO.read(chairImage);
		BufferedImage loadCouch = ImageIO.read(couchImage);
		BufferedImage loadBed = ImageIO.read(bedImage);
		BufferedImage loadTable = ImageIO.read(tableImage);
	
		line = readLogin.readLine(); //skipping first line since they are column labels
		line = readLogin.readLine();
		while(line != null) {
			loginCredentials.add(line);
			line = readLogin.readLine(); 
		}
		
		line = readInventory.readLine(); //skipping first line since they are column labels
		line = readInventory.readLine();
		while(line != null) {
			inventoryInfo.add(line);
			line = readInventory.readLine(); 
		}
		
		readLogin.close();
		readInventory.close();
		
		//Initializing Furniture
		for(String info: inventoryInfo) {
			split = info.split("[,]", 0);
			for(String info2: split) {
				finalInventoryInfo.add(info2);
			}
		}
		
		for (int i = 0; i < 12; i+=3) {
			if (finalInventoryInfo.get(i).contains("Chair")) {
				chair = new Chair(loadChair, finalInventoryInfo.get(i), Integer.valueOf(finalInventoryInfo.get(i + 1)), Double.valueOf(finalInventoryInfo.get(i + 2)));
			}
			
			if (finalInventoryInfo.get(i).contains("Couch")) {
				couch = new Couch(loadCouch, finalInventoryInfo.get(i), Integer.valueOf(finalInventoryInfo.get(i + 1)), Double.valueOf(finalInventoryInfo.get(i + 2)));
			}
			
			if (finalInventoryInfo.get(i).contains("Bed")) {
				bed = new Bed(loadBed, finalInventoryInfo.get(i), Integer.valueOf(finalInventoryInfo.get(i + 1)), Double.valueOf(finalInventoryInfo.get(i + 2)));
			}
			
			if (finalInventoryInfo.get(i).contains("Table")) {
				table = new Table(loadTable, finalInventoryInfo.get(i), Integer.valueOf(finalInventoryInfo.get(i + 1)), Double.valueOf(finalInventoryInfo.get(i + 2)));
			}
		}
		
		//Adding the initialized images to the Shopping panel
		chairIcon = new JLabel(new ImageIcon(chair.getImage()));
		chairIcon.setBounds(45, 250, 100, 100);
		displayFurniture.add(chairIcon);
		couchIcon = new JLabel(new ImageIcon(couch.getImage()));
		couchIcon.setBounds(175, 250, 193, 100);
		displayFurniture.add(couchIcon);
		bedIcon = new JLabel(new ImageIcon(bed.getImage()));
		bedIcon.setBounds(378, 250, 133, 100);
		displayFurniture.add(bedIcon);
		tableIcon = new JLabel(new ImageIcon(table.getImage()));
		tableIcon.setBounds(550, 250, 100, 100);
		displayFurniture.add(tableIcon);
	
		backgroundPanel.setVisible(true);
		blurBackgroundPanel.setVisible(false);
		signIn.setVisible(true);
		backgroundPanel2.setVisible(false);
		blurBackgroundPanel2.setVisible(false);
		displayFurniture.setVisible(false);
		signUp.setVisible(false);
		showCart.setVisible(false);
		blurBackgroundPanel3.setVisible(false);
		stopOrNew.setVisible(false);
		
		//Button Actions
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verifyUsername = username.getText().trim();
				String verifyPassword = password.getText().trim();
				if (loginCredentials.contains(verifyUsername+","+verifyPassword)){
					chairPrice.setText("$"+chair.getPrice());
					couchPrice.setText("$"+couch.getPrice());
					bedPrice.setText("$"+bed.getPrice());
					tablePrice.setText("$"+table.getPrice());
					signIn.setVisible(false);
					backgroundPanel.setVisible(false);
					blurBackgroundPanel.setVisible(true);
					displayFurniture.setVisible(true);
				}
				
				else {
					loginStatus.setText("Invalid Username and/or Password");
				}
			}
		});
		
		signInButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				signInButton.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				signInButton.setBackground(UIManager.getColor("control"));
			}
		});
		
		signUpButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn.setVisible(false);
				backgroundPanel.setVisible(false);
				backgroundPanel2.setVisible(true);
				signUp.setVisible(true);
			}
		});
		
		signUpButton1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				signUpButton1.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				signUpButton1.setBackground(UIManager.getColor("control"));
			}
		});
		
		signUpButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String signUpUsername = newUsername.getText();
				String signUpPassword = newPassword.getText();
				if (!signUpUsername.isBlank() && !signUpPassword.isBlank()){ //Make label that whitespaces are allowed
					try {
						writeLogin.write(signUpUsername.trim()+","+signUpPassword.trim());
						writeLogin.newLine();
						writeLogin.close();
					} 
					catch (IOException e2) {
						System.out.println("Error while writing into file program terminated");
						System.exit(0);
					}
					chairPrice.setText("$"+chair.getPrice());
					couchPrice.setText("$"+couch.getPrice());
					bedPrice.setText("$"+bed.getPrice());
					tablePrice.setText("$"+table.getPrice());
					signUp.setVisible(false);
					backgroundPanel2.setVisible(false);
					blurBackgroundPanel.setVisible(true);
					displayFurniture.setVisible(true);
				}
				else {
					signUpStatus.setText("You cannot sign up with a blank Username and/or Password!");
				}
			}
		});
		
		signUpButton2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				signUpButton2.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				signUpButton2.setBackground(UIManager.getColor("control"));
			}
		});
		
		addChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( chairs + 1 <= chair.getStock()) {
					chairs++;
					chairCart.setText(Integer.toString(chairs));
					cartStatus.setText("Successfully added one chair to cart");
				}
				else {
					cartStatus.setText("We have no more chairs in stock for you to add!");
				}
			}
		});
		
		addChair.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				addChair.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				addChair.setBackground(UIManager.getColor("control"));
			}
		});
		
		removeChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chairs != 0) {
					chairs--;
					chairCart.setText(Integer.toString(chairs));
					cartStatus.setText("Successfully removed one chair from cart");
				}
				else {
					cartStatus.setText("There are no chairs in your cart for you to remove!");
				}
			}
		});
		
		removeChair.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				removeChair.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				removeChair.setBackground(UIManager.getColor("control"));
			}
		});
		
		addCouch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( couches + 1 <= couch.getStock()) {
					couches++;
					couchCart.setText(Integer.toString(couches));
					cartStatus.setText("Successfully added one couch to cart");
				}
				else {
					cartStatus.setText("We have no more couches in stock for you to add!");
				}
			}
		});
		
		addCouch.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				addCouch.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				addCouch.setBackground(UIManager.getColor("control"));
			}
		});
		
		removeCouch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (couches != 0) {
					couches--;
					couchCart.setText(Integer.toString(couches));
					cartStatus.setText("Successfully removed one couch from cart");
				}
				else {
					cartStatus.setText("There are no couches in your cart for you to remove!");
				}
			}
		});
		
		removeCouch.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				removeCouch.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				removeCouch.setBackground(UIManager.getColor("control"));
			}
		});
		
		addBed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( beds + 1 <= bed.getStock()) {
					beds++;
					bedCart.setText(Integer.toString(beds));
					cartStatus.setText("Successfully added one bed to cart");
				}
				else {
					cartStatus.setText("We have no more beds in stock for you to add!");
				}
			}
		});
		
		addBed.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				addBed.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				addBed.setBackground(UIManager.getColor("control"));
			}
		});
		
		removeBed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beds != 0) {
					beds--;
					bedCart.setText(Integer.toString(beds));
					cartStatus.setText("Successfully removed one bed from cart");
				}
				else {
					cartStatus.setText("There are no beds in your cart for you to remove!");
				}
			}
		});
		
		removeBed.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				removeBed.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				removeBed.setBackground(UIManager.getColor("control"));
			}
		});
		
		addTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( tables + 1 <= table.getStock()) {
					tables++;
					tableCart.setText(Integer.toString(tables));
					cartStatus.setText("Successfully added one table to cart");
				}
				else {
					cartStatus.setText("We have no more tables in stock for you to add!");
				}
			}
		});
		
		addTable.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				addTable.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				addTable.setBackground(UIManager.getColor("control"));
			}
		});
		
		removeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tables != 0) {
					tables--;
					tableCart.setText(Integer.toString(tables));
					cartStatus.setText("Successfully removed one table from cart");
				}
				else {
					cartStatus.setText("There are no tables in your cart for you to remove!");
				}
			}
		});
		
		removeTable.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				removeTable.setBackground(Color.YELLOW);
			}
			
			public void mouseExited(MouseEvent event) {
				removeTable.setBackground(UIManager.getColor("control"));
			}
		});
		
		goToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalPrice = 0;
				if (chairs != 0) {
					roundChair = Math.round((chair.getPrice()*chairs) * 100.0) / 100.0;
					chairDetail.setText(chairs + " Chairs ($" + chair.getPrice() + "): " + roundChair);
					finalPrice += roundChair;
					}
				if (couches != 0) {
					roundCouch = Math.round((couch.getPrice()*couches) * 100.0) / 100.0;
					couchDetail.setText(couches + " Couches ($" + couch.getPrice() + "): " + roundCouch);
					finalPrice += roundCouch;
					}
				if (beds != 0) {
					roundBed = Math.round((bed.getPrice()*beds) * 100.0) / 100.0;
					bedDetail.setText(beds + " Beds ($" + bed.getPrice() + "): " + roundBed);
					finalPrice += roundBed;
					}
				if (tables != 0) {
					roundTable = Math.round((table.getPrice()*tables) * 100.0) / 100.0;
					tableDetail.setText(tables + " Tables ($" + table.getPrice() + "): " + roundTable);
					finalPrice += roundTable;
					}
				finalPrice = Math.round(finalPrice * 100.0) / 100.0;
				total.setText("Total = $" + finalPrice);
				displayFurniture.setVisible(false);
				blurBackgroundPanel.setVisible(false);
				blurBackgroundPanel2.setVisible(true);
				showCart.setVisible(true);
			}
		});
		
		goToCart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				goToCart.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				goToCart.setBackground(UIManager.getColor("control"));
			}
		});
		
		confirmPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < chairs; i++) {
					chair.buyFurniture();
				}
				for (int i = 0; i < couches; i++) {
					couch.buyFurniture();
				}
				for (int i = 0; i < beds; i++) {
					bed.buyFurniture();
				}
				for (int i = 0; i < tables; i++) {
					table.buyFurniture();
				}
				thankYou.setText("Your Total is $"+ finalPrice +". Thank you for purchasing from iFurnex!");
				
				try {
					BufferedWriter writeInventory = new BufferedWriter(new FileWriter(inventory, false));
					writeInventory.write("Title,Stock,Price");
					writeInventory.newLine();
					writeInventory.write(chair.getTitle() +","+chair.getStock()+","+chair.getPrice());
					writeInventory.newLine();
					writeInventory.write(couch.getTitle() +","+couch.getStock()+","+couch.getPrice());
					writeInventory.newLine();
					writeInventory.write(bed.getTitle() +","+bed.getStock()+","+bed.getPrice());
					writeInventory.newLine();
					writeInventory.write(table.getTitle() +","+table.getStock()+","+table.getPrice());
					writeInventory.newLine();
					writeInventory.close();
				} 
				catch (IOException e1) {
					System.out.println("Error occured while writing into the csv file. Program terminated.");
					System.exit(0);
				}
				
				showCart.setVisible(false);
				blurBackgroundPanel2.setVisible(false);
				blurBackgroundPanel3.setVisible(true);
				stopOrNew.setVisible(true);
			}
		});
		
		confirmPurchase.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				confirmPurchase.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				confirmPurchase.setBackground(UIManager.getColor("control"));
			}
		});
		
		restartPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chairs = 0;
				couches = 0;
				beds = 0;
				tables = 0;
				finalPrice = 0.0;
				cartStatus.setText("");
				chairCart.setText("0");
				couchCart.setText("0");
				bedCart.setText("0");
				tableCart.setText("0");
				chairDetail.setText("");
				couchDetail.setText("");
				bedDetail.setText("");
				tableDetail.setText("");
				showCart.setVisible(false);
				blurBackgroundPanel2.setVisible(false);
				blurBackgroundPanel.setVisible(true);
				displayFurniture.setVisible(true);
			}
		});
		
		restartPurchase.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				restartPurchase.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				restartPurchase.setBackground(UIManager.getColor("control"));
			}
		});
		
		newPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chairs = 0;
				couches = 0;
				beds = 0;
				tables = 0;
				finalPrice = 0.0;
				cartStatus.setText("");
				chairCart.setText("0");
				couchCart.setText("0");
				bedCart.setText("0");
				tableCart.setText("0");
				chairDetail.setText("");
				couchDetail.setText("");
				bedDetail.setText("");
				tableDetail.setText("");
				stopOrNew.setVisible(false);
				blurBackgroundPanel3.setVisible(false);
				blurBackgroundPanel.setVisible(true);
				displayFurniture.setVisible(true);
			}
		});
		
		newPurchase.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				newPurchase.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				newPurchase.setBackground(UIManager.getColor("control"));
			}
		});
		
		leaveStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		leaveStore.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				leaveStore.setBackground(Color.LIGHT_GRAY);
			}
			
			public void mouseExited(MouseEvent event) {
				leaveStore.setBackground(UIManager.getColor("control"));
			}
		});
	}			

}
