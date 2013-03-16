package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.*;

public class CalcQuestion extends Question
{
	private Expr calculation;
	
	public CalcQuestion(String id, String question, String type, Expr calculation)
	{
		super(id, question, type);
		this.calculation = calculation;
	}

	public void print(PrettyPrinter context)
	{
		context.print(id + ": " + question + " " + type + " (");
		calculation.print(context);
		context.println(")");
	}

	public void check(SemanticChecker context)
	{
		System.out.println("CalcQ type" + this.toString());
		context.typeCheck(calculation);
	}
}
