package state;

public class Microwave {

    private State WaitingState;
    private State WorkingState;
    private State PausedState;

    private State curState;

    public Microwave() {
        // Microwaveのコンストラクタにおいて
        // microwaveを各Stateに委譲させる

        WaitingState = new WaitingState(this);
        WorkingState = new WorkingState(this);
        PausedState = new PausedState(this);

        // 現在の状態を示す変数
        curState = WaitingState;
    }

    // 外(Main)から使われるメソッド start, pause, stop
    public void start() {
        curState.start();
    }

    public void pause() {
        curState.pause();
    }

    public void stop() {
        curState.stop();
    }

    // 委譲されたStateインターフェースを実装したクラスが利用するメソッド
    // setCurState, getWorkingState, getWaitingState, getPausedState
    public void setCurState(State state){
        curState = state;
    }

    public State getWaitingState(){
        return WaitingState;
    }

    public State getWorkingState(){
        return WorkingState;
    }

    public State getPausedState(){
        return PausedState;
    }

}
