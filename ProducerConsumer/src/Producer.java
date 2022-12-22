public class Producer implements  Runnable{

    Data data;
    public Producer(Data data) {
        this.data = data;
        new Thread(this, "Produer").start();
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            try {
                data.setData(i++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try{Thread.sleep(1000);} catch (Exception e){};
        }

    }
}
