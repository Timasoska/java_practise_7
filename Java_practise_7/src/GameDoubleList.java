import java.util.LinkedList;

public class GameDoubleList {
    LinkedList<Integer> fp, sp;

    public GameDoubleList(int[] arr1, int[] arr2) {
        this.fp = new LinkedList<>();
        this.sp = new LinkedList<>();
        for (int i = 0; i < arr1.length; i++) {
            fp.add(arr1[i]);
            sp.add(arr2[i]);
        }
    }

    public String play() {
        int count = 0;
        while (!fp.isEmpty() && !sp.isEmpty() && count <= 106) {
            if (fp.peek() > sp.peek()) {
                fp.add(fp.remove()); //Убирает элемент и добавляет его в конец
                fp.add(sp.remove());
            } else {
                sp.add(sp.remove());
                sp.add(fp.remove());
            }
            count++;
        }

        if (count >= 106) {
            System.out.println("Botva");
        }

        if (fp.isEmpty()) return ("second " + count);
        else return ("first " + count);
    }

    public static void main(String[] args) {
        int[] arr1 = {45, 8, 1, 4, 7};
        int[] arr2 = {47, 548, 571, 14, 48};
        int[] arr3 = {1, 3, 5, 7, 9};
        int[] arr4 = {2, 4, 6, 8, 0};
        System.out.println(new GameQueue(arr1, arr2).play());
        System.out.println(new GameQueue(arr3, arr4).play());
    }
}
