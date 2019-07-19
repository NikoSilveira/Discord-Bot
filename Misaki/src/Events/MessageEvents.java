package Events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageEvents extends ListenerAdapter{

public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
			
		//Call everyone to voice chat
		for(int i=0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("vc") || args[i].equalsIgnoreCase("Vc") || args[i].equalsIgnoreCase("VC") || 
				args[i].equalsIgnoreCase("vc?") || args[i].equalsIgnoreCase("Vc?") || args[i].equalsIgnoreCase("VC?")) {
				
				event.getChannel().sendMessage("@everyone come forth to vc!").queue();
				
			}
		}
		
		//Greet people
		for(int i=0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("Hello") || args[i].equalsIgnoreCase("hello")) {
				
				event.getChannel().sendMessage("Hello!").queue();
				
			}
		}
		
		
	}
}
