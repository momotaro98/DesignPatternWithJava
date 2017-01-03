package state;

public class PausedState implements State{

    private Microwave microwave;

    public PausedState(Microwave _microwave){
        microwave = _microwave;
    }

    @Override
    public void start() {
        System.out.println("The microwave is resumed");
        microwave.setCurState(microwave.getWorkingState());
    }

    @Override
    public void pause() {
        System.out.println("The microwave is already paused");
        microwave.setCurState(microwave.getPausedState());
    }

    @Override
    public void stop() {
        System.out.println("The microwave is stopped");
        microwave.setCurState(microwave.getWaitingState());
    }
}
