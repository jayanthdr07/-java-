class Time extends Thread {
    public void run() { 
        for(int  k=0;k>=0;k++){
             try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
            }
        
        for (int i = 0; i <= 60; i++) { // outer countdown (1 sec)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            for (int j = 0; j <= 10; j++) { 
                System.out.print("\r" +k+" : "+ i + " : " + j + "   "); // extra spaces to clear previous digits
                try {
                    Thread.sleep(100); // 0.1 sec delay
                } catch (InterruptedException e) {
                }
            }
        }
        }
        System.out.println("\nTime's up!");
    }

    public static void main(String[] args) {
        new Time().start();
    }
}

