
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner in;
    private Scanner fileReader;

    private List<Recipe> recipes;
    private List<String> names;
    private List<String> cookingTime;
    private List<String> fileIngredients;

    public UserInterface(Scanner in, Scanner fileReader) {

        this.in = in;
        this.fileReader = fileReader;
        this.recipes = new ArrayList<>();
        this.names = new ArrayList<>();
        this.cookingTime = new ArrayList<>();
        this.fileIngredients = new ArrayList<>();
    }

    public void print() {
        List<String> a = addIngredients();
        for (String string : a) {
            System.out.println(string);
        }

    }

    public void printRecipe() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public void addRecipe() {

        for (int i = 0; i < names.size(); i++) {
            var temp = new ArrayList<String>();
            String name = names.get(i);
            int time = Integer.valueOf(cookingTime.get(i));
            Recipe r = new Recipe(name, time, temp);
            recipes.add(r);
        }

    }

    public List<String> addIngredients() {

        List<String> temp = recipes.get(0).getIngredients();
        List<String> temp2 = recipes.get(1).getIngredients();
        List<String> temp3 = recipes.get(2).getIngredients();

        for (int i = 0; i < fileIngredients.size(); i++) {
            if (i < 6) {
                temp.add(fileIngredients.get(i));
            }
            if (i >= 6 && i < 9) {
                temp2.add(fileIngredients.get(i));
            }
            if (i >= 9 && i < 16) {
                temp3.add(fileIngredients.get(i));
            }

        }

        return temp3;
    }

    public void start() {

        readFile();
        addRecipe();
        addIngredients();

        while (true) {
            System.out.println("Commands: ");
            System.out.println(
                    "list - lists the recipes\n" + "stop - stops the program" + "find name - searches recipes by name");

            System.out.println("Enter command:  ");

            String input = in.nextLine();
            if (input.equals("stop")) {

                break;
            }

            if (input.equals("list")) {

                printRecipe();
            }
            if (input.equals("find name")) {
                System.out.println("Searched word: ");
                String word = in.nextLine();
                findByName(word);
            }

        }

    }

    public void findByName(String word) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe);

            }
        }
    }

    public void readFile() {
        while (fileReader.hasNextLine()) {

            String line = fileReader.nextLine();

            if (line.isEmpty()) {

                continue;

            }

            String name = line;

            names.add(line);

            String time = fileReader.nextLine();
            cookingTime.add(time);

            while (fileReader.hasNextLine()) {

                String ingred = fileReader.nextLine();

                if (ingred.isEmpty()) {

                    break;

                }

                fileIngredients.add(ingred);

            }

        }
    }
}
