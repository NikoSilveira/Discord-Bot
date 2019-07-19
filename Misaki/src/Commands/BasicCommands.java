package Commands;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BasicCommands extends ListenerAdapter{
	
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
			
			event.getChannel().sendMessage("" + String.join(" ",args)).queue();
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "ping")) {		//Show latency
			
			event.getChannel().sendTyping().queue();
			long ping = event.getJDA().getPing();
			
			EmbedBuilder pingEmbed = new EmbedBuilder();
			pingEmbed.setTitle(event.getAuthor().getName() + ", your ping is: ");
			pingEmbed.setDescription(""+ping+" ms");
			
			if(ping <= 90) {
				pingEmbed.setColor(0x05ab08);	//Good lat - green
			}
			else if(ping > 90 && ping <= 160) {
				pingEmbed.setColor(0xe8c205);	//regular lat - yellow
			}
			else if(ping > 160) {
				pingEmbed.setColor(0xfa0505);	//bad lat - red
			}
			
			event.getChannel().sendMessage(pingEmbed.build()).queue();
			pingEmbed.clear();
			
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "invite")) {		//invite create
			
			if(args.length == 1) {
				//Correct user if command improperly typed
				event.getChannel().sendMessage("To use the invite command correctly, type: **--invite create**").queue();
			}
			
			else if(args[1].equalsIgnoreCase("create")){
				//Generate invite link
				event.getChannel().sendMessage("Ara " + event.getAuthor().getName() + ", want to invite someone? ✨").queue();
				event.getChannel().sendMessage("" + event.getChannel().createInvite().complete().getURL()).queue();
			}
			
		}
		

		
		
	}
}
