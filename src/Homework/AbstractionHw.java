package OOP;
interface MathSolver{
     void  sum(Integer... numbers);
     void subtract(Integer a, Integer b);
     void multiply(Integer x, Integer y);

}

class MathSolverImp implements MathSolver{
    private Integer numbers;
    private Integer a,b;
    private Integer x,y;
    @Override
    public void sum(Integer... numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("Total sum is:"+sum);
    }
    @Override
    public void subtract(Integer a, Integer b) {
      this.a=a;
      this.b=b;
      this.numbers=a-b;
        System.out.println("Subtract is:"+this.numbers);
    }
    @Override
    public void multiply(Integer x, Integer y) {
     this.x=x;
     this.y=y;
     this.numbers=x*y;
        System.out.println("Multiply is:"+this.numbers);
    }
}

public class AbstractionHw {
    public static void main(String[] args) {
        MathSolver mathSolver = new MathSolverImp();
        mathSolver.sum(1,2,3,10);
        mathSolver.subtract(1,5);
        mathSolver.multiply(10,5);
    }
}
