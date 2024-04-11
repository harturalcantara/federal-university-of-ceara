class ThreadB extends Thread {
   
            int total;
            String h;
             @Override
             public void run(){
                 synchronized(this){
                 	System.out.println("Processo B, está aqui!");
                 	/*
                     for(int i=0; i<200 ; i++){
                         total += i;
                     }
                    */
                     h = "Hartur";
                     notify();
                 }
             }
   
  }