package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class Ident extends ASTExpressionNode
{
	private final String name;

	public Ident(String name)
	{
		this.name = name;
	}

	public String render()
	{
		return name;
	}

	public Type getType(TypeContext context)
	{
		// the semantic checker knowns our type from previous definitions
		return context.getType(this.name);
	}
	
	public void checkType(TypeCheckContext context)
	{
		return; // always OK
	}

	public Value getValue(ValueContext context)
	{
		// the semantic checker knowns our type from previous input
		return context.getValue(this.name);
	}
}
