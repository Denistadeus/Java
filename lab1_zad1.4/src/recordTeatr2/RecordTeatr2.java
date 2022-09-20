package recordTeatr2;
import java.util.Scanner;

class Teatr{
    String nameT; // назва театру
    String surnameKeriv; //прізвище керівника
    String nameKeriv; //ім'я керівника
    String adress; //адреса театру
    double rating; 	// рейтинг закладу
}

public class RecordTeatr2{
// МЕТОДИ ДЛЯ ВСІХ ПІДЗАДАЧ для роботи з об'єктами класу Teatr

    public static Teatr [] setTheatreArr(int k) {
// Введення масиву театрів
        Scanner sc=new Scanner(System.in,"cp1251");
        Teatr theatre[]=new Teatr[k];

        System.out.println("Введіть інформацію про театри: ");
        for (int i = 0; i < theatre.length; i++)
        {
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
            sc.nextLine();   // очищення буфера
        }
        return theatre;
    }
    public static void showArray (Teatr [] ttr) {
// Виведення масиву
        for (int i = 0; i < ttr.length; i++)
        {
            System.out.println("" + ttr[i].nameT + ",\t" + ttr[i].surnameKeriv +"_"+ttr[i].nameKeriv
                    +",\t"+ttr[i].adress +",\t"+ttr[i].rating);
        }
    }
    public static void showTeatr (Teatr ttr) {
// Інформація про один театр
        System.out.println("" + ttr.nameT + ",\t" + ttr.surnameKeriv +"_"+ttr.nameKeriv
                +",\t"+ttr.adress +",\t"+ttr.rating);
    }
    public static int NomMax	(Teatr []t) {
// Номер театра з макс. рейтингом
        int nommax=0;	// номер елемента для театра з максимальним рейтингом
// (початкове значення)
        double max=t[nommax].rating;	//макс. рейтинг (початкове значення)
        for (int i = 0; i <t.length; i++)
            if (t[i].rating>max) {
                max = t [i].rating;
                nommax=i;
            }
        return nommax;
    }
    public static Teatr[] sortName	(Teatr [] ttr) {
// Сортування театрів за назвою
        for (int i = 0; i < ttr.length-1; i++)
        {
            for (int j = 0; j < ttr.length-i; j++)
            {
                if (ttr[j].nameT.substring(0, 1).compareTo(ttr[i + 1].nameT.substring(0, 1)) < 0)
                {
                    Teatr rab = ttr[j];    //rab – робоча змінна для перестановки
                    ttr[j] = ttr[j + 1];
                    ttr[j + 1] = rab;
                }
            }
        }
        return ttr;
    }
    public static Teatr [] Bigger(Teatr ttr[],String name) {
// Пошук за назвою
        int n=-1;	//-1 – театр з шуканою назвою відсутній
        for (int i = 0; i < ttr.length; i++)
        {
            if (name.equalsIgnoreCase(ttr[i].nameT))
            {
                n = i;
            }
        }
        if (n != -1)
        {
            int kol=0;	//кількість країн
            for (int i = 0; i < ttr.length; i++) {
                if (ttr[i].rating>ttr[n].rating)
                    ++kol;
            }

            if (kol != 0) {
                Teatr [] bigTheatre = new Teatr[kol];
                int x=-1;
                for (int i = 0; i <ttr.length; i++)
                    if (ttr[i].rating>ttr[n].rating) {
                        bigTheatre[++x]=ttr[i];
                    }
                return bigTheatre;
            } else return null;
        }
        else return null;
    }
    public static Teatr findForKeriv(Teatr ttr [], String name) {
// Пошук за назвою
        int n=-1;	//-1 – країна з шуканою назвою відсутня
        for (int i = 0; i < ttr.length; i++)
        {
            if (name.equalsIgnoreCase(ttr[i].surnameKeriv))
            {
                n = i;
            }
        }
        if (n != -1)
        {
            return ttr[n];
        }
        else return null;
    }
    public static void Redag(Teatr ttr, int punkt){
        Scanner sc=new Scanner(System.in,"cp1251");
        switch (punkt)
        {
            case 1:
                sc.nextLine();
                System.out.println("Введіть нову назву театру: ");
                ttr.nameT=sc.nextLine();
                break;
            case 2:
                sc.nextLine();
                System.out.println("Введіть прізвище нового художнього керівника: ");
                ttr.surnameKeriv=sc.nextLine();
                System.out.println("Введіть ім'я нового художнього керівника: ");
                ttr.nameKeriv=sc.nextLine();
                break;
            case 3:
                System.out.println("Введіть нову адресу театру: ");
                ttr.adress=sc.nextLine();
                break;
            case 4:
                System.out.println("Введіть новий рейтинг театру: ");
                ttr.rating=sc.nextDouble();
                break;
        }
        System.out.println("Нові дані:");
        showTeatr(ttr);
    }
    public static void main(String[] args) {
// ГОЛОВНИЙ КЛАС З МЕТОДАМИ
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введіть кількість театрів => ");
        int n=sc.nextInt();	// кількість країн
        Teatr theatre[]= setTheatreArr(n);	// Введення інформації про країни

        System.out.println("\nДані про тетри:");
        showArray(theatre);			// Виведення отриманої інформації

// Театр з максимальним рейтингом
        sc.nextLine();
        int nommax=NomMax(theatre);
        System.out.println("\nТеатр з максимальним рейтингом:");
        showTeatr (theatre [nommax]);

// Сортування театрів за назвою
        sc.nextLine();
        theatre = sortName(theatre);
        System.out.println("\nВідсортований список за назвою:");
        showArray(theatre);

// Рейтинг більше шуканого
        sc.nextLine();
        System.out.println("Введіть назву театру, який ви хочете знайти=> ");
        String nazv=sc.nextLine();
        System.out.println("\nТеатри, з рейтингом більше шуканого:");
        Teatr [] larger = Bigger (theatre,nazv);
        showArray(larger);

// Пошук країни
        sc.nextLine();
        System.out.println("Введіть прізвище керівника театру, який ви хочете знайти=> ");
        String surname=sc.nextLine();
        Teatr sfind = findForKeriv(theatre, surname);
        if (sfind != null)
        {
            System.out.println("Дані про театр з цим керівником:");
            showTeatr(sfind);
            System.out.println("Якщо ви хочете редагувати дані про цей театр - введіть '1', якщо ні - будь що інше=> ");
            int sogl=sc.nextInt();
            if (sogl==1)
            {
                System.out.println("Виберіть, який пункт ви хочете змінити: \n"+"1 - Назва театру \n"
                        +"2 - Художнього керівника \n"+"3 - Адресу \n"+"4 - Рейтинг \n");
                int punkt=sc.nextInt();
                Redag(sfind,punkt);
            }
        }
        else
        {
            System.out.println("Такого театру немає у списку!");
        }
    }
}