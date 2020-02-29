import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGames {

    static InputStreamReader streamReader = new InputStreamReader(System.in);
    static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(streamReader);
        while (true){
            getMenu();
            int acceptItemMenu = Integer.parseInt(reader.readLine());
            switch (acceptItemMenu){
                case 1:
                    // Угадай число
                    guessNumber();
                    pressEnterKeyToContinue();
                    break;
                case 2:
                    // Переведи слово
                    guessFruitsVegetables();
                    pressEnterKeyToContinue();
                    break;
                case 0:
                    return;
            }
        }
    }

    static void getMenu(){
        System.out.println("Меню:");
        System.out.println( "1. Игра \"Угадай число\".\n" +
                "2. Игра \"Переведи слово\".\n" +
                "0. Выход");
        System.out.print("Выберите игру [1-2]: ");
    }

    static void guessNumber() throws IOException{
        System.out.println("У Вас будет 5 попыток отгадать загаданное число от 0 до 100");
        reader = new BufferedReader(streamReader);
        GuessNumber game = new GuessNumber();
        game.setHiddenNumber();
        int hiddenNumber = game.getHiddenNumber();
        int userAnswerInt;
        int iteratorRound = 1;
        while (iteratorRound <= 5){
            System.out.println("Попытка " + iteratorRound + ": ");
            System.out.println("Введите Ваше число: ");
            userAnswerInt = Integer.parseInt(reader.readLine());
            if (userAnswerInt == hiddenNumber) {
                game.winner();
                break;
            } else game.loose(hiddenNumber, userAnswerInt);
            iteratorRound++;
        }
        System.out.println("Игра закончена.");
    }

    static void guessFruitsVegetables() throws IOException {
//        streamReader.mark(0);
//        streamReader.reset();
        reader = new BufferedReader(streamReader);
        GuessFruitsVegetables guessFruitsVegetables = new GuessFruitsVegetables();
        guessFruitsVegetables.setPosition();
        String[] wordsPair = guessFruitsVegetables.getHiddenWord();
        String hiddenWord = wordsPair[0];
        String promptWord = wordsPair[1];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Предлагаю Вам написать название фрукта/овоща на английском языке: " + promptWord);
        String userAnswerString = reader.readLine();

        if (userAnswerString.equals(hiddenWord)) {
            guessFruitsVegetables.winner();
        } else {
            guessFruitsVegetables.loose(hiddenWord, userAnswerString);
        }
        System.out.println("Игра закончена.");
    }

   static void pressEnterKeyToContinue()
    {
        System.out.println("Для продолжения нажмите Enter...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}
