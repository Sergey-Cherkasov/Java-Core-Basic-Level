import org.jetbrains.annotations.NotNull;

public class GuessFruitsVegetables implements WinnerLoose {

    private String[][] namesFruitVegetables = { {"apple", "яблоко"}, {"orange", "апельсин"}, {"lemon", "лимон"},
                                                {"banana", "банан"}, {"apricot", "абрикос"}, {"avocado", "авокадо"},
                                                {"broccoli", "брокколи"}, {"carrot", "морковь"}, {"cherry", "вишня"},
                                                {"garlic", "чеснок"}, {"grape", "виноград"}, {"melon", "дыня"},
                                                {"kiwi", "киви"}, {"mango", "манго"}, {"mushroom", "гриб"},
                                                {"nut", " орех"}, {"olive", "олива"}, {"pea", "горох"},
                                                {"peanut", "арахис"}, {"pear", "груша"}, {"pepper", "перец"},
                                                {"pineapple", "ананас"}, {"pumpkin", "тыква"}, {"potato"," картофель"}};

    private static final int MAX_WORD_LENGTH = 10;
    private int position;

    public void setPosition() {
        this.position = (int) (Math.random() * 24);
    }

    public String[] getHiddenWord() {
        return namesFruitVegetables[position];
    }

    @Override
    public void winner() {
        System.out.println("Поздравляю!\nВы знаете перевод слова.");
    }

    @Override
    public void loose(@NotNull String hiddenWord, @NotNull String userAnswer) {
        StringBuilder builder = new StringBuilder();
        for (int charPosition = 0; charPosition < hiddenWord.length() & charPosition < userAnswer.length(); charPosition++){
            if (userAnswer.charAt(charPosition) == hiddenWord.charAt(charPosition)){
                builder.append(hiddenWord.charAt(charPosition));
            } else {
                builder.append('#');
            }
        }
        int numberCharactersAdd = MAX_WORD_LENGTH - builder.length();
        System.out.print("Вы не смогли правильно написать название фрукта/овоща.\n" +
                "Посмотрите какие буквы совпали с буквами загаданного слова: ");
        System.out.println(String.format("%s%" + numberCharactersAdd + "s", builder, "").replace(' ', '#'));
    }

    @Override
    public void loose(int hiddenNumber, int userAnswer) {
    }
}
