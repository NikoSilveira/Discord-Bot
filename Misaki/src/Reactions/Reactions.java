package Reactions;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
			
		
		//event.getMessage().addReaction("❌").queue();
		
	}
}
