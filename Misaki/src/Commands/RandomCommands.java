package Commands;

import java.util.Random;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RandomCommands extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}
		
		//RANDOMIZER
		Random rand = new Random();
		
		if(args[0].equalsIgnoreCase(Main.prefix + "coin")) {		//<random of 2>
			
			int number = rand.nextInt(2);
			
			EmbedBuilder coinEmbed = new EmbedBuilder();
			event.getChannel().sendTyping().queue();
			
			//coinEmbed.setImage(url)
			
			if(number == 0) {
				coinEmbed.setTitle("Heads!");
				//event.getChannel().sendMessage("Heads!").queue();
			}else if(number == 1) {
				coinEmbed.setTitle("Tails!");
				//event.getChannel().sendMessage("Tails!").queue();
			}
			
			event.getChannel().sendMessage(coinEmbed.build()).queue();
			coinEmbed.clear();
			
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "dice")) {		//<random of 6>
			
			int number = rand.nextInt(6);
			
			event.getChannel().sendTyping().queue();
			
			if(number == 0) {
				event.getChannel().sendMessage("1").queue();
			}else if(number == 1) {
				event.getChannel().sendMessage("2").queue();
			}else if(number == 2) {
				event.getChannel().sendMessage("3").queue();
			}else if(number == 3) {
				event.getChannel().sendMessage("4").queue();
			}else if(number == 4) {
				event.getChannel().sendMessage("5").queue();
			}else if(number == 5) {
				event.getChannel().sendMessage("6").queue();
			}
		}
	}
}
