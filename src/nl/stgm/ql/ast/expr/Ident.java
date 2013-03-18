package nl.stgm.ql.ast.expr;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Ident extends Expr
{
	private final String name;

	public Ident(String name)
	{
		this.name = name;
	}

	public String renderExpression()
	{
		return name;
	}

	public Type reduceType(TypeContext context)
	{
		// the semantic checker knowns our type from previous definitions
		return context.lookupType(this.name);
	}

	public LiteralExpr reduceValue(ValueContext context)
	{
		return context.lookupValue(name);
	}
}
