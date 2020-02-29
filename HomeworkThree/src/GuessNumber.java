import java.util.Random;

public class GuessNumber implements WinnerLoose{

    private int hiddenNumber;

    public int getHiddenNumber() {
        return hiddenNumber;
    }

    public void setHiddenNumber() {
        Random random = new Random();
        this.hiddenNumber = (int) (Math.random() * 101);
    }

    @Override
    public void winner() {
        System.out.println("Поздравляю!\nВы угадали число.");
    }

    @Override
    public void loose(int hiddenNumber, int userAnswer) {
        if (userAnswer < hiddenNumber) {
            System.out.println("Вы ввели число меньше загаданного.");
        } else {
            System.out.println("Вы ввели число больше загаданного.");
        }
    }

    @Override
    public void loose(String hiddenWord, String userAnswer) {
    }
}
