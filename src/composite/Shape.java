package composite;

public interface Shape {
    // Shapeは、Picture(節), [Circle, Line, Rectangle](葉)を、
    // drow()メソッドが同等に呼べるという意味で、同一視する

    public void draw();
}
