package Events;

import java.util.Random;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageEvents extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//List of meme messages
		String[] messagesMeme = {
				"Did someone say MEMES?",
				"Want some memes?",
				"Ne, share some memes!"
			};
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
		
		
		//EVENTS
		
		//reacting to meme mention
		for(int i=0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("meme") || args[i].equalsIgnoreCase("Meme") || args[i].equalsIgnoreCase("memes") || args[i].equalsIgnoreCase("Memes")) {
				
				Random rand = new Random();
				int number = rand.nextInt(messagesMeme.length);
				
				event.getChannel().sendMessage("" + messagesMeme[number]).queue();
				break;
				
			}
		}
			
		/*
		//Call everyone to voice chat
		for(int i=0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("vc") || args[i].equalsIgnoreCase("Vc") || args[i].equalsIgnoreCase("VC") || 
				args[i].equalsIgnoreCase("vc?") || args[i].equalsIgnoreCase("Vc?") || args[i].equalsIgnoreCase("VC?")) {
				
				event.getChannel().sendMessage("@everyone come forth to vc!").queue();
				break;
				
			}
		}
		
		//Greet people
		for(int i=0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("Hello") || args[i].equalsIgnoreCase("hello")) {
				
				event.getChannel().sendMessage("Hello!").queue();
				break;
				
			}
		}*/
		
		
	}
}
