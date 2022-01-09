import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String []args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String string = "K musi byc mniejsze lub rowne N";
        int option;
        System.out.print("Menu: \n 1.C Zadanie\n 5. Zadanie\n 0. Exit \n \n");
        do {
             option = sc.nextInt();
            switch(option) {
                case 1:

        //ZADANIE 1
                    //1.3
                    int liczenie = 0;
                    Scanner scanner1 = new Scanner(new File("In0101.txt"));
                    int n = scanner1.nextInt();
                    int k = scanner1.nextInt();
                    liczenie++;
                    if (k <= n) {
                        System.out.println(SN3(n, k) + "\nZlozonosc czasowa: " + liczenie);
                        FileWriter fileWriter1 = new FileWriter("Out0101.txt");
                        BufferedWriter bw1 = new BufferedWriter(fileWriter1);
                        bw1.write(String.valueOf(SN3(n, k)));
                        bw1.close();
                    } else {
                        throw new IllegalArgumentException(string);
                    }

                    //1.1
                    Scanner scanner13 = new Scanner(new File("In0103.txt"));
                    n = scanner13.nextInt();
                    k = scanner13.nextInt();
                    if (k <= n) {
                        System.out.println(SN32(n, k));
                        FileWriter fileWriter13 = new FileWriter("Out0103.txt");
                        BufferedWriter bw13 = new BufferedWriter(fileWriter13);
                        bw13.write(String.valueOf(SN3(n, k)));
                        bw13.close();
                    } else {
                        throw new IllegalArgumentException(string);
                    }
                    break;
                case 5:


        //ZADANIE 5

                    int licznik=0;
                    Scanner scanner = new Scanner(new File("In0105.txt"));
                    int N = scanner.nextInt();
                    int M = scanner.nextInt();
                    System.out.print(N + " ");
                    System.out.print(M + "\n");
                    int [][] tabpair = new int[M][4];
                    for(int i=0; i<M; i++) {
                        for(int j=0; j<4; j++) {
                            tabpair[i][j] = scanner.nextInt();
                            licznik++;
                        }
                    }
                    for(int i=0; i<M; i++) {
                        for(int j=0; j<4; j++) {
                           System.out.print(tabpair[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    int tabparm[] = new int[N];
                    for(int i=0; i<N; i++) {
                    tabparm[i] = i+1;
                    licznik++;
                    }
                    for(int i=0; i<N; i++) {
                        System.out.print(tabparm[i] + " ");
                    }
                    for(int i=0; i<N; i++) {
                        for(int d=0; d<M; d++) {
                            for(int j=0; j<4; j++) {
                                if(tabparm[i] == tabpair[d][j]) {
                                    tabparm[i] = 0;
                                    licznik++;
                            }
                        }
                        }
                    }
                    System.out.println();
                    System.out.println();
                    int iloscpasm = 0;
                    for(int i=0; i<N; i++) {
                        if(tabparm[i]>0)
                        {System.out.print(tabparm[i] + " ");
                            iloscpasm++;
                        }
                    }
                    FileWriter fileWriter = new FileWriter("Out0105.txt");
                    BufferedWriter bw = new BufferedWriter(fileWriter);
                    for (int i = 0; i < tabparm.length; i++) {
                        if(tabparm[i]>0)
                        bw.write(String.valueOf(tabparm[i]) + " ");
                        licznik++;
                    }
                    System.out.println("\nIlosc bezpiecznych pasm: " +iloscpasm+ "\nlicznik opreacji elementarnych: "+licznik);
                    bw.close();
            break;
                case 0:
                    System.out.println("end...");
                    break;
                default:
                    System.out.println("wrong option "+option);
                    break;
        }}
        while(option!=0);
        sc.close();
    }
//1.3
    public static int SN3(int n, int k)
    {

        if (k == 0 || k == n) {
            return 1;
        }
        else {

            return SN3(n - 1, k - 1) + SN3(n - 1, k);
        }

    }
//1.1
    public static int SN32(int n, int k) {
        int sum = 1;
        int licznik=0;
        for (int i = 2; i <= n; i++){
            licznik++;
            sum *= i;}
        for (int i = 2; i <= k; i++){
            licznik++;
            sum /= i;}
        for (int i = 2; i <= n - k; i++){
            licznik++;
            sum /= i;}
        System.out.println("Zlozonosc czasowa: "+ licznik);
        return sum;
    }
}
