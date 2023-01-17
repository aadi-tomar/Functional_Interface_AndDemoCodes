public class OddPrinter implements Runnable{

    private NextNumber nextNumber;

    public OddPrinter(NextNumber nextNumber) {
        this.nextNumber = nextNumber;
    }

    @Override
    public void run() {

        while(true){
            try {
                int value = nextNumber.getOddValue();
                System.out.println(Thread.currentThread().getName() + " printed value : " + value);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            try {Thread.sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }


    }
}
