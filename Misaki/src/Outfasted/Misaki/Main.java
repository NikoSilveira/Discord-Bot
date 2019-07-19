package Outfasted.Misaki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

import javax.security.auth.login.LoginException;

import Commands.BasicCommands;
import Commands.RandomCommands;
import Events.Events;
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
		
		//Obtain token
		File file = new File("C:\\Users\\Nicolas Silveira\\git\\Discord-Bot\\Misaki\\config.secrets");
		Scanner sc = new Scanner(file);
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(sc.nextLine()).build();
		} finally {
			sc.close();
		}
		
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setGame(Game.watching("Toaru Kagaku no Accelerator. || --commands"));
		
		jda.addEventListener(new BasicCommands());
		jda.addEventListener(new RandomCommands());
		jda.addEventListener(new Events());
		jda.addEventListener(new Reactions());
		jda.addEventListener(new Filter());
	}
}
