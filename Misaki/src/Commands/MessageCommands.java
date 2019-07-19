package Commands;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageCommands extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//Avoid responding to other bots
		if (event.getAuthor().isBot()) {
			return;
		}  
		
		
		//COMMANDS
		
		if(args[0].equalsIgnoreCase(Main.prefix + "ara")) {				//Ara Ara
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Ara Ara " + event.getAuthor().getName() + " ⭐").queue();
			
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "talk")) {		//Talk through bot
			
			args[0] = "";	//Ignore command in String
			
			if(args[1].equalsIgnoreCase("del")) {	
				
				//Delete original message
				event.getMessage().delete().queue();
				args[1] = "";
				
			}
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("" + String.join(" ",args)).queue();
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "f")) {			//F in the chat
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("F in the chat").queue();;
			
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "announce")) {	//Announcement
			
			args[0] = "";
			
			event.getMessage().delete().queue();
			event.getChannel().sendMessage("@everyone, "+ event.getAuthor().getName() + " has an announcement: " + String.join(" ",args)).queue();
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "call")) {		//Call everyone
			
			event.getMessage().delete().queue();;
			event.getChannel().sendMessage("@everyone, "+ event.getAuthor().getName() + " is summoning you!").queue();
			
		}
	}
}
