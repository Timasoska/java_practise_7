import java.util.ArrayDeque;
import java.util.Stack;

public class GameStack {
    public static void pushBack(Stack <Integer> s, int item){
        Stack<Integer> ns = new Stack<>();
        while(!s.isEmpty())// Перекладываем элементы из одного стака в временный, чтобы положить новый элемент на дно
            ns.push(s.pop());
        s.push(item);
        while(!ns.isEmpty())
            s.push(ns.pop());
    }
    public static void Game(int[] arr1, int[] arr2) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        int count = 0;

        for(int i =0; i < arr1.length; i++){
            first.push(arr1[i]);
            second.push(arr2[i]);
        }

        while(!first.isEmpty() && !second.isEmpty() && count <= 106){
            if(first.peek() > second.peek() && second.peek() != 0){ //Сравниваем элементы
                pushBack(first, first.pop());
                pushBack(first, second.pop());}
            else{
                pushBack(second, first.pop());
                pushBack(second, second.pop());
            }
            count++;
        }

        if(count >= 106){
            System.out.println("Botva");
        }

        if(first.isEmpty()) System.out.println("second " + count);
        else System.out.println("first " + count);
    }

    public static void main(String[] args) {
        int[] arr1 = {45,8,1,4,7};
        int[] arr2 = {47,548,571,14,48};
        int[] arr3 = {1,3,5,7,9};
        int[] arr4 = {2,4,6,8,0};
        Game(arr1,arr2);
        System.out.println("/////////////");
        Game(arr3,arr4);
    }
}


