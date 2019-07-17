package Outfasted.Misaki;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		//COMMANDS
		
		if(args[0].equalsIgnoreCase(Main.prefix + "commands")) {			//Display embed with list of commands
			
			EmbedBuilder commands = new EmbedBuilder();
			commands.setTitle("What do you need? ⭐");
			//commands.setDescription("");
			//commands.addField("Creator","Outfasted",false);
			commands.setColor(0xe8c205);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(commands.build()).queue();
			
			commands.clear();
			
		}
		else if(args[0].equalsIgnoreCase(Main.prefix + "misaki")) {			//Bot bio embed
			
			EmbedBuilder misaki = new EmbedBuilder();
			misaki.setTitle("Shokuhou Misaki desu! ⭐");
			misaki.setDescription("Description");
			misaki.addField("text","text",false);
			misaki.setColor(0xe8c205);
			misaki.setFooter("Created by OutFasted", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(misaki.build()).queue();
			
			misaki.clear();
			
		}
		else if(args[0].equalsIgnoreCase(Main.prefix + "AraAra")) {			//Ara Ara
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Ara Ara " + event.getAuthor().getName() + " ⭐").queue();
			
		}
		
		
		
	}
}
