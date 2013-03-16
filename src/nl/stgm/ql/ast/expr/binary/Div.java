package nl.stgm.ql.ast.expr.binary;
import nl.stgm.ql.ast.expr.*;

public class Div extends BinaryExpr
{
	public Div(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return "/";
	}
}
