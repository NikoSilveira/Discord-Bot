package Outfasted.Misaki;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Filter extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] message = event.getMessage().getContentRaw().split(" ");
		
		//Add words here
		String[] nopeWords = {"banana", "platano"};
		
		if(Commands.filterEnabled == true) {	//verify if filtered is enabled
			
			for(int i=0; i < message.length; i++) {
				
				for(int j=0; j < nopeWords.length; j++) {
					
					if (message[i].equalsIgnoreCase(nopeWords[j])) {
						event.getMessage().delete().queue();			//delete
						event.getChannel().sendMessage("Baka").queue();	//send warning
						
						//TODO catch insufficient permission
					}
					
				}
				
			}
			
		}
		
	}
	
}
