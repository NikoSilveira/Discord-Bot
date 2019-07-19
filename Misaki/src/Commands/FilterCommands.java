package Commands;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class FilterCommands extends ListenerAdapter{
	
	public static boolean filterEnabled = false;

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
		
		
		//COMMANDS
		if(args[0].equalsIgnoreCase(Main.prefix + "filter")) {	//chat filter
			
			if(args.length == 1) {		//validate input
				
				event.getChannel().sendMessage("To use the filter command correctly, type: **--filter status** or **--filter toggle**").queue();
				
			}
			else {
				
				if(args[1].equalsIgnoreCase("status")) {		//Check filter status
					
					if(filterEnabled == true) {
						event.getChannel().sendMessage("The chat filter is enabled.").queue();
					}
					else if(filterEnabled == false) {
						event.getChannel().sendMessage("The chat filter is disabled.").queue();
					}
					
				}
				else if(args[1].equalsIgnoreCase("toggle")) {	//Enable/disable filter
					
					if(filterEnabled == false) {
						filterEnabled = true;
						event.getChannel().sendMessage("The filter has been enabled ✔️").queue();
					}
					else if(filterEnabled == true) {
						filterEnabled = false;
						event.getChannel().sendMessage("The filter has been disabled ❌").queue();
					}
					
				}
				
			}
			
			
		}
			
	}
}
