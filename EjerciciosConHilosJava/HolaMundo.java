public class HolaMundo {
    public static void main(String[] args) {
        Thread hola = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    System.out.print(Thread.currentThread().getName());
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "Hola ");
        hola.start();

        Thread mundo = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    System.out.print(Thread.currentThread().getName());
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "Mundo! ");

        mundo.start();
    }
}
