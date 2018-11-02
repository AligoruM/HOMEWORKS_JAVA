package Ball;

public class TestBall {
    public static void main(String[] args){
        Ball ball = new Ball(5,5,1,1,-45);
        Container cont = new Container(0,10, 20,20);
        System.out.println(cont);
        while(true){
            if (cont.colladesHeight(ball)){
                ball.reflectVertical();
            }
            if (cont.colladesWidth(ball)) {
                ball.reflectHorizontal();
            }
            ball.move();
            System.out.println(ball);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }

    }
}
