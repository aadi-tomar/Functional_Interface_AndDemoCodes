public class Consumer implements Runnable {

    Data data;
    public Consumer(Data data) {
        this.data = data;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while(true){
            try {
                data.getData();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try{Thread.sleep(2000);} catch (Exception e){}
        }
    }
}
