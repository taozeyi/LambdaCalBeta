woqunimalegebi
public abstract class Expression {
    public Expression app(Expression exp){
        return new Application(exp,exp);
    }