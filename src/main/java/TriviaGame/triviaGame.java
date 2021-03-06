package TriviaGame;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Objects;
import java.util.Random;

public class triviaGame extends ListenerAdapter {

    // boolean to test for the loop to start or end the game
    boolean triviaStart = false;


    // on message received used
    public void onMessageReceived(MessageReceivedEvent event){

        // message var
        String msg = event.getMessage().getContentRaw();

        // Use array for multiple words
        String[] triviaStartString = event.getMessage().getContentRaw().split(" ");

        // Get user name
        String name = Objects.requireNonNull(event.getMember()).getUser().getName();

        String member = event.getMember().getAsMention();

        // Message in chat to start the game. The first word has to be 'trivia'
        if(triviaStartString[0].equalsIgnoreCase("trivia")) {
            if (triviaStartString[1].equalsIgnoreCase("start")) {

                // Bot sends message in channel that game has started
                event.getChannel().sendMessage(member + " started the trivia game!").queue();

                // set to true to start the question loop
                triviaStart = true;

                String[] questions = {
                        "this is the first question1",
                        "this is the second question",
                        "this is the third question",
                        "this is the 4 question",
                        "this is the 5 question"};

                int i = 0;
                Random rand = new Random();

                int rand_int1 = rand.nextInt(questions.length);
                // send out random question from the questions array.
                // TODO get it to send only one message and wait for answer.
                // this does not work the way I want it to. Need to research eventwaiter.
                do {
                    String answers = String.valueOf(event.getChannel().sendMessage(questions[rand_int1]).complete());

                    if (answers.equals(questions[0])) {
                        if(msg.equalsIgnoreCase("1")){
                            event.getChannel().sendMessage(member + " You got it right!").queue();
                            triviaStart = false;
                        }


                    }
                    if (answers.equals(questions[1])) {
                        if(msg.equalsIgnoreCase("1")){
                            event.getChannel().sendMessage(member + " You got it right!").queue();
                            triviaStart = false;
                        }

                    }
                    if (answers.equals(questions[2])) {
                        if(msg.equalsIgnoreCase("1")){
                            event.getChannel().sendMessage(member + " You got it right!").queue();
                            triviaStart = false;
                        }

                    }
                    if (answers.equals(questions[3])) {
                        if(msg.equalsIgnoreCase("1")){
                            event.getChannel().sendMessage(member + " You got it right!").queue();
                            triviaStart = false;
                        }

                    }
                    if (answers.equals(questions[4])) {
                        if(msg.equalsIgnoreCase("1")){
                            event.getChannel().sendMessage(member + " You got it right!").queue();
                            triviaStart = false;
                        }

                    }


                }while(triviaStart);
            }
        }



        // Message in chat to start the game. The first word has to be 'trivia'
        if(triviaStartString[0].equalsIgnoreCase("trivia")) {
            if (triviaStartString[1].equalsIgnoreCase("stop")) {
                event.getChannel().sendMessage(member + " stopped the trivia game!").queue();

                //setting to false to exit question loop
                triviaStart = false;
            }
        }
        System.out.println(triviaStart);







    }

}