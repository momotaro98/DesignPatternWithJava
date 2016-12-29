package composite;

public class Main {

    public static void main(String args[]) {
        // Pictureオブジェクトは、Shapeを実装した
        // オブジェクトのインスタンスを保持する

        Picture zoo_pic = new Picture("zoo");

        // add shapes(circle, rectangle, line) to picture
        zoo_pic.add(new Circle());
        zoo_pic.add(new Line());

        Picture lion_pic = new Picture("lion");
        lion_pic.add(new Rectangle());
        lion_pic.add(new Line());

        // add shapes(picture) to picture
        zoo_pic.add(lion_pic);

        // draw zoo_pic
        zoo_pic.draw();
    }
}
