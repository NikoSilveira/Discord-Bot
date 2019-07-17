package Outfasted.Misaki;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	public static JDA jda;
	public static String prefix = "=";
	
	//Main method
	public static void main(String[] args) throws LoginException{
		
		jda = new JDABuilder(AccountType.BOT).setToken("NTk5NzA1MDQyNjk3NTg0NzAw.XSyoAA.h82iYGCV2EGHjXuuj_v0KFhqa_E").buildAsync();
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setGame(Game.watching("Toaru Kagaku no Accelerator. || =commands"));
		
		jda.addEventListener(new Commands());
		jda.addEventListener(new Events());
	}
}
