import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by MRK on 2/12/2017.
 */
public class TestBot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "your-bot-token"; // enter your bot token here.
    }

    public String getBotUsername() {
        return "your-bot-username"; // enter your bot name here.
    } 

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId());
            String incomingMessage = update.getMessage().getText();
            int state = 0;
            if(incomingMessage.equals("hi"))
                state = 1;
            if(incomingMessage.equals("bye"))
                state = 2;

            switch (state){

                case 1:
                    message.setText("Hello");
                    break;
                case 2:
                    message.setText("GoodBye!");
                    break;
                default:
                    message.setText("Say Hello!!!");
            }

            try {
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
