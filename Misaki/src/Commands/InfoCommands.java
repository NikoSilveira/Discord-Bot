package Commands;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class InfoCommands extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}  
		
		
		//COMMANDS
		
		if(args[0].equalsIgnoreCase(Main.prefix + "commands")) {			//Display embed with list of commands
			
			EmbedBuilder commands = new EmbedBuilder();
			commands.setTitle("What do you need? ⭐\n");
			
			//Info/help
			commands.addField("Info/help","**--commands**: display misaki's list of commands\n"
					+ "**--misaki:** display bot info\n",true);
			
			//Basic commands
			commands.addField("Basic commands","**--ara:** misaki sends a small greet to you\n"
					+ "**--f:** Misaki pays her respects in the chat\n"
					+ "**--invite:** generate invite link to server\n"
					+ "**--talk:** Send a message through misaki\n"
					+ "**--talk del:** Send a message through misaki and delete command\n"
					+ "**--ping:** display user's latency\n",true);
			
			//Rand output commands
			commands.addField("Random output commands","**--coin:** throw a coin for heads or tails\n"
					+ "**--dice:** throw a dice and get a number from 1 to 6\n",true);
			
			//Filter commands
			commands.addField("Chat filter commands","**--filter status:** check if the filter is enabled/disabled\n"
					+ "**--filter toggle:** enable/disable chat filter\\n",true);
			
			commands.setColor(0xe8c205);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(commands.build()).queue();
			
			commands.clear();
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "misaki")) {			//Bot bio embed
			//TODO - add more detail to bio
			EmbedBuilder misaki = new EmbedBuilder();
			misaki.setTitle("Misaki desu! ⭐");
			misaki.setDescription("Multipurpose waifu capable of sending messages, reacting to events, managing chat filters, streaming music and more!");
			misaki.setColor(0xe8c205);
			misaki.setFooter("Created by OutFasted",null);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(misaki.build()).queue();
			
			misaki.clear();
		}
		
	}
}
