public class NextNumber {

    int val=0;
    boolean evenValue = false;
    public synchronized int getEvenValue() throws InterruptedException{
         while(!evenValue){
             wait();
         }
         val++;
         evenValue = false;
         notify();
         return val;
    }

    public synchronized int getOddValue() throws InterruptedException{

        while(evenValue ){
            wait();
        }
        val++;
        evenValue = true;
        notify();
        return val;
    }


    public static void main(String[] args) {
        NextNumber nextNumber = new NextNumber();
        Thread evenPrinterThread = new Thread(new EvenPrinter(nextNumber) , "EvenPrinterThread");
        Thread oddPrinterThread = new Thread(new OddPrinter(nextNumber), "OddPrinterThread");

        oddPrinterThread.start();
        evenPrinterThread.start();
    }

}
