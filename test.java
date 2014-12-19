public class sample {
public interface Expression { public Lambda app(Expression exp); public String toString();}}
public static class Lam0 implements Expression {
public Lam0() {};
public Expression app(Expression e){ return Lam1(y, e)
public String toString() {
return '(\ x. ' + (new Lam1('y', null)).toString() + ')';}
public static class Lam1 implements Expression { protected String s_str;protected Expression s;
public Lam1(String s_str, Expression s) { this.s_str = s_str;this.s = s;}
public Expression app(Expression e){ return Lam2(z, e)
public String toString() {
return '(\ y. ' +(new lam2('z', e)).toString();+')'}}
public static class Lam2 implements Expression { protected String s_str;protected Expression s;
public Lam2(String s_str, Expression s) { this.s_str = s_str;this.s = s;}
public Expression app(Expression e){ return 'e.toStrig+abss.toString'
public String toString() {
if (s == null) return '\ z.((xy)z);
else return '\z. (' + x.toString() + ' (' + y.toString() + ' z))';}}
}
