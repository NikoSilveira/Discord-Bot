# Discord-Bot-Misaki
Discord Bot developed using the JDA API
https://github.com/DV8FromTheWorld/JDA

Audio streaming supported by LavaPlayer using Maven
https://github.com/sedmelluq/lavaplayer

SETUP

1. Create a Java project and add the JDA libraries. Setup guide: https://github.com/DV8FromTheWorld/JDA/wiki/2)-Setup

2. Configure the project as a Maven project and make sure the POM file references the required repositories and dependencies (required for the audio player).

  <repositories>
    <repository>
      <id>central</id>
      <name>bintray</name>
      <url>http://jcenter.bintray.com</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>com.sedmelluq</groupId>
      <artifactId>lavaplayer</artifactId>
      <version>1.3.19</version>
    </dependency>
  </dependencies>

3. Create a config.secrets file and add it to the root of the project. Use it with the scanner to connect to your bot with a token.

		//Scanner
		File file = new File("your-path");
		Scanner sc = new Scanner(file);
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(sc.nextLine()).build();
		} finally {
			sc.close();
		}
