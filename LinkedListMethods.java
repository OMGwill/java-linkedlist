//Author: Will Luttmann
import java.util.*;
import java.io.*;

public class LinkedListMethods
{
    public static void main() throws FileNotFoundException {
        //creates 3 lists, one for each file
        LinkedList<String> list1 = readItems("input1.txt");
        LinkedList<String> list2 = readItems("input2.txt");
        LinkedList<String> list3 = readItems("input3.txt");
        
        //prints original list, then removes first middle and last
        //then prints new list with items removed for input 1
        System.out.println("Linked List Items (input1.txt)");
        printListWithSeparator(list1);
        removeFirstMiddleLast(list1);
        printListWithSeparator(list1);
        
        //prints original list, then removes first middle and last
        //then prints new list with items removed for input 2
        System.out.println("Linked List Items (input2.txt)");
        printListWithSeparator(list2);
        removeFirstMiddleLast(list2);
        printListWithSeparator(list2);
        
        //prints original list, then removes first middle and last
        //then prints new list with items removed for input 3
        System.out.println("Linked List Items (input3.txt)");
        printListWithSeparator(list3);
        removeFirstMiddleLast(list3);
        printListWithSeparator(list3);
    }
    
    public static LinkedList<String> readItems(String fileName)throws FileNotFoundException{
        //create a scanner to read input from a file, and a list to store the information
        Scanner in = new Scanner(new File(fileName));
        LinkedList<String> list = new LinkedList<String>();
        
        //while the input has a next line
        while (in.hasNextLine()){
            if (in.hasNext()){  //if the input has a next word, add to list
                list.add(in.next());
            } else {            //if not, go to next line
                in.nextLine();
            }
        }
        
        //returns the list
        return list;
    }
    
    public static void removeFirstMiddleLast(LinkedList<String> l){
        //create an interator to keep track of list position
        ListIterator<String> iterator = l.listIterator();
        
        if (l.size() % 2 == 0){             //if list is even, middle is size - 1 / 2
            int middle = (l.size() - 1) / 2;
            for(int i = 0; i <= middle; i++){ //move iterator to the middle
                iterator.next();
            }
            iterator.remove();              //remove middle element
        } else {                            //if list is odd, middle is size / 2
            int middle = l.size() / 2;
            for(int i = 0; i <= middle; i++){ //move iterator to the middle
                iterator.next();
            }
            iterator.remove();              //remove middle element
        }
        
        while(iterator.hasNext()){          //move iterator to the end
            iterator.next();
        }
        iterator.remove();                  //remove the end element
        
        while(iterator.hasPrevious()){      //move iterator to the beginning
            iterator.previous();
        }
        iterator.remove();                  //remove first element
    }
    
    public static void printListWithSeparator(LinkedList<String> l){
        //create an iterator to keep trsck of list position
        ListIterator<String> iterator = l.listIterator();
        
        while (iterator.hasNext()){     //while there is a next element, print it
            System.out.print(iterator.next());
            if(iterator.hasNext()){     //if there is still another element, print '->' 
                System.out.print(" -> "); //between elements
            }
        }
        
        //print spaces for clarity 
        System.out.println();
        System.out.println();
    }
}
