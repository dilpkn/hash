import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    static int m = 0;
    static int c = 0;
    static int n = 0;
    static ArrayList <Integer> arr;

    public static void main(String[] args) throws IOException {
        File input = new File("input.txt");
        Scanner in = new Scanner(input);
        m = in.nextInt();
        c = in.nextInt();
        n = in.nextInt();
        arr = new ArrayList<>(m);
        for(int i = 0;i < m; i++){
            arr.add(-1);
        }
        ArrayList<Integer> temp = new ArrayList<>(n);
        for(int i =0;i<n; i++){
            temp.add(in.nextInt());
        }
        temp = new ArrayList<>(new LinkedHashSet<>(temp));
        for(int i = 0; i < temp.size(); i++){
            int x1 = temp.get(i);
            h(x1);
        }
        FileWriter writer = new FileWriter("output.txt");
        for(int i =0; i<m;i++)
            writer.write(String.valueOf(arr.get(i) + "\n"));
        writer.close();
    }
    public static void h(int x){
        upperFor:
        for(int i = 0;i < m; i++){
            int k = ((x % m)+ c*i)%m;
            if(arr.get(k)==(-1)){
                arr.set(k,x);
                break upperFor;
            }
        }

    }
}
