
/**
 * Beschreibung der Klasse WertePaar.
 */
public class WertePaar
{
    // Instanzvariablen für das Wertepaar
    private int wertA;
    private int wertB;

    /**
     * Konstruktor für Objekte der Klasse WertePaar
     */
    public WertePaar()
    {
        // Instanzvariable initialisieren
        wertA = 0;
        wertB = 0;
    }
    /**
     * 2. Konstruktor für Objekte der Klasse WertePaar mit Parameterübergabe
     */
    public WertePaar(int initA, int initB)
    {
        // Instanzvariable initialisieren
        wertA = initA;
        wertB = initB;
    }
    /*
     * Wert des A-Wertes setzen
     */
    public void setzeWertA(int newWert){
        wertA = newWert;
    }
    /*
     * Wert des B-Wertes setzen
     */
    public void setzeWertB(int newWert){
        wertB = newWert;
    }
    /**
     * Prüfung auf gerade oder ungerade Zahl
     */
    public boolean isAeven(){
        
        return isEven(wertA);
        
    }
    public boolean isBeven(){
        
        return isEven(wertB);
        
    }
    /**
     * Summen-Methode
     */
    public int getAplusB()
    {
        int retValue = wertA + wertB;
        return retValue;
    }
    /**
     * Differenz A-B 
     */
    public int getAminusB()
    {
        int retValue = wertA - wertB;
        return retValue;
    }
    /**
     * Differenz B-A 
     */
    public int getBminusA()
    {
        int retValue = wertB - wertA;
        return retValue;
    }
    /**
     * Produkt A * B 
     */
    public long getAmalB()
    {
        long retValue = wertA * wertB;
        return retValue;
    }
    
    /**
     * Quotient A/B 
     */
    public double getAdurchB()
    {
        double retValue = (double)wertA/wertB;
        return retValue;
    }
    /**
     * Quotient B/A 
     */
    public double getBdurchA()
    {
        double retValue = (double)wertB/wertA;
        return retValue;
    }
    
    /**
     * A hoch B 
     */
    public double getAhochB(){
        return calcXhochY(wertA,wertB);
    }
     
    /**
     * B hoch A 
     */
    public double getBhochA(){
        return calcXhochY(wertB,wertA);
    }   
    
    private double calcXhochY(int x, int y){
        double retVal=0;
        boolean isYnegativ=false;
        // Erst einmal die Sonderfälle abfangen
        if (y == 0){
            retVal = 1;
        } else if (y == 1){
            retVal = x;
        } else {
            // Wenn b negativ ist, Flag setzen und in positiven Wert umwandeln
            if (y < 0){
                isYnegativ=true;
                y *= -1;
            }
            retVal=potenz(x,y);
            if (isYnegativ){
                retVal = 1/retVal;
            }
        }
        return retVal;
    }
    private boolean isEven(int tstVal){
        if (tstVal % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
    private double potenz(int a, int b){
        double retVal=(double)a;
        for (int i=1; i < b; i++){
            retVal *= a;
        }
        return retVal;
    }
    /**
     *
     *Alle Informationen über das Wertepaar
     */
    public void zeigeWerteInfo()
    {
        System.out.println("Information über das Objekt " + this.toString());
        System.out.println("-----------------------------------------------------------");
        System.out.println(" Wert A: " + wertA + " - gerade Zahl?: " + isAeven());
        System.out.println(" Wert B: " + wertB + " - gerade Zahl?: " + isBeven());
        System.out.println("  A + B: " + getAplusB());
        System.out.println("  A - B: " + getAminusB());
        System.out.println("  B - A: " + getBminusA());
        System.out.println("  A * B: " + getAmalB());
        System.out.println("  A / B: " + getAdurchB());
        System.out.println("  B / A: " + getBdurchA());
        System.out.println("  A ^ B: " + getAhochB());
        System.out.println("  B ^ A: " + getBhochA());
    }
}
