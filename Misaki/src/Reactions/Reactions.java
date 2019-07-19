package Reactions;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
			
		for(int i=0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("vc") || args[i].equalsIgnoreCase("Vc") || args[i].equalsIgnoreCase("VC") || 
				args[i].equalsIgnoreCase("vc?") || args[i].equalsIgnoreCase("Vc?") || args[i].equalsIgnoreCase("VC?")) {
				
				event.getChannel().sendMessage("@everyone come forth to vc!").queue();
				
			}
		}
		
		//event.getMessage().addReaction("❌").queue();
		
	}
}
