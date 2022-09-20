package recordTeatr2;
import java.util.Scanner;

class Teatr{
    String nameT; // ����� ������
    String surnameKeriv; //������� ��������
    String nameKeriv; //��'� ��������
    String adress; //������ ������
    double rating; 	// ������� �������
}

public class RecordTeatr2{
// ������ ��� �Ѳ� ϲ������ ��� ������ � ��'������ ����� Teatr

    public static Teatr [] setTheatreArr(int k) {
// �������� ������ ������
        Scanner sc=new Scanner(System.in,"cp1251");
        Teatr theatre[]=new Teatr[k];

        System.out.println("������ ���������� ��� ������: ");
        for (int i = 0; i < theatre.length; i++)
        {
            theatre[i] = new Teatr ();
            System.out.print("����� "+(i+1)+"-�� ������ => ");
            theatre[i].nameT=sc.nextLine();
            System.out.print("��'� �������� "+(i+1)+"-�� ������=> ");
            theatre[i].nameKeriv=sc.nextLine();
            System.out.print("������� �������� "+(i+1)+"-�� ������ => ");
            theatre[i].surnameKeriv=sc.nextLine();
            System.out.print("������ "+(i+1)+"-�� ������ => ");
            theatre[i].adress=sc.nextLine();
            System.out.print("������� "+(i+1)+"-�� ������ => ");
            theatre[i].rating=sc.nextDouble();
            sc.nextLine();   // �������� ������
        }
        return theatre;
    }
    public static void showArray (Teatr [] ttr) {
// ��������� ������
        for (int i = 0; i < ttr.length; i++)
        {
            System.out.println("" + ttr[i].nameT + ",\t" + ttr[i].surnameKeriv +"_"+ttr[i].nameKeriv
                    +",\t"+ttr[i].adress +",\t"+ttr[i].rating);
        }
    }
    public static void showTeatr (Teatr ttr) {
// ���������� ��� ���� �����
        System.out.println("" + ttr.nameT + ",\t" + ttr.surnameKeriv +"_"+ttr.nameKeriv
                +",\t"+ttr.adress +",\t"+ttr.rating);
    }
    public static int NomMax	(Teatr []t) {
// ����� ������ � ����. ���������
        int nommax=0;	// ����� �������� ��� ������ � ������������ ���������
// (��������� ��������)
        double max=t[nommax].rating;	//����. ������� (��������� ��������)
        for (int i = 0; i <t.length; i++)
            if (t[i].rating>max) {
                max = t [i].rating;
                nommax=i;
            }
        return nommax;
    }
    public static Teatr[] sortName	(Teatr [] ttr) {
// ���������� ������ �� ������
        for (int i = 0; i < ttr.length-1; i++)
        {
            for (int j = 0; j < ttr.length-i; j++)
            {
                if (ttr[j].nameT.substring(0, 1).compareTo(ttr[i + 1].nameT.substring(0, 1)) < 0)
                {
                    Teatr rab = ttr[j];    //rab � ������ ����� ��� ������������
                    ttr[j] = ttr[j + 1];
                    ttr[j + 1] = rab;
                }
            }
        }
        return ttr;
    }
    public static Teatr [] Bigger(Teatr ttr[],String name) {
// ����� �� ������
        int n=-1;	//-1 � ����� � ������� ������ �������
        for (int i = 0; i < ttr.length; i++)
        {
            if (name.equalsIgnoreCase(ttr[i].nameT))
            {
                n = i;
            }
        }
        if (n != -1)
        {
            int kol=0;	//������� ����
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
// ����� �� ������
        int n=-1;	//-1 � ����� � ������� ������ �������
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
                System.out.println("������ ���� ����� ������: ");
                ttr.nameT=sc.nextLine();
                break;
            case 2:
                sc.nextLine();
                System.out.println("������ ������� ������ ���������� ��������: ");
                ttr.surnameKeriv=sc.nextLine();
                System.out.println("������ ��'� ������ ���������� ��������: ");
                ttr.nameKeriv=sc.nextLine();
                break;
            case 3:
                System.out.println("������ ���� ������ ������: ");
                ttr.adress=sc.nextLine();
                break;
            case 4:
                System.out.println("������ ����� ������� ������: ");
                ttr.rating=sc.nextDouble();
                break;
        }
        System.out.println("��� ���:");
        showTeatr(ttr);
    }
    public static void main(String[] args) {
// �������� ���� � ��������
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("������ ������� ������ => ");
        int n=sc.nextInt();	// ������� ����
        Teatr theatre[]= setTheatreArr(n);	// �������� ���������� ��� �����

        System.out.println("\n��� ��� �����:");
        showArray(theatre);			// ��������� �������� ����������

// ����� � ������������ ���������
        sc.nextLine();
        int nommax=NomMax(theatre);
        System.out.println("\n����� � ������������ ���������:");
        showTeatr (theatre [nommax]);

// ���������� ������ �� ������
        sc.nextLine();
        theatre = sortName(theatre);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(theatre);

// ������� ����� ��������
        sc.nextLine();
        System.out.println("������ ����� ������, ���� �� ������ ������=> ");
        String nazv=sc.nextLine();
        System.out.println("\n������, � ��������� ����� ��������:");
        Teatr [] larger = Bigger (theatre,nazv);
        showArray(larger);

// ����� �����
        sc.nextLine();
        System.out.println("������ ������� �������� ������, ���� �� ������ ������=> ");
        String surname=sc.nextLine();
        Teatr sfind = findForKeriv(theatre, surname);
        if (sfind != null)
        {
            System.out.println("��� ��� ����� � ��� ���������:");
            showTeatr(sfind);
            System.out.println("���� �� ������ ���������� ��� ��� ��� ����� - ������ '1', ���� � - ���� �� ����=> ");
            int sogl=sc.nextInt();
            if (sogl==1)
            {
                System.out.println("�������, ���� ����� �� ������ ������: \n"+"1 - ����� ������ \n"
                        +"2 - ���������� �������� \n"+"3 - ������ \n"+"4 - ������� \n");
                int punkt=sc.nextInt();
                Redag(sfind,punkt);
            }
        }
        else
        {
            System.out.println("������ ������ ���� � ������!");
        }
    }
}