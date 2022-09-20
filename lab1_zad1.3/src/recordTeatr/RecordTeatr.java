package recordTeatr;
import java.util.Scanner;
class Teatr{
    String nameT; // назва театру
    String surnameKeriv; //прізвище керівника
    String nameKeriv; //ім'я керівника
    String adress; //адреса театру
    double rating; 	// рейтинг закладу
}
public class RecordTeatr{
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in, "cp1251");

// Введення інформації про театри
        System.out.println("Введіть кількість театрів => ");
        int n=sc.nextInt();	//	кількість театрів
        Teatr theatre[]=new Teatr[n];
        System.out.println("Введіть інформацію про театри: ");
        for(int i = 0; i < theatre.length; i++) {
            sc.nextLine(); 	//	очищення буфера
            theatre[i] = new Teatr ();
            System.out.print("Назва "+(i+1)+"-го театру => ");
            theatre[i].nameT=sc.nextLine();
            System.out.print("Ім'я керівника "+(i+1)+"-го театру=> ");
            theatre[i].nameKeriv=sc.nextLine();
            System.out.print("Прізвище керівника "+(i+1)+"-го театру => ");
            theatre[i].surnameKeriv=sc.nextLine();
            System.out.print("Адреса "+(i+1)+"-го театру => ");
            theatre[i].adress=sc.nextLine();
            System.out.print("Рейтинг "+(i+1)+"-го театру => ");
            theatre[i].rating=sc.nextDouble();
        }
// Виведення отриманої інформації
        System.out.println("\nДані про театри:");
        for(int i = 0; i < theatre.length; i++) {
            System.out.println("" + theatre[i].nameT + ",\t" + theatre[i].surnameKeriv +"_"+theatre[i].nameKeriv
                    +",\t"+theatre[i].adress +",\t"+theatre[i].rating);
        }
// Театр з максимальним рейтингом
        int nommax=0;	//номер елемента для театра з максимальним рейтингом (початкове значення)
        double max=theatre[nommax].rating; //максимальна площа(початкове значення)
        for (int i = 0; i < theatre.length; i++)
            if (theatre[i].rating>max)
            {
                max = theatre[i].rating;
                nommax=i;
            }
        System.out.println("\nТеатр з максимальним рейтингом:");
        System.out.println("" + theatre[nommax].nameT + ",\t" + theatre[nommax].surnameKeriv +"_"+theatre[nommax].nameKeriv
                +",\t"+theatre[nommax].adress +",\t"+theatre[nommax].rating);

// Сортування театрів за назвою
        for (int i = 0; i < theatre.length-1; i++)
        {
            for (int j = 0; j < theatre.length-i; j++)
            {
                if (theatre[j].nameT.substring(0, 1).compareTo(theatre[i + 1].nameT.substring(0, 1)) < 0)
                {
                    Teatr rab = theatre[j];    //rab – робоча змінна для перестановки
                    theatre[j] = theatre[j + 1];
                    theatre[j + 1] = rab;
                }
            }
        }
        System.out.println("\nВідсортований список за назвою:");
        for (int i = 0; i < theatre.length; i++) {
            System.out.println(""+theatre[i].nameT);
        }
// Пошук за назвою
        sc.nextLine();			 // очищення буфера
        System.out.println("Введіть назву шуканого театру=> ");
        String name=sc.nextLine();
        int nom= -1;
        //-1 – театр з шуканою назвою відсутній

        for (int i = 0; i < theatre.length; i++)
            if (name.equalsIgnoreCase(theatre[i].nameT))
                nom=i;

        if (nom != -1)
        {
            System.out.println("Дані про театри, в котрих вищий рейтинг, ніж у введеного:");
            for (int i = 0; i<theatre.length;i++)
            {
                if (theatre[i].rating>theatre[nom].rating)
                {
                    System.out.println("" + theatre[i].nameT + ",\t" + theatre[i].surnameKeriv + "_"
                            + theatre[i].nameKeriv + ",\t" + theatre[i].adress + ",\t" + theatre[i].rating);
                }
            }
        }
        else
        {
            System.out.println("Театру з такою назвою немає");
        }

//пошук театру за керівником
        sc.nextLine();			 // очищення буфера
        System.out.println("Введіть прізвище керівника театру, який ви хочете знайти=> ");
        String surname=sc.nextLine();
        int nom1= -1;
        //-1 – театр з шуканим керівником відсутній
        for (int i = 0; i < theatre.length; i++)
            if (surname.equalsIgnoreCase(theatre[i].surnameKeriv))
            {
                nom1 = i;
                System.out.println("Дані про театр з цим керівником:");
                System.out.println("" + theatre[i].nameT + ",\t" + theatre[i].surnameKeriv + "_"
                        + theatre[i].nameKeriv + ",\t" + theatre[i].adress + ",\t" + theatre[i].rating);
            }
        else
        {
                System.out.println("Театр з таким керівником відсутній");
        }
        //виправлення введеного
        System.out.println("Якщо ви хочете редагувати дані про цей театр - введіть '1', якщо ні - будь що інше=> ");
        int sogl=sc.nextInt();
        if (sogl==1)
        {
            System.out.println("Виберіть, який пункт ви хочете змінити: \n"+"1 - Назва театру \n"
                    +"2 - Художнього керівника \n"+"3 - Адресу \n"+"4 - Рейтинг \n");
            int punkt=sc.nextInt();
            switch (punkt)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("Введіть нову назву театру: ");
                    theatre[nom1].nameT=sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Введіть прізвище нового художнього керівника: ");
                    theatre[nom1].surnameKeriv=sc.nextLine();
                    System.out.println("Введіть ім'я нового художнього керівника: ");
                    theatre[nom1].nameKeriv=sc.nextLine();
                    break;
                case 3:
                    System.out.println("Введіть нову адресу театру: ");
                    theatre[nom1].adress=sc.nextLine();
                    break;
                case 4:
                    System.out.println("Введіть новий рейтинг театру: ");
                    theatre[nom1].rating=sc.nextDouble();
                    break;
            }
            System.out.println("Нові дані:");
            System.out.println("" + theatre[nom1].nameT + ",\t" + theatre[nom1].surnameKeriv + "_"
                    + theatre[nom1].nameKeriv + ",\t" + theatre[nom1].adress + ",\t" + theatre[nom1].rating);
        }
    }
}