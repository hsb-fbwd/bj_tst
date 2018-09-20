

public class Start
{
   

    public Start()
    {
        WertePaar p1= new WertePaar();
        p1.setzeWertA(8);
        p1.setzeWertB(6);
        WertePaar p2= new WertePaar(3,4);
        p1.zeigeWerteInfo();
        p2.zeigeWerteInfo();
        WertePaar p3=new WertePaar(p1.getAplusB(),p2.getAminusB());
        p3.zeigeWerteInfo();
    }

    
    public static void main(String args[])
    {
        Start s1 = new Start();
    }
}
