package recordTeatr;
import java.util.Scanner;
class Teatr{
    String nameT; // ����� ������
    String surnameKeriv; //������� ��������
    String nameKeriv; //��'� ��������
    String adress; //������ ������
    double rating; 	// ������� �������
}
public class RecordTeatr{
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in, "cp1251");

// �������� ���������� ��� ������
        System.out.println("������ ������� ������ => ");
        int n=sc.nextInt();	//	������� ������
        Teatr theatre[]=new Teatr[n];
        System.out.println("������ ���������� ��� ������: ");
        for(int i = 0; i < theatre.length; i++) {
            sc.nextLine(); 	//	�������� ������
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
        }
// ��������� �������� ����������
        System.out.println("\n��� ��� ������:");
        for(int i = 0; i < theatre.length; i++) {
            System.out.println("" + theatre[i].nameT + ",\t" + theatre[i].surnameKeriv +"_"+theatre[i].nameKeriv
                    +",\t"+theatre[i].adress +",\t"+theatre[i].rating);
        }
// ����� � ������������ ���������
        int nommax=0;	//����� �������� ��� ������ � ������������ ��������� (��������� ��������)
        double max=theatre[nommax].rating; //����������� �����(��������� ��������)
        for (int i = 0; i < theatre.length; i++)
            if (theatre[i].rating>max)
            {
                max = theatre[i].rating;
                nommax=i;
            }
        System.out.println("\n����� � ������������ ���������:");
        System.out.println("" + theatre[nommax].nameT + ",\t" + theatre[nommax].surnameKeriv +"_"+theatre[nommax].nameKeriv
                +",\t"+theatre[nommax].adress +",\t"+theatre[nommax].rating);

// ���������� ������ �� ������
        for (int i = 0; i < theatre.length-1; i++)
        {
            for (int j = 0; j < theatre.length-i; j++)
            {
                if (theatre[j].nameT.substring(0, 1).compareTo(theatre[i + 1].nameT.substring(0, 1)) < 0)
                {
                    Teatr rab = theatre[j];    //rab � ������ ����� ��� ������������
                    theatre[j] = theatre[j + 1];
                    theatre[j + 1] = rab;
                }
            }
        }
        System.out.println("\n³����������� ������ �� ������:");
        for (int i = 0; i < theatre.length; i++) {
            System.out.println(""+theatre[i].nameT);
        }
// ����� �� ������
        sc.nextLine();			 // �������� ������
        System.out.println("������ ����� �������� ������=> ");
        String name=sc.nextLine();
        int nom= -1;
        //-1 � ����� � ������� ������ �������

        for (int i = 0; i < theatre.length; i++)
            if (name.equalsIgnoreCase(theatre[i].nameT))
                nom=i;

        if (nom != -1)
        {
            System.out.println("��� ��� ������, � ������ ����� �������, �� � ���������:");
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
            System.out.println("������ � ����� ������ ����");
        }

//����� ������ �� ���������
        sc.nextLine();			 // �������� ������
        System.out.println("������ ������� �������� ������, ���� �� ������ ������=> ");
        String surname=sc.nextLine();
        int nom1= -1;
        //-1 � ����� � ������� ��������� �������
        for (int i = 0; i < theatre.length; i++)
            if (surname.equalsIgnoreCase(theatre[i].surnameKeriv))
            {
                nom1 = i;
                System.out.println("��� ��� ����� � ��� ���������:");
                System.out.println("" + theatre[i].nameT + ",\t" + theatre[i].surnameKeriv + "_"
                        + theatre[i].nameKeriv + ",\t" + theatre[i].adress + ",\t" + theatre[i].rating);
            }
        else
        {
                System.out.println("����� � ����� ��������� �������");
        }
        //����������� ���������
        System.out.println("���� �� ������ ���������� ��� ��� ��� ����� - ������ '1', ���� � - ���� �� ����=> ");
        int sogl=sc.nextInt();
        if (sogl==1)
        {
            System.out.println("�������, ���� ����� �� ������ ������: \n"+"1 - ����� ������ \n"
                    +"2 - ���������� �������� \n"+"3 - ������ \n"+"4 - ������� \n");
            int punkt=sc.nextInt();
            switch (punkt)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("������ ���� ����� ������: ");
                    theatre[nom1].nameT=sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("������ ������� ������ ���������� ��������: ");
                    theatre[nom1].surnameKeriv=sc.nextLine();
                    System.out.println("������ ��'� ������ ���������� ��������: ");
                    theatre[nom1].nameKeriv=sc.nextLine();
                    break;
                case 3:
                    System.out.println("������ ���� ������ ������: ");
                    theatre[nom1].adress=sc.nextLine();
                    break;
                case 4:
                    System.out.println("������ ����� ������� ������: ");
                    theatre[nom1].rating=sc.nextDouble();
                    break;
            }
            System.out.println("��� ���:");
            System.out.println("" + theatre[nom1].nameT + ",\t" + theatre[nom1].surnameKeriv + "_"
                    + theatre[nom1].nameKeriv + ",\t" + theatre[nom1].adress + ",\t" + theatre[nom1].rating);
        }
    }
}