public class NextNumber {

    int val=0;

    public synchronized int getEvenValue() throws InterruptedException{
         while(val%2 ==0){
             wait();
         }
         val++;
         notify();
         return val;
    }

    public synchronized int getOddValue() throws InterruptedException{

        while(val%2 ==1 ){
            wait();
        }
        val++;
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
