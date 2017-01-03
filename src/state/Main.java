package state;

public class Main {

    public static void main(String[] args) {

        Microwave microwave = new Microwave();

        // API(この場合はMicrowave)を利用する側は
        // 内部の状態を気にすることなく、
        // APIのstart, pause, stopを使うだけで良い

        microwave.start();
		microwave.pause();
		microwave.stop();

		microwave.stop();

		microwave.start();
		microwave.pause();
		microwave.start();
		microwave.stop();
    }

}
