public class NumerosAsDes{

    public static void main(String[] args) {
        Thread ascedentes = new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i = 1; i < 100; i++){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "Ascedentes");
        ascedentes.start();

        Thread desendentes = new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i = 100; i > 1; i--){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "Descendentes");

        desendentes.start();
    }
}