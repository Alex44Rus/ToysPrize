package ToysPrize;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] ids = {1, 2, 3, 4, 5};
        String[] names = {"toy1", "toy2", "Iphone14ProMax", "GLE 5.5 AMG", "newLife"};
        double[] frequencies = {0.5, 0.3, 0.15, 0.04, 0.01};


        PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) ->
                Double.compare(t2.getFrequency(), t1.getFrequency()));
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }

        List<Toy> resultList = new ArrayList<>();
        for (
                int i = 0;
                i < 5; i++) { //5 итераций розыгрыша
            Toy currentToy = toysQueue.poll();
            resultList.add(currentToy);

        }

        String fileName = "ToysPrize/result.txt";
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Toy toy : resultList) {
                writer.write(String.format("Id: %d, Название: %s, Частота выпадения: %.2f,\r\n",
                        toy.getId(),
                        toy.getName(),
                        toy.getFrequency()));

            }
        } catch (
                IOException e) {
            System.err.format("IOException: %%n", e);
        }


    }
}
