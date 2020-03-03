public interface WinnerLoose {
    void winner();

    void loose(int hiddenNumber, int userAnswer);

    void loose(String hiddenWord, String userAnswer);
}
