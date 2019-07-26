package Outfasted.Misaki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

import javax.security.auth.login.LoginException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Commands.BasicCommands;
import Commands.FilterCommands;
import Commands.InfoCommands;
import Commands.MessageCommands;
import Commands.MusicCommands;
import Commands.RandomCommands;
import Events.JoinLeaveEvents;
import Events.MessageEvents;
import Filter.Filter;
import Reactions.Reactions;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	
	public static JDA jda;
	public static String prefix = "--";
	
	
	//Main method
	public static void main(String[] args) throws LoginException, FileNotFoundException{
		
		//GUI for shutdown
		JFrame frame = new JFrame();
		window shutDown = new window();
		
		shutDown.setVisible(true);
		frame.add(shutDown);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(330,150);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Misaki - shut down");
		
		//Scanner
		File file = new File("C:\\Users\\Nicolas Silveira\\git\\Discord-Bot\\Misaki\\config.secrets");
		Scanner sc = new Scanner(file);
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(sc.nextLine()).build();
		} finally {
			sc.close();
		}
		
		//Set bot status and info
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setGame(Game.watching("Toaru Kagaku no Accelerator.  || --commands"));
		
		//Assembly of functionalities
		jda.addEventListener(new BasicCommands());
		jda.addEventListener(new RandomCommands());
		jda.addEventListener(new FilterCommands());
		jda.addEventListener(new InfoCommands());
		jda.addEventListener(new MessageCommands());
		jda.addEventListener(new MusicCommands());
		jda.addEventListener(new JoinLeaveEvents());
		jda.addEventListener(new MessageEvents());
		jda.addEventListener(new Reactions());
		jda.addEventListener(new Filter());
		
	}
}
